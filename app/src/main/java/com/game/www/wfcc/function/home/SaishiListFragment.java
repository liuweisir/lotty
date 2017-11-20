package com.game.www.wfcc.function.home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.activity.SishiDetailActivity;
import com.game.www.wfcc.function.openLottery.adapter.SishiAdapter;
import com.game.www.wfcc.function.openLottery.bean.saishi.Data;
import com.game.www.wfcc.function.openLottery.bean.saishi.Root;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;

/**
 * Created by zhangdaweisir on 2017/6/7.
 */
public class SaishiListFragment extends BaseFragmentV4 implements OpenLotteryView {
    public static final String TAG = JingCaiOpenCodeForActivityFragment.class.getSimpleName();
    public static SaishiListFragment newInstance() {
        final SaishiListFragment f = new SaishiListFragment();
        return f;
    }
    private GridView mXListView;
    private Dialog savedlg;
    private SishiAdapter mAdapter;
    private HanderLayout mHander;
    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }
    public void initListView(View rootView){
        mAdapter = new SishiAdapter(getActivity());
        mXListView = (GridView) rootView.findViewById(R.id.xListView);
        mXListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(getActivity(), SishiDetailActivity.class);
                in.putExtra("id",((Data)mAdapter.getItem((int)id)).getSeasonid());
                startActivity(in);
            }
        });
        mXListView.setAdapter(mAdapter);
    }
    private OpenLotteryPrestener mOpenLotteryPrestener;
    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return R.layout.saishi_fragment;
    }

    @Override
    public void initView(View rootView) {
        loginDialog();
        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        mHander.setTitle("足球联赛");
        mHander.setmBtnTitleRightTextColor(R.color.loginout_red);
        initListView(rootView);
    }
    private PopupWindow pop;
    private RelativeLayout parView;

    @Override
    public void doBusiness(Context mContext) {
        mOpenLotteryPrestener.getSauShi();
    }

    @Override
    public void onSuccess(String json) {
        if (savedlg != null && savedlg.isShowing()) {
            savedlg.dismiss();
        }

        Root openCode = MyApplication.getInstance().getGson().fromJson(json, Root.class);
        if (openCode != null && openCode.getData() != null) {
            if (openCode.getData() != null) {
                mXListView.setVisibility(View.VISIBLE);
                mAdapter.clear();
                mAdapter.addItem(openCode.getData());
                mAdapter.notifyDataSetChanged();
                if(openCode.getData() == null || openCode.getData().size() == 0){
                    if (mAdapter.getPageNo() == mAdapter.getBeginPageNo()) {
                        mXListView.setVisibility(View.GONE);
                    }
                }
            } else {
                if (mAdapter.getPageNo() == mAdapter.getBeginPageNo()) {
                    mXListView.setVisibility(View.GONE);
                }
            }
        }
    }


    @Override
    public void onFailure(String msg) {

    }
}
