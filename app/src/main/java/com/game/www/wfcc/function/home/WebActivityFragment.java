package com.game.www.wfcc.function.home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.game.www.wfcc.R;
import com.game.www.wfcc.activity.WebActivity2;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;
import com.game.www.wfcc.util.ToolNetwork;

/**
 * Created by zhangdaweisir on 2017/6/9.
 */
public class WebActivityFragment extends BaseFragmentV4 implements View.OnClickListener, HanderLayout.TitleBottonLinstener {

    public static final String TAG = WebActivityFragment.class.getSimpleName();


    public static WebActivityFragment newInstance(String url, String title, boolean is , int mo , int mos) {
        final WebActivityFragment f = new WebActivityFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        args.putBoolean("is", is);
        args.putInt("mo", mo);
        args.putInt("mos", mos);
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }
    private WebView webview;
    private String objectUrl;
    private Dialog savedlg;
    private HanderLayout mHander;
    private String title;
    private boolean is;
    private int mo;
    private int mos;
    @Override
    public int bindLayout() {
        return R.layout.activity_web;
    }

    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }


    @Override
    public void initView(View view) {
        objectUrl= getArguments().getString("url");
        title= getArguments().getString("title");
        mo= getArguments().getInt("mo",-30);
        mos = getArguments().getInt("mos",0);
        is= getArguments().getBoolean("is",true);
        mHander = (HanderLayout) view.findViewById(R.id.hander);
        mHander.setOnClickListener(null);
        mHander.setTitle(title);
        mHander.setVisibility(View.VISIBLE,View.VISIBLE, View.GONE,View.GONE,View.GONE);
        mHander.setBtnLinstener(this);
        webview = (WebView) view.findViewById(R.id.webView);
        if(!ToolNetwork.getInstance().init(getActivity()).isConnected()){
            webview.setVisibility(View.GONE);
            view.findViewById(R.id.tvNoDataMsg).setVisibility(View.VISIBLE);
        }
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) webview.getLayoutParams();
        params.setMargins(0, mo, 0, 0);
        webview.setLayoutParams(params);
//        objectUrl = getIntent().getStringExtra("objectUrl");
      // objectUrl = PreferencesUtil.getUrl();
        initWebView();
    }

    @Override
    public void doBusiness(Context mContext) {

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
//                    if (url.contains(".apk")) {
//                        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                        if (in.resolveActivity(getPackageManager()) == null) {
//                            //说明系统中不存在这个activity
//                            view.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(WebActivity.this, "手机未安装下载软件", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                        } else {
//                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//                            startActivity(in);
//                        }
//                        return true;
//                    } else {
//                        return super.shouldOverrideUrlLoading(view, url);
//                    }
                    //view.loadUrl(url);
                    if(!is){
                        Intent intent = new Intent(getActivity(), WebActivity2.class);
                        intent.putExtra("url",url);
                        intent.putExtra("mo",10);
                        intent.putExtra("mos",mos);
                        intent.putExtra("title",title + "详情");
                        startActivity(intent);
                    }
                    return true;
                }
            });
            //设置打开的页面地址
           webview.loadUrl(objectUrl);
        } else {
           // webview.loadUrl("http://www.baidu.com");
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void imgLeftLinstener(View v) {
        getActivity().finish();
    }

    @Override
    public void imgRightLinstener(View v) {

    }

    @Override
    public void btnLeftLinstener(View v) {

    }

    @Override
    public void btnRightLinstener(View v) {

    }
}
