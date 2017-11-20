package com.game.www.wfcc.function.openLottery.activity;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.ui.HanderLayout;

/**
 * Created by Administrator on 2017/6/3.
 */
public class ZoushiDetailActivity extends BaseActivity implements HanderLayout.TitleBottonLinstener {
    private HanderLayout mHander;
    private WebView webView;
    private String title;
    private String url;
    @Override
    public int bindLayout() {
        return  R.layout.activity_zoushi_detail;
    }
    public void initHander(){
        this.mHander = (HanderLayout) findViewById(R.id.hander);
        mHander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mHander.setTitle(title);
        mHander.setVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        mHander.setBtnLinstener(this);
    }
    @Override
    public void initView(View view) {
        title = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");
        initHander();
        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setDefaultTextEncodingName("utf-8");
        //设置打开的页面地址
        webView.loadUrl(url);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void resume() {

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
}
