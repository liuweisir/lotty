package com.game.www.wfcc;


import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.common.MainInitFrgmentLinstener;
import com.game.www.wfcc.ui.HomeTabLayout;
import com.game.www.wfcc.util.PreferencesUtil;

public class MainActivity extends BaseActivity {
    private HomeTabLayout mHomeTabLayout;
    @Override
    public int bindLayout() {
        setAllowBack(false);
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        mHomeTabLayout = (HomeTabLayout) findViewById(R.id.homeTabLayout);
        mHomeTabLayout.setVisibility(View.VISIBLE);
        findViewById(R.id.fragmentView).setVisibility(View.VISIBLE);
        mHomeTabLayout.setFrgmentLinstener(new MainInitFrgmentLinstener(MainActivity.this));
//        if(!PreferencesUtil.isBanSpeech2()){
//            new AlertDialog.Builder(MainActivity.this).setTitle("消息").setMessage("本应用只提供数据查询功能，无任何支付购买功能，请放心使用")
//                    .setPositiveButton("确定", null).show();
//            PreferencesUtil.banSpeech2(true);
//        }
    }
    @Override
    public void doBusiness(Context mContext) {

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

}
