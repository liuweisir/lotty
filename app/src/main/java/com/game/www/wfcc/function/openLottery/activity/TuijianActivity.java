package com.game.www.wfcc.function.openLottery.activity;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.function.home.TuiJianForActivityFragment;

/**
 * Created by zhangdaweisir on 2017/6/5.
 */
public class TuijianActivity extends BaseActivity {
    @Override
    public int bindLayout() {
        return R.layout.activity_jingcai;
    }

    @Override
    public void initView(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //然后，你能够使用add()方法把Fragment添加到指定的视图中，如：
        TuiJianForActivityFragment fragment = new TuiJianForActivityFragment();
        fragmentTransaction.add(R.id.fragmentView, fragment);
        fragmentTransaction.commit();
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
}
