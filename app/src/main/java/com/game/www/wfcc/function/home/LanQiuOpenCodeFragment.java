package com.game.www.wfcc.function.home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.activity.TuiJianDetailActivity;
import com.game.www.wfcc.function.openLottery.adapter.TuiJianAdapter;
import com.game.www.wfcc.function.openLottery.bean.QueryTuiJian;
import com.game.www.wfcc.function.openLottery.bean.tuijian.Data;
import com.game.www.wfcc.function.openLottery.bean.tuijian.Root;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.ui.XListView;
import com.game.www.wfcc.util.ToolAlert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhangdaweisir on 2017/6/1.
 */
public class LanQiuOpenCodeFragment extends BaseFragmentV4 implements OpenLotteryView, XListView.IXListViewListener, AdapterView.OnItemClickListener {
    public static final String TAG = LanQiuOpenCodeFragment.class.getSimpleName();
    public static LanQiuOpenCodeFragment newInstance() {
        final LanQiuOpenCodeFragment f = new LanQiuOpenCodeFragment();
        return f;
    }
    private XListView mXListView;
    private Handler mHandler;
    private Date reflashDate = new Date();
    private SimpleDateFormat HourMinuteOfDayFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private TextView mTvNoDataMsg;
    private Dialog savedlg;
    private TuiJianAdapter mAdapter;
    private HanderLayout mHander;
    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }
    public void initListView(View rootView){
        mAdapter = new TuiJianAdapter(getActivity());
        mHandler = new Handler();
        mXListView = (XListView) rootView.findViewById(R.id.xListView);
        mXListView.setPullLoadEnable(true);
        mXListView.setXListViewListener(this);
        mXListView.setOnItemClickListener(this);
        mXListView.setPullRefreshEnable(true);
        mXListView.setRefreshTime("今天：" + HourMinuteOfDayFormat.format(reflashDate));
        mXListView.setAdapter(mAdapter);
        mTvNoDataMsg = (TextView) rootView.findViewById(R.id.tvNoDataMsg);
    }
    private OpenLotteryPrestener mOpenLotteryPrestener;
    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return R.layout.fragment_tuijian_open_code;
    }

    @Override
    public void initView(View rootView) {
        loginDialog();
        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        mHander.setTitle("竞彩推荐");
        initListView(rootView);
    }

    @Override
    public void doBusiness(Context mContext) {
        mOpenLotteryPrestener.selectTuijian(new QueryTuiJian(0,20));
    }

    @Override
    public void onSuccess(String json) {
        if (savedlg != null && savedlg.isShowing()) {
            savedlg.dismiss();
        }
        Root root = MyApplication.getInstance().getGson().fromJson(json,Root.class);
        if (root != null && root.getData() != null) {
            if (root != null && root.getData() != null) {
                mXListView.setVisibility(View.VISIBLE);
                mTvNoDataMsg.setVisibility(View.GONE);
                mAdapter.addItem(root.getData());
                mAdapter.notifyDataSetChanged();
                if(root.getData() == null || root.getData().size() == 0){
                    if (mAdapter.getPageNo() == mAdapter.getBeginPageNo()) {
                        mXListView.setVisibility(View.GONE);
                        mTvNoDataMsg.setVisibility(View.VISIBLE);
                    }
                }
            } else {
                if (mAdapter.getPageNo() == mAdapter.getBeginPageNo()) {
                    mXListView.setVisibility(View.GONE);
                    mTvNoDataMsg.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public void onFailure(String msg) {

    }

    @Override
    public void onRefresh() {
        reflashDate = new Date();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAdapter.getCount() > 0) {
                    mAdapter.clear();
                }
                mOpenLotteryPrestener.selectTuijian(new QueryTuiJian(0,20));
                onLoad();
            }
        }, 1000);
    }
    private void onLoad() {
        mXListView.stopRefresh();
        mXListView.stopLoadMore();
        mXListView.setRefreshTime("今天：" + HourMinuteOfDayFormat.format(reflashDate));
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mOpenLotteryPrestener.selectTuijian(new QueryTuiJian(mAdapter.getPageNo(),20));
                onLoad();
            }
        }, 1000);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity() , TuiJianDetailActivity.class);
        Data date = (Data) mAdapter.getItem((int) id);
        int rid =  date.getRecommendInfo().getId();
        intent.putExtra("rId" ,rid);
        startActivity(intent);
    }
}
