package com.game.www.wfcc.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.bean.Config;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;
import com.game.www.wfcc.util.ToolNetwork;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zhangdaweisir on 2017/6/4.
 */
public class WebActivity3 extends AppCompatActivity implements HanderLayout.TitleBottonLinstener {
    private WebView webview;
    private String objectUrl;
    private Dialog savedlg;
    private HanderLayout handerLayout;
    private int mo;
    private int mos;
    private boolean is = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //隐藏状态栏
//        //定义全屏参数
//        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
//        //获得当前窗体对象
//        Window window = getWindow();
//        //设置当前窗体为全屏显示
//        window.setFlags(flag, flag);
        setContentView(R.layout.activity_web_game);
        initView();
    }
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
    private ProgressBar proLoading;
    private Handler mHander;
    private void loginDialog() {
       // savedlg = ToolAlert.getLoading(this, "请稍等");
    }
private AudioManager mAudioManager;
    public void initView() {
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        handerLayout = (HanderLayout) findViewById(R.id.hander);
        handerLayout.setTitle(getIntent().getStringExtra("title"));
        mo = getIntent().getIntExtra("mo",0);
        mos = getIntent().getIntExtra("mos",-90);
        handerLayout.setOnClickListener(null);
        handerLayout.setVisibility(View.VISIBLE,View.VISIBLE,View.GONE,View.GONE,View.GONE);
        handerLayout.setBtnLinstener(this);
        webview = (WebView) findViewById(R.id.webView);
        webview = (WebView) findViewById(R.id.webView);
        proLoading = (ProgressBar) findViewById(R.id.proLoading);
        mHander = new Handler();
        if(!ToolNetwork.getInstance().init(this).isConnected()){
            webview.setVisibility(View.GONE);
            findViewById(R.id.tvNoDataMsg).setVisibility(View.VISIBLE);
        }
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) webview.getLayoutParams();
        params.setMargins(0, mo, 0, mos);
        if(mos > 0){
            params.setMargins(0, mos, 0, 0);
            is = false;
        }
        objectUrl = getIntent().getStringExtra("url");
        //objectUrl = PreferencesUtil.getUrl();
        initWebView();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        webview.reload();
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

        // 设置setWebChromeClient对象
        objectUrl = "http://flash1.7k7k.com/h5/2016/dc21d/index.html";
        if (!TextUtils.isEmpty(objectUrl)) {
            webview.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView view, String url) {
                    Log.d("WebView", "onPageFinished");
                    super.onPageFinished(view, url);
                    if (savedlg != null && savedlg.isShowing()) {
                        savedlg.dismiss();
                    }
                    String js =  baiduGgJs + funStr + "remaveByID('J-qike-h5-v1-mask');remaveByID('J-qike-h5-v1-load');";
                    view.loadUrl( js);
                    mHander.postDelayed(new Runnable() {
                        public void run() {
//                            String js =  baiduGgJs + funStr + "remaveByClass('topSwipeWrap relative_top topHiPos2');remaveByClass('iDialog iDialogNoTitle iDialogFreeBonus');remaveByClass('topSwipeWrap fixed_right_bottom topHiPos4');remaveByClass('awardBottom');";//remaveByClass('head-btn');remaveByClass('foot-tit');remaveByClass('foot');";
//                            view.loadUrl( js);
                            webview.setVisibility(View.VISIBLE);
                            proLoading.setVisibility(View.GONE);
                        }
                    }, 1500);
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
                    if(!is){

                        Intent intent = new Intent(WebActivity3.this, WebActivity3.class);
                        intent.putExtra("url",url);
                        intent.putExtra("mo",0);
                        intent.putExtra("mos",mos);
                        intent.putExtra("title",getIntent().getStringExtra("title"));
                        startActivity(intent);
//                        view.loadUrl(url);
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
private boolean isPause;
    @Override
    protected void onPause() {
        super.onPause();
        isPause = true;
        requestAudioFocus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPause = false;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview.destroy();
        mAudioManager.abandonAudioFocus(audioFocusChangeListener);
    }
    private void requestAudioFocus() {
        int result = mAudioManager.requestAudioFocus(audioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
        }
    }
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (isPause && focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                requestAudioFocus();
            }
        }
    };
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
    public void btnBack(View view){
        finish();
    }
}
