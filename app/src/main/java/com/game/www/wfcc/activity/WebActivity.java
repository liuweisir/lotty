package com.game.www.wfcc.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.bean.Config;
import com.game.www.wfcc.util.PreferencesUtil;
import com.game.www.wfcc.util.ToolAlert;

import cn.bmob.v3.listener.SaveListener;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by zhangdaweisir on 2017/6/4.
 */
public class WebActivity extends BaseActivity {
    public static boolean isForeground = false;
    private WebView webview;
    private String objectUrl;

    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    private Dialog savedlg;

    @Override
    public int bindLayout() {
        return R.layout.fragment_web;
    }

    private void loginDialog() {
        savedlg = ToolAlert.getLoading(this, "请稍等");
    }

    @Override
    public void initView(View view) {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String message = bundle.getString("cn.jpush.android.MESSAGE");
            if (!TextUtils.isEmpty(message)) {
                new AlertDialog.Builder(WebActivity.this).setTitle("消息").setMessage(message)
                        .setPositiveButton("确定", null).show();
            }

            String alert = bundle.getString("cn.jpush.android.ALERT");
            if (!TextUtils.isEmpty(alert)) {
                new AlertDialog.Builder(WebActivity.this).setTitle("消息").setMessage(alert)
                        .setPositiveButton("确定", null).show();
            }

        }
        webview = (WebView) findViewById(R.id.webView);
//        objectUrl = getIntent().getStringExtra("objectUrl");
        objectUrl = PreferencesUtil.getUrl();
        initWebView();
        registerMessageReceiver();
    }

    private void initWebView() {
        //设置打开的页面地址
        loginDialog();
        WebSettings webSettings = webview.getSettings();

        webview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    if (webview != null && webview.canGoBack()) {
                        webview.goBack();
                        return true;
                    }

                }
                return  false;
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            webSettings.setLoadsImagesAutomatically(true);
        } else {
            webSettings.setLoadsImagesAutomatically(false);
        }
        if (!webSettings.getLoadsImagesAutomatically()) {
            webSettings.setLoadsImagesAutomatically(true);
        }
        webSettings.setJavaScriptEnabled(true);
        //设置缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setDomStorageEnabled(true);
        if (!TextUtils.isEmpty(objectUrl)) {
            webview.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView view, String url) {
                    Log.d("WebView", "onPageFinished");
                    super.onPageFinished(view, url);
                    if (savedlg != null && savedlg.isShowing()) {
                        savedlg.dismiss();
                    }
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.contains(".apk")) {
                        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        if (in.resolveActivity(getPackageManager()) == null) {
                            //说明系统中不存在这个activity
                            view.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(WebActivity.this, "手机未安装下载软件", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                            startActivity(in);
                        }
                        return true;
                    } else {
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                }
            });
            //设置打开的页面地址
            webview.loadUrl(objectUrl);
        } else {
            webview.loadUrl("http://www.baidu.com");
        }
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private void createPerson() {
        final Config datas = new Config();
        datas.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
            }

            @Override
            public void onFailure(int i, String s) {

            }
        });
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(KEY_MESSAGE);
                    String extras = intent.getStringExtra(KEY_EXTRAS);
                    StringBuilder showMsg = new StringBuilder();
                    showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                    if (!TextUtils.isEmpty(extras)) {
                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }

    @Override
    public void resume() {
        isForeground = true;
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        isForeground = false;
        JPushInterface.onPause(this);
        super.onPause();
    }

    @Override
    public void destroy() {
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(mMessageReceiver);
    }
}
