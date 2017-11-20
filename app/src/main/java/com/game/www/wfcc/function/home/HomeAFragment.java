package com.game.www.wfcc.function.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.game.www.wfcc.R;
import com.game.www.wfcc.activity.BaoLiaoWebActivity2;
import com.game.www.wfcc.activity.BiFenWebActivity;
import com.game.www.wfcc.activity.BsshuoWebActivity2;
import com.game.www.wfcc.activity.CommonWebActivity;
import com.game.www.wfcc.activity.KaiJWebActivity;
import com.game.www.wfcc.activity.LrWebActivity;
import com.game.www.wfcc.activity.MoFangWebActivity;
import com.game.www.wfcc.activity.ShaMWebActivity;
import com.game.www.wfcc.activity.ShangTWebActivity;
import com.game.www.wfcc.activity.TuiQiuWebActivity2;
import com.game.www.wfcc.activity.WebActivity2;
import com.game.www.wfcc.activity.WucAWebActivity;
import com.game.www.wfcc.activity.XdWebActivity;
import com.game.www.wfcc.activity.XueTangWebActivity;
import com.game.www.wfcc.activity.YuceWebActivity;
import com.game.www.wfcc.activity.ZSWebActivity;
import com.game.www.wfcc.activity.ZqZsWebActivity;
import com.game.www.wfcc.activity.ZuqiuZsWebActivity;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.function.openLottery.activity.RemenActivity;
import com.game.www.wfcc.function.openLottery.activity.TuijianActivity;
import com.game.www.wfcc.function.openLottery.activity.ZuqiuActivity;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolToast;

/**
 * Created by zhangdaweisir on 2017/6/9.
 */
public class HomeAFragment extends BaseFragmentV4{

    public static final String TAG = HomeAFragment.class.getSimpleName();
    private HanderLayout mHander;


    public static HomeAFragment newInstance() {
        final HomeAFragment f = new HomeAFragment();
        return f;
    }
    @Override
    public int bindLayout() {
        return R.layout.fragment_home_a;
    }

    @Override
    public void initView(View view) {
        mHander = (HanderLayout) view.findViewById(R.id.hander);
        mHander.setTitle("首页");
        mHander.setVisibility(View.VISIBLE,View.GONE, View.GONE,View.GONE,View.GONE);

        view.findViewById(R.id.btnSSQ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonWebActivity.class);
                intent.putExtra("title","双色球");
                intent.putExtra("url","http://m.500.com/datachart/ssq/jb.html");
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btn3D).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonWebActivity.class);
                intent.putExtra("title","福彩3D");
                intent.putExtra("url","http://m.500.com/datachart/sd/jb.html");
                startActivity(intent);
            }

        });
        view.findViewById(R.id.btnDLT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonWebActivity.class);
                intent.putExtra("title","超级大乐透");
                intent.putExtra("url","http://m.500.com/datachart/dlt/jb.html");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btnPL3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonWebActivity.class);
                intent.putExtra("title","排列三");
                intent.putExtra("url","http://m.500.com/datachart/pls/jb.html");
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btn7XC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonWebActivity.class);
                intent.putExtra("title","七星彩");
                intent.putExtra("url","http://m.500.com/datachart/qxc/zx/0.html");
                startActivity(intent);
            }

        });
        view.findViewById(R.id.btn7LC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonWebActivity.class);
                intent.putExtra("title","七乐彩");
                intent.putExtra("url","http://m.500.com/datachart/qlc/jb.html");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btnLr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LrWebActivity.class);
                startActivity(intent);
            }

        });
        view.findViewById(R.id.btnZs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZSWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnZshu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZqZsWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnYc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YuceWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnMf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoFangWebActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.btnZx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZuqiuZsWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnSm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShaMWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnTq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TuiQiuWebActivity2.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnXt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XueTangWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnSt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShangTWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnWc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WucAWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnXd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XdWebActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.btnWanFaShuoMing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonWebActivity.class);
                intent.putExtra("title","欧冠联赛");
                intent.putExtra("url","http://live.m.500.com/detail/football/698138/analysis/zj?render=local");
                startActivity(intent);
            }
        });

    }

    @Override
    public void doBusiness(Context mContext) {

    }

}
