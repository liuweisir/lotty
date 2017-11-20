package com.game.www.wfcc.function.openLottery.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.adapter.OpenCodeAdapter;
import com.game.www.wfcc.function.openLottery.bean.Detail;
import com.game.www.wfcc.function.openLottery.bean.Detail_list;
import com.game.www.wfcc.function.openLottery.bean.OpenCode;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryQuery;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.ui.XListView;
import com.game.www.wfcc.util.ToolAlert;
import com.game.www.wfcc.util.ToolToast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/6/1.
 */
public class OpenCodeListActivity extends BaseActivity implements OpenLotteryView, XListView.IXListViewListener, AdapterView.OnItemClickListener, HanderLayout.TitleBottonLinstener {


    private OpenLotteryPrestener mOpenLotteryPrestener;

    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return  R.layout.activity_select_check_house_list;
    }
    private OpenCodeAdapter mAdapter;

    private OpenLotteryEnum lotteryEnum;

    private HanderLayout mHander;
    private XListView mXListView;
    private TextView mTvNoDataMsg;
    private Handler mHandler;
    private Date reflashDate = new Date();
    private SimpleDateFormat HourMinuteOfDayFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private Dialog savedlg;

    @Override
    public void initView(View view) {
        lotteryEnum = (OpenLotteryEnum) getIntent().getSerializableExtra("lotteryEnum");
        initHander();
        initListView();
        loginDialog();
    }
    @Override
    public void doBusiness(Context mContext) {
        OpenLotteryQuery.Head head = new OpenLotteryQuery.Head();
        OpenLotteryQuery shuangQuery = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode shuangOpen = new OpenLotteryQuery.OpenCode();
        shuangQuery.setC_head(head);
        shuangOpen.setLotType(lotteryEnum.getIndex());
        shuangOpen.setPage_index(0);
        shuangOpen.setPage_size(10);
        shuangQuery.setOpencode_detail(shuangOpen);
        mOpenLotteryPrestener.selectOpenLotteryMessage(shuangQuery);
    }

    public void initHander(){
        this.mHander = (HanderLayout) findViewById(R.id.hander);
        mHander.setTitle(lotteryEnum.name());
        mHander.setVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        mHander.setBtnLinstener(this);
    }

    public void initListView(){
        mAdapter = new OpenCodeAdapter(this);
        mAdapter.setLotteryEnum(lotteryEnum);
        mXListView = (XListView) findViewById(R.id.xListView);
        mHandler = new Handler();
        mXListView.setPullLoadEnable(false);
        mXListView.setXListViewListener(this);
        mXListView.setOnItemClickListener(this);
        mXListView.setPullRefreshEnable(true);
        mXListView.setRefreshTime("今天：" + HourMinuteOfDayFormat.format(reflashDate));
        mXListView.setAdapter(mAdapter);
        mTvNoDataMsg = (TextView) findViewById(R.id.tvNoDataMsg);
    }

    @Override
    public void resume() {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void onSuccess(String json) {
        if (savedlg != null && savedlg.isShowing()) {
            savedlg.dismiss();
        }

        OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
        if (openCode != null && openCode.getOpencode_detail() != null) {
            if (openCode.getOpencode_detail().getDetail() != null) {
                Detail detail = openCode.getOpencode_detail().getDetail();
                mXListView.setVisibility(View.VISIBLE);
                mTvNoDataMsg.setVisibility(View.GONE);
                mAdapter.addItem(detail.getDetail_list());
                mAdapter.notifyDataSetChanged();
                if (detail.getDetail_list().size() >= mAdapter.getmPerPageSize()) {
                    mXListView.setPullLoadEnable(true);
                }else{
                    if (mAdapter.getPageNo() > mAdapter.getBeginPageNo()) {
                        mXListView.setPullLoadNoMore(true);
                    }
                }
            } else {
                if (mAdapter.getPageNo() == mAdapter.getBeginPageNo()) {
                    mXListView.setVisibility(View.GONE);
                    mTvNoDataMsg.setVisibility(View.VISIBLE);
                }else{
                    mXListView.setPullLoadNoMore(true);
                }
            }
        }
    }

    @Override
    public void onFailure(String msg) {
        if (savedlg != null && savedlg.isShowing()) {
            savedlg.dismiss();
        }
        ToolToast.showErrorShort(msg);
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


                OpenLotteryQuery.Head head = new OpenLotteryQuery.Head();
                OpenLotteryQuery shuangQuery = new OpenLotteryQuery();
                OpenLotteryQuery.OpenCode shuangOpen = new OpenLotteryQuery.OpenCode();
                shuangQuery.setC_head(head);
                shuangOpen.setLotType(lotteryEnum.getIndex());
                shuangOpen.setPage_index(0);
                shuangOpen.setPage_size(10);
                shuangQuery.setOpencode_detail(shuangOpen);
                mOpenLotteryPrestener.selectOpenLotteryMessage(shuangQuery);

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
                OpenLotteryQuery.Head head = new OpenLotteryQuery.Head();
                OpenLotteryQuery shuangQuery = new OpenLotteryQuery();
                OpenLotteryQuery.OpenCode shuangOpen = new OpenLotteryQuery.OpenCode();
                shuangQuery.setC_head(head);
                shuangOpen.setLotType(lotteryEnum.getIndex());
                shuangOpen.setPage_index(mAdapter.getPageNo());
                shuangOpen.setPage_size(10);
                shuangQuery.setOpencode_detail(shuangOpen);
                mOpenLotteryPrestener.selectOpenLotteryMessage(shuangQuery);
                onLoad();
            }
        }, 1000);
    }

    private void loginDialog() {
        savedlg = ToolAlert.getLoading(this, "请稍等");
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Detail_list list = (Detail_list) mAdapter.getItem((int) id);
        Intent intent = new Intent(this,OpenCodeDetailActivity.class);
        intent.putExtra("detail",list);
        intent.putExtra("lotteryEnum",mAdapter.getLotteryEnum());
        startActivity(intent);
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
