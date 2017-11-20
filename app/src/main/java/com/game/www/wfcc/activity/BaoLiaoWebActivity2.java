package com.game.www.wfcc.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.bean.Config;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;
import com.game.www.wfcc.util.ToolNetwork;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zhangdaweisir on 2017/6/4.
 */
public class BaoLiaoWebActivity2 extends BaseActivity implements HanderLayout.TitleBottonLinstener {
    private WebView webview;
    private String objectUrl;
    private Dialog savedlg;
    private HanderLayout handerLayout;
    private int mo;
    private int mos;
    private boolean is = false;
    private TextView tvNoDataMag;

    private ProgressBar proLoading;
    private String jsStr = "javascript:function remaveByClass(className){" +
            "var tags=document.getElementsByTagName(\"*\");" +
            "for(var i in tags){" +
            "if(tags[i].nodeType==1){" +
            "if(tags[i].getAttribute(\"class\") == className){" +
            "tags[i].parentNode.removeChild(tags[i]);" +
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
            "tags[i].parentNode.removeChild(tags[i]);" +
            "}" +
            "}" +
            "}" +
            "}" +
            " function remaveByID(id){var el = document.getElementById(id);if(el != null){el.parentNode.removeChild(el);}}";// + jsStr;
    private String baiduGgJs = "javascript:(function()" +
            "{" +
            "var ele=document.getElementsByTagName(\"iframe\");" +
            "for(var i=0;i<ele.length;i++)" +
            "{" +
            "if((ele[i].src!=null&&ele[i].src.toLowerCase().indexOf(\"baidu\")!=-1)" +
            "||(ele[i].onload!=null&&ele[i].onload.toString().toLowerCase().indexOf(\"baidu\")!=-1))" +
            "{" +
            "ele[i].parentNode.removeChild(ele[i]);i--;" +
            "}" +
            "}" +
            "ele=document.getElementsByTagName(\"div\");" +
            "for(var i=0;i<ele.length;i++)" +
            "{" +
            "if((ele[i].src!=null&&ele[i].src.toLowerCase().indexOf(\"baidu\")!=-1)" +
            "||(ele[i].onload!=null&&ele[i].onload.toString().toLowerCase().indexOf(\"baidu\")!=-1))" +
            "{" +
            "ele[i].parentNode.removeChild(ele[i]);i--;" +
            "}" +
            "}" +
            "}" +

            ")();";

    @Override
    public int bindLayout() {
        return R.layout.activity_web_2;
    }

    private void loginDialog() {
        savedlg = ToolAlert.getLoading(this, "请稍等");
    }

    private Handler mHander;

