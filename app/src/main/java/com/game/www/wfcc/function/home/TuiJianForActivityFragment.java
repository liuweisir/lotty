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
import com.game.www.wfcc.util.ToolToast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhangdaweisir on 2017/6/8.
 */
public class TuiJianForActivityFragment extends BaseFragmentV4 implements OpenLotteryView, HanderLayout.TitleBottonLinstener, XListView.IXListViewListener, AdapterView.OnItemClickListener {


    public static final String TAG = TuiJianForActivityFragment.class.getSimpleName();
    public static TuiJianForActivityFragment newInstance() {
        final TuiJianForActivityFragment f = new TuiJianForActivityFragment();
        return f;
    }
    private OpenLotteryPrestener mOpenLotteryPrestener;

    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return  R.layout.activity_select_check_house_list;
    }
    private TuiJianAdapter mAdapter;


    private HanderLayout mHander;
    private XListView mXListView;
    private TextView mTvNoDataMsg;
    private Handler mHandler;
    private Date reflashDate = new Date();
    private SimpleDateFormat HourMinuteOfDayFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private Dialog savedlg;

    @Override
    public void initView(View view) {
        initHander(view);
        initListView(view);
        loginDialog();
    }
    @Override
    public void doBusiness(Context mContext) {
        QueryTuiJian q = new QueryTuiJian(0,10);
        mOpenLotteryPrestener.selectTuijian(q);
    }

    public void initHander(View view){
        this.mHander = (HanderLayout) view.findViewById(R.id.hander);
        mHander.setTitle("推荐信息");
        mHander.setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        mHander.setBtnLinstener(this);
    }

    public void initListView(View view){
        mAdapter = new TuiJianAdapter(getActivity());
        mXListView = (XListView) view.findViewById(R.id.xListView);
        mHandler = new Handler();
        mXListView.setPullLoadEnable(false);
        mXListView.setXListViewListener(this);
        mXListView.setOnItemClickListener(this);
        mXListView.setPullRefreshEnable(true);
        mXListView.setRefreshTime("今天：" + HourMinuteOfDayFormat.format(reflashDate));
        mXListView.setAdapter(mAdapter);
        mTvNoDataMsg = (TextView) view.findViewById(R.id.tvNoDataMsg);
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
                mTvNoDataMsg.setVisibility(View.GONE);
                mAdapter.addItem(openCode.getData() );
                mAdapter.notifyDataSetChanged();
                if (openCode.getData().size() >= mAdapter.getmPerPageSize()) {
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
                QueryTuiJian q = new QueryTuiJian(0,10);
                mOpenLotteryPrestener.selectTuijian(q);
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
                QueryTuiJian q = new QueryTuiJian(mAdapter.getPageNo(),10);
                mOpenLotteryPrestener.selectTuijian(q);
                onLoad();
            }
        }, 1000);
    }

    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Data list = (Data) mAdapter.getItem((int) id);
        Intent intent = new Intent(getActivity(),TuiJianDetailActivity.class);
        intent.putExtra("rId",list.getRecommendInfo().getId());
        startActivity(intent);
    }


    @Override
    public void imgLeftLinstener(View v) {
        getActivity().finish();
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
