package com.game.www.wfcc.function.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.function.openLottery.activity.RemenActivity;
import com.game.www.wfcc.function.openLottery.activity.TuijianActivity;
import com.game.www.wfcc.function.openLottery.activity.ZuqiuActivity;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolToast;

/**
 * Created by zhangdaweisir on 2017/6/9.
 */
public class FaXianFragment extends BaseFragmentV4 implements View.OnClickListener {

    public static final String TAG = FaXianFragment.class.getSimpleName();
    private HanderLayout mHander;


    public static FaXianFragment newInstance() {
        final FaXianFragment f = new FaXianFragment();
        return f;
    }
    @Override
    public int bindLayout() {
        return R.layout.fragment_fa_xian;
    }

    @Override
    public void initView(final View view) {
        mHander = (HanderLayout) view.findViewById(R.id.hander);
        mHander.setTitle("设置");
        mHander.setVisibility(View.VISIBLE,View.GONE, View.GONE,View.GONE,View.GONE);
        view.findViewById(R.id.layoutZuqiu).setOnClickListener(this);
        view.findViewById(R.id.layoutLanqiu).setOnClickListener(this);
        view.findViewById(R.id.layoutSaiShi).setOnClickListener(this);
        view.findViewById(R.id.layoutGod).setOnClickListener(this);
        view.findViewById(R.id.layoutHuanc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolToast.showShort("清除成功");
                ((TextView)view.findViewById(R.id.cache)).setText("0.0K");
            }
        });
        view.findViewById(R.id.layoutBanben).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolToast.showShort("已经是最新版本了");
            }
        });
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layoutZuqiu:
                Intent intent = new Intent(getActivity(), ZuqiuActivity.class);
                startActivity(intent);
                break;
            case R.id.layoutSaiShi:
                intent = new Intent(getActivity(), RemenActivity.class);
                startActivity(intent);
                break;
            case R.id.layoutGod:
                intent = new Intent(getActivity(), TuijianActivity.class);
                startActivity(intent);
                break;
        }

    }
}
