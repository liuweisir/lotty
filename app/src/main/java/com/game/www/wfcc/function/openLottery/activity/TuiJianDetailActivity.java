package com.game.www.wfcc.function.openLottery.activity;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolNetwork;

/**
 * Created by Administrator on 2017/6/3.
 */
public class TuiJianDetailActivity extends BaseActivity implements HanderLayout.TitleBottonLinstener {
    private HanderLayout mHander;
    private WebView webView;
    private int id;
    @Override
    public int bindLayout() {
        return  R.layout.activity_tui_jian_detail;
    }
    public void initHander(){
        this.mHander = (HanderLayout) findViewById(R.id.hander);
        mHander.setTitle("推荐详情");
        mHander.setVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        mHander.setBtnLinstener(this);
    }
    @Override
    public void initView(View view) {
        id = getIntent().getIntExtra("rId",0);
        initHander();
        webView = (WebView) findViewById(R.id.webView);
        if(!ToolNetwork.getInstance().init(this).isConnected()){
            webView.setVisibility(View.GONE);
            findViewById(R.id.tvNoDataMsg).setVisibility(View.VISIBLE);
        }
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setDefaultTextEncodingName("utf-8");
        //设置打开的页面地址
        webView.loadUrl("http://client.310win.com/aspx/RecommendDetail.aspx?id=" + id);
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