    @Override
    public void initView(View view) {
        handerLayout = (HanderLayout) view.findViewById(R.id.hander);
        handerLayout.setTitle("足球爆料");
        mo = getIntent().getIntExtra("mo", 0);
        mos = getIntent().getIntExtra("mos", -90);
        mHander = new Handler();
        proLoading = (ProgressBar) view.findViewById(R.id.proLoading);
        handerLayout.setOnClickListener(null);
        tvNoDataMag = (TextView) findViewById(R.id.tvNoDataMsg);
        handerLayout.setVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        handerLayout.setBtnLinstener(this);
        webview = (WebView) findViewById(R.id.webView);

        webview = (WebView) view.findViewById(R.id.webView);
        if (!ToolNetwork.getInstance().init(this).isConnected()) {
            webview.setVisibility(View.GONE);
            view.findViewById(R.id.tvNoDataMsg).setVisibility(View.VISIBLE);
        }
//        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) webview.getLayoutParams();
//        params.setMargins(0, mo, 0, mos);
//        if (mos != 0) {
//            params.setMargins(0, mos, 0, 0);
//            is = false;
//        }
        objectUrl = getIntent().getStringExtra("url");
        //objectUrl = PreferencesUtil.getUrl();
        initWebView();
    }

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
                return false;
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
        WebChromeClient wvcc = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//                try {
//                    title = title.substring(0, title.indexOf("_"));
//                    handerLayout.setTitle(title);
//                } catch (Exception e) {
////                    ToolToast.showErrorShort("该板块在维护中");
////                    finish();
//                }
//                handerLayout.setTitle(title);
            }
        };
        // 设置setWebChromeClient对象
        webview.setWebChromeClient(wvcc);
        objectUrl = "http://m.7m.com.cn/expert/expert_list.html";
        if (!TextUtils.isEmpty(objectUrl)) {
            webview.setWebViewClient(new WebViewClient() {
                public void onPageFinished(final WebView view, String url) {
                    Log.d("WebView", "onPageFinished");
//                    String js = "javascript:function aa(className){" +
//                            "var tags=document.getElementsByTagName(\"*\");" +
//                            "for(var i in tags){" +
//                            "if(tags[i].nodeType==1){" +
//                            "if(tags[i].getAttribute(\"class\") == className){" +
//                            "tags[i].style.display = \"none\";" +
//                            "}" +
//                            "}" +
//                            "}" +
//                            "} aa('red');";// + jsStr;
                    //final String js =  jsStr + "remaveByClass('game_ad_box');remaveByClass('game_ad_box');remaveByClass('banner');remaveByID('adimg');remaveByClass('container');";
                    super.onPageFinished(view, url);
//                    final String js =  baiduGgJs + funStr + "remaveByClass('getmorelist');remaveByClass('comment-list-hd');remaveByClass('loadp');remaveByClass('user-detail');remaveByClass('attention none');remaveByID('postdiv_1_4');remaveByClass('comment-ft');remaveByClass('interact');remaveByClass('btm-bar');remaveByClass('kj-b');remaveByClass('nav');$('div.w320').find('a').remove();remaveByClass('head-btn');remaveByClass('foot-tit');remaveByClass('foot');";
//                    view.loadUrl(js);
//                    String js =  baiduGgJs + funStr + "remaveByClass('btn-match');if($('nav') != null){$('nav').remove();}if($('h1') != null){$('h1').remove();}remaveByClass('slide');remaveByClass('tabs');remaveByClass('mod-nav sub-nav');remaveByClass('m-detail-top-nav');remaveByClass('top-tips');if($('nav') != null){$('nav').remove();}if($('h1') != null){$('h1').remove();}remaveByClass('slide');remaveByClass('tabs');remaveByClass('mod-nav sub-nav');remaveByClass('m-detail-top-nav');remaveByClass('top-tips');";
//                    view.loadUrl( js);
                    mHander.postDelayed(new Runnable() {
                        public void run() {
//                            String js =  baiduGgJs + funStr + "remaveByClass('topSwipeWrap relative_top topHiPos2');remaveByClass('iDialog iDialogNoTitle iDialogFreeBonus');remaveByClass('topSwipeWrap fixed_right_bottom topHiPos4');remaveByClass('awardBottom');";//remaveByClass('head-btn');remaveByClass('foot-tit');remaveByClass('foot');";
//                            view.loadUrl( js);
                            webview.setVisibility(View.VISIBLE);
                            proLoading.setVisibility(View.GONE);
                        }
                    }, 1500);

//足球魔方很难调试
//                    mHander.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            view.loadUrl( jsStr + "remaveByClass('fixed kjFloat');remaveByClass('ops-btn');remaveByClass('m-header');remaveByClass('news-content');remaveByClass('train-content');remaveByClass('news-panel');");
//                            if (savedlg != null && savedlg.isShowing()) {
//                                savedlg.dismiss();
//                            }
//                            webview.setVisibility(View.VISIBLE);
//                            proLoading.setVisibility(View.GONE);
//                        }
//                    }, 1500);
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    // loginDialog();
                    webview.setVisibility(View.GONE);
                    proLoading.setVisibility(View.VISIBLE);
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (!is) {
//                        Intent intent = new Intent(WebActivity2.this, WebActivity2.class);
//                        intent.putExtra("url",url);
//                        intent.putExtra("mo",0);
//                        intent.putExtra("mos",mos);
//                        intent.putExtra("title",getIntent().getStringExtra("title"));
//                        startActivity(intent);
                        view.loadUrl(url);
                    }
                    return is;
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

    @Override
    public void resume() {

    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void imgLeftLinstener(View v) {
        finish();
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

    public void btnBack(View view) {
        finish();
    }
}
