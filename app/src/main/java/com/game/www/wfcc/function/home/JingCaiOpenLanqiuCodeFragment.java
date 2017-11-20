package com.game.www.wfcc.function.home;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.adapter.JingCaiAdapter;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryQuery;
import com.game.www.wfcc.function.openLottery.bean.jingcai.DetailForJingCai;
import com.game.www.wfcc.function.openLottery.bean.jingcai.OpenCodeForJingCai;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;

/**
 * Created by zhangdaweisir on 2017/6/1.
 */
public class JingCaiOpenLanqiuCodeFragment extends BaseFragmentV4 implements OpenLotteryView, HanderLayout.TitleBottonLinstener {
    public static final String TAG = JingCaiOpenLanqiuCodeFragment.class.getSimpleName();
    public static JingCaiOpenLanqiuCodeFragment newInstance() {
        final JingCaiOpenLanqiuCodeFragment f = new JingCaiOpenLanqiuCodeFragment();
        return f;
    }
    private ListView mXListView;
    private TextView mTvNoDataMsg;
    private Dialog savedlg;
    private JingCaiAdapter mAdapter;
    private HanderLayout mHander;
    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }
    public void initListView(View rootView){
        mAdapter = new JingCaiAdapter(getActivity());
        mXListView = (ListView) rootView.findViewById(R.id.xListView);
        mXListView.setAdapter(mAdapter);
        mTvNoDataMsg = (TextView) rootView.findViewById(R.id.tvNoDataMsg);
    }
    private OpenLotteryPrestener mOpenLotteryPrestener;
    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return R.layout.fragment_jing_cai_open_code;
    }

    @Override
    public void initView(View rootView) {
        loginDialog();
        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        mHander.setTitle("竞彩篮球");
        mHander.setBtnLinstener(this);
        initListView(rootView);
    }

    @Override
    public void doBusiness(Context mContext) {
        OpenLotteryQuery.Head head = new OpenLotteryQuery.Head();
        OpenLotteryQuery shuangQuery = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode shuangOpen = new OpenLotteryQuery.OpenCode();
        shuangQuery.setC_head(head);
        shuangOpen.setLotType(OpenLotteryEnum.竞彩篮球.getIndex());
        shuangOpen.setPage_index(0);
        shuangOpen.setPage_size(50);
        shuangQuery.setOpencode_detail(shuangOpen);
        mOpenLotteryPrestener.selectOpenLotteryMessage(shuangQuery);
    }

    @Override
    public void onSuccess(String json) {
        if (savedlg != null && savedlg.isShowing()) {
            savedlg.dismiss();
        }

        OpenCodeForJingCai openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCodeForJingCai.class);
        if (openCode != null && openCode.getOpencode_detail() != null) {
            if (openCode.getOpencode_detail().getDetail() != null) {
                DetailForJingCai detail = openCode.getOpencode_detail().getDetail();
                mXListView.setVisibility(View.VISIBLE);
                mTvNoDataMsg.setVisibility(View.GONE);
                mAdapter.addItem(detail.getDetail_list());
                mAdapter.notifyDataSetChanged();
                if(detail.getDetail_list() == null || detail.getDetail_list().size() == 0){
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
