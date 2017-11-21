package com.game.www.wfcc.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.game.www.wfcc.MainActivity;
import com.game.www.wfcc.R;
import com.game.www.wfcc.function.home.FaXianFragment;
import com.game.www.wfcc.function.home.HomeAFragment;
import com.game.www.wfcc.function.home.HomeFragment;
import com.game.www.wfcc.function.home.JingCaiOpenCodeFragment;
import com.game.www.wfcc.function.home.OpenLotteryFragment;
import com.game.www.wfcc.function.home.OpenLotteryFragment2;
import com.game.www.wfcc.function.home.OpenLotteryFragment3;
import com.game.www.wfcc.function.home.RmenZixunFragment;
import com.game.www.wfcc.function.home.SaishiListFragment;
import com.game.www.wfcc.function.home.TuiJianForActivityFragment;
import com.game.www.wfcc.function.home.WebFragment;
import com.game.www.wfcc.function.home.Yuce2Fragment;
import com.game.www.wfcc.function.home.YuceFragment;
import com.game.www.wfcc.function.home.ZiXunFragment;
import com.game.www.wfcc.ui.HomeTabLayout;

/**
 * Created by Administrator on 2016/11/25.
 */
public class MainInitFrgmentLinstener implements HomeTabLayout.InitFrgmentLinstener {
    private MainActivity mainActivity;
    private Fragment mCurrentFragment;


    public MainInitFrgmentLinstener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void messageLinstener() {
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment openLotteryFragment =  fragmentManager.findFragmentByTag(HomeFragment.TAG);

        if (openLotteryFragment == null) {
            openLotteryFragment = WebFragment.newInstance("http://m.500.com/info/article/", "资讯", false, 100 , 0);
//            openLotteryFragment = WebFragment.newInstance("https://m.8win.com/info", "爆料", false, 20, 0);
//            openLotteryFragment = WebFragment.newInstance("http://m.cubegoal.com/index/rank/", "数据", false, 0, 0,false);
//            openLotteryFragment = HomeFragment.newInstance();
//            openLotteryFragment = HomeAFragment.newInstance();
            fragmentTransaction.add(R.id.fragmentView, openLotteryFragment, HomeFragment.TAG);
        }
        hideCurrentFragment(fragmentTransaction, openLotteryFragment);
        setCurrentFragment(openLotteryFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void mailListLinstener() {
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        WebFragment jingCaiOpenCodeFragment = (WebFragment) fragmentManager.findFragmentByTag(Yuce2Fragment.TAG);

        if (jingCaiOpenCodeFragment == null) {
//            jingCaiOpenCodeFragment = WebFragment.newInstance("http://5.9188.com/jcbf/", "比分", false, 10 , 0);
//            jingCaiOpenCodeFragment = WebFragment.newInstance("http://m.jc258.cn/data/recommendlist", "专家推荐", false, 20, 0);
            jingCaiOpenCodeFragment = WebFragment.newInstance("http://m.500.com/datachart/", "走势", false, 0 , -230);
//            jingCaiOpenCodeFragment = Yuce2Fragment.newInstance();
            fragmentTransaction.add(R.id.fragmentView, jingCaiOpenCodeFragment, Yuce2Fragment.TAG);
        }
        hideCurrentFragment(fragmentTransaction, jingCaiOpenCodeFragment);
        setCurrentFragment(jingCaiOpenCodeFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }


    @Override
    public void jobLinstener() {
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        WebFragment lanQiuOpenCodeFragment = (WebFragment) fragmentManager.findFragmentByTag(TuiJianForActivityFragment.TAG);

        if (lanQiuOpenCodeFragment == null) {

            lanQiuOpenCodeFragment = WebFragment.newInstance(" http://m.500.com/info/kaijiang/#h5", "开奖", true, -430,0);
//            lanQiuOpenCodeFragment = WebFragment.newInstance("http://5.9188.com/activity/ttjx/index.html", "推球", true, 0,0);
//            lanQiuOpenCodeFragment = FaXianFragment.newInstance();
            fragmentTransaction.add(R.id.fragmentView, lanQiuOpenCodeFragment, TuiJianForActivityFragment.TAG);
        }
        hideCurrentFragment(fragmentTransaction, lanQiuOpenCodeFragment);
        setCurrentFragment(lanQiuOpenCodeFragment);
        fragmentTransaction.commitAllowingStateLoss();


    }

    @Override
    public void myLinstener() {
        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FaXianFragment openLotteryFragment = (FaXianFragment) fragmentManager.findFragmentByTag(FaXianFragment.TAG);

        if (openLotteryFragment == null) {

            openLotteryFragment = FaXianFragment.newInstance();
//            fragmentTransaction.add(R.id.fragmentView, openLotteryFragment, FaXianFragment.TAG);
//            openLotteryFragment = WebFragment.newInstance("http://5.9188.com/yuce/", "预测", false, 0, 20);
            fragmentTransaction.add(R.id.fragmentView, openLotteryFragment, FaXianFragment.TAG);
        }
        hideCurrentFragment(fragmentTransaction, openLotteryFragment);
        setCurrentFragment(openLotteryFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void hideCurrentFragment(FragmentTransaction trans, Fragment fragment) {
        if (mCurrentFragment != null && mCurrentFragment != fragment) {
            trans.hide(mCurrentFragment);
            trans.show(fragment);
        }
    }

    private void setCurrentFragment(Fragment fragment) {
        mCurrentFragment = fragment;
    }
}
