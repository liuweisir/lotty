package com.game.www.wfcc.function.home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.activity.WebActivity2;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;
import com.game.www.wfcc.util.ToolNetwork;

/**
 * Created by zhangdaweisir on 2017/6/9.
 */
public class WebFragment extends BaseFragmentV4 implements View.OnClickListener {

    public static final String TAG = WebFragment.class.getSimpleName();


    public static WebFragment newInstance(String url,String title,boolean is , int mo , int mos , boolean is2) {
        final WebFragment f = new WebFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        args.putBoolean("is", is);
        args.putBoolean("is2", is2);
        args.putInt("mo", mo);
        args.putInt("mos", mos);
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }


    public static WebFragment newInstance(String url,String title,boolean is , int mo , int mos) {
        final WebFragment f = new WebFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        args.putBoolean("is", is);
        args.putBoolean("is2", true);
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
    private boolean is2;
    private int mo;
    private int mos;
    private TextView mTvNoDataMsg;
    private String jsStr = "javascript:function remaveByClass(className){" +
            "var tags=document.getElementsByTagName(\"*\");" +
            "for(var i in tags){" +
            "if(tags[i].nodeType==1){" +
            "if(tags[i].getAttribute(\"class\") == className){" +
            "tags[i].style.display = \"none\";" +
            "}" +
            "}" +
            "}" +
            "}" +
            " function remaveByID(id){var el = document.getElementById(id);if(el != null){el.parentNode.removeChild(el);}}";// + jsStr;
    private String funStr = "function remaveByClass(className){" +
            "var tags=document.getElementsByTagName(\"*\");" +
            "for(var i in tags){" +
            "if(tags[i].nodeType==1){" +
            "if(tags[i].getAttribute(\"class\") == className){" +
            "tags[i].style.display = \"none\";" +
            "}" +
            "}" +
            "}" +
            "}" +
            " function remaveByID(id){var el = document.getElementById(id);if(el != null){el.parentNode.removeChild(el);}}";// + jsStr;

    private String baiduGgJs= "javascript:(function(){var ele=document.getElementsByTagName(\"iframe\");for(var i=0;i<ele.length;i++){if(ele[i].src!=null&&ele[i].src.toLowerCase().indexOf(\"baidu\")!=-1||ele[i].onload!=null&&ele[i].onload.toString().toLowerCase().indexOf(\"baidu\")!=-1){ele[i].parentNode.removeChild(ele[i]);i--}}})();";
    private ProgressBar proLoading;
    @Override
    public int bindLayout() {
        return R.layout.activity_web;
    }

    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }
    private  RelativeLayout.LayoutParams params;
    private  RelativeLayout.LayoutParams params2;
    @Override
    public void initView(View view) {
        objectUrl= getArguments().getString("url");
        title= getArguments().getString("title");
        mo= getArguments().getInt("mo",-30);
        mos = getArguments().getInt("mos",0);
        is= getArguments().getBoolean("is",true);
        proLoading = (ProgressBar) view.findViewById(R.id.proLoading);
        is2= getArguments().getBoolean("is2",true);
        mHander = (HanderLayout) view.findViewById(R.id.hander);
        mTvNoDataMsg = (TextView) view.findViewById(R.id.tvNoDataMsg);
        mHander.setOnClickListener(null);
        mHander.setTitle(title);
        mHander.setVisibility(View.VISIBLE,View.GONE, View.GONE,View.GONE,View.GONE);
        webview = (WebView) view.findViewById(R.id.webView);
        if(!ToolNetwork.getInstance().init(getActivity()).isConnected()){
            webview.setVisibility(View.GONE);
            view.findViewById(R.id.tvNoDataMsg).setVisibility(View.VISIBLE);
            proLoading.setVisibility(View.GONE);
            return;
        }
        params = (RelativeLayout.LayoutParams) webview.getLayoutParams();
        params.setMargins(0, mo, 0, 0);
        webview.setLayoutParams(params);
        params2 = (RelativeLayout.LayoutParams) webview.getLayoutParams();
//        objectUrl = getIntent().getStringExtra("objectUrl");
      // objectUrl = PreferencesUtil.getUrl();
        initWebView();
    }

    @Override
    public void doBusiness(Context mContext) {

    }
    private boolean falg = false;
    private void initWebView() {
        //设置打开的页面地址
//        loginDialog();
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
//        webSettings.setDomStorageEnabled(true);
        if (!TextUtils.isEmpty(objectUrl)) {
            webview.setWebViewClient(new WebViewClient() {
                public void onPageFinished(final WebView view, String url) {
                    Log.d("WebView", "onPageFinished");
                    super.onPageFinished(view, url);
                    String js =  baiduGgJs + funStr + "remaveByClass('header');remaveByID('img-slider');remaveByClass('go-zhishi');remaveByClass('menus');remaveByClass('footer');remaveByClass('header');";
                    view.loadUrl( js);
                    mHander.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (savedlg != null && savedlg.isShowing()) {
                                savedlg.dismiss();
                            }
                            webview.setVisibility(View.VISIBLE);
                            proLoading.setVisibility(View.GONE);
                        }
                    },1000);

//足球魔方很难调试
//                    final String js =  jsStr + "remaveByClass('div_table buybar2');remaveByClass('fixfooter');remaveByClass('m-latematch');remaveByClass('all-download');remaveByClass('m-header');remaveByClass('news-content');remaveByClass('train-content');remaveByClass('news-panel');$('div.detail-ad').children('a').css('display','none');";
//
////                    icon
////                    icon-red-btn
//                    mHander.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            if (savedlg != null && savedlg.isShowing()) {
//                                savedlg.dismiss();
//                            }
//                            view.loadUrl( js);
//                            webview.setVisibility(View.VISIBLE);
//                            proLoading.setVisibility(View.GONE);
//                        }
//                    },1500);


                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    webview.setVisibility(View.GONE);
                    proLoading.setVisibility(View.VISIBLE);
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
                    if(!ToolNetwork.getInstance().init(getActivity()).isConnected()){
                        webview.setVisibility(View.GONE);
                        mTvNoDataMsg.setVisibility(View.VISIBLE);
                    }else{
                        webview.setVisibility(View.VISIBLE);
                        mTvNoDataMsg.setVisibility(View.GONE);
                    }
                    if( url.indexOf("recommendlist")>-1 || url.indexOf("appinfo") > -1 || url.indexOf("AppInfo") > -1 ){
                        view.loadUrl(url);
                        return true;
                    }
                    if(!is){
                        if(is2){
                            Intent intent = new Intent(getActivity(), WebActivity2.class);
                            intent.putExtra("url",url);
                            intent.putExtra("mo",0);
                            intent.putExtra("mos",mos);
                            intent.putExtra("title",title + "详情");
                            startActivity(intent);
                        }else{
                            view.loadUrl(url);
                        }
//
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
}
