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
import com.game.www.wfcc.function.openLottery.activity.RemenActivity;
import com.game.www.wfcc.function.openLottery.adapter.ReMenAdapter;
import com.game.www.wfcc.function.openLottery.bean.remenzixun.Root;
import com.game.www.wfcc.function.openLottery.bean.remenzixun.Row;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.ui.XListView;
import com.game.www.wfcc.util.ToolAlert;
import com.game.www.wfcc.util.ToolToast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhangdaweisir on 2017/6/9.
 */
public class RmenZixunFragment extends BaseFragmentV4 implements OpenLotteryView, HanderLayout.TitleBottonLinstener, XListView.IXListViewListener, AdapterView.OnItemClickListener {

    public static final String TAG = RmenZixunFragment.class.getSimpleName();
    public static RmenZixunFragment newInstance() {
        final RmenZixunFragment f = new RmenZixunFragment();
        return f;
    }
    private OpenLotteryPrestener mOpenLotteryPrestener;

    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return  R.layout.activity_select_check_house_list;
    }
    private ReMenAdapter mAdapter;


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
        mOpenLotteryPrestener.getReMenZixun(1);
    }

    public void initHander(View view){
        this.mHander = (HanderLayout) view.findViewById(R.id.hander);
        mHander.setTitle("资讯");
        mHander.setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        mHander.setBtnLinstener(this);
    }

    public void initListView(View view){
        mAdapter = new ReMenAdapter(getActivity());
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
    public void onSuccess(String str) {
        if (savedlg != null && savedlg.isShowing()) {
            savedlg.dismiss();
        }
        JSONObject json = null;
        try {
            json = XML.toJSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Root openCode = MyApplication.getInstance().getGson().fromJson(json.toString(), Root.class);
        openCode = openCode.getResp();
        if (openCode != null && openCode.getRows() != null) {
            if (openCode.getRows().getRow() != null) {
                mXListView.setVisibility(View.VISIBLE);
                mTvNoDataMsg.setVisibility(View.GONE);
                mAdapter.addItem(openCode.getRows().getRow() );
                mAdapter.notifyDataSetChanged();
                if (openCode.getRows().getRow().size() >= mAdapter.getmPerPageSize()) {
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
                mOpenLotteryPrestener.getReMenZixun(1);
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
                mOpenLotteryPrestener.getReMenZixun(mAdapter.getPageNo() + 1);
                onLoad();
            }
        }, 1000);
    }

    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Row list = (Row) mAdapter.getItem((int) id);
        Intent intent = new Intent(getActivity(),RemenActivity.class);
        intent.putExtra("url",list.getArcurl());
        startActivity(intent);
    }


    @Override
    public void imgLeftLinstener(View v) {
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
