package com.game.www.wfcc.function.home;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.adapter.DateAdapter;
import com.game.www.wfcc.function.openLottery.adapter.JingCaiAdapter;
import com.game.www.wfcc.function.openLottery.bean.newJingCai.Data;
import com.game.www.wfcc.function.openLottery.bean.newJingCai.Root;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;

import java.util.List;

/**
 * Created by zhangdaweisir on 2017/6/1.
 */
public class JingCaiOpenCodeForActivityFragment extends BaseFragmentV4 implements OpenLotteryView, HanderLayout.TitleBottonLinstener {
    public static final String TAG = JingCaiOpenCodeForActivityFragment.class.getSimpleName();
    public static JingCaiOpenCodeForActivityFragment newInstance() {
        final JingCaiOpenCodeForActivityFragment f = new JingCaiOpenCodeForActivityFragment();
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
    private LayoutInflater layoutInflater;
    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return R.layout.fragment_jing_cai_open_code;
    }

    @Override
    public void initView(View rootView) {
        loginDialog();
        layoutInflater = LayoutInflater.from(getActivity());
        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.VISIBLE);
        mHander.setTitle("竞猜足球");
        mHander.setmBtnTitleRightText("日期");
        mHander.setmBtnTitleRightTextColor(R.color.loginout_red);
        mHander.setBtnLinstener(this);
        initListView(rootView);
    }
    private PopupWindow pop;
    private RelativeLayout parView;

    public void initpop(List<String> dates) {
        //if (pop == null) {
        pop = new PopupWindow(getActivity());
        parView = (RelativeLayout) layoutInflater.inflate(R.layout.comment_dialog, null);
        ListView listView = (ListView) parView.findViewById(R.id.listView);
        final DateAdapter adapter = new DateAdapter(getActivity());
        listView.setAdapter(adapter);
        adapter.clear();
        adapter.addItem(dates);
        adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String date = (String) adapter.getItem((int)id);
                mOpenLotteryPrestener.getJingCaiZuqiu(date);
                pop.dismiss();
                loginDialog();
            }
        });
        pop.setWidth(ActionBar.LayoutParams.WRAP_CONTENT);
        pop.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        pop.setFocusable(true);
        pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.setOutsideTouchable(true);
        pop.setContentView(parView);
        pop.setOnDismissListener(new poponDismissListener());
    }
    @Override
    public void doBusiness(Context mContext) {
        mOpenLotteryPrestener.getJingCaiZuqiu(null);
    }
    class poponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }
    }
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp =getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void onSuccess(String json) {
        if (savedlg != null && savedlg.isShowing()) {
            savedlg.dismiss();
        }

        Root openCode = MyApplication.getInstance().getGson().fromJson(json, Root.class);
        if (openCode != null && openCode.getData().getMatches() != null) {
            if (openCode.getData().getMatches() != null) {
                Data detail = openCode.getData();
                mXListView.setVisibility(View.VISIBLE);
                mTvNoDataMsg.setVisibility(View.GONE);
                mAdapter.clear();
                mAdapter.addItem(detail.getMatches());
                mAdapter.notifyDataSetChanged();
                if(detail.getMatches() == null || detail.getMatches().size() == 0){
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
            dates = openCode.getData().getExpect_list();
            initpop(dates);
        }
    }

    private List<String> dates;

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
        backgroundAlpha(0.7f);
        pop.showAsDropDown(v, Gravity.CENTER, 0, 0);
    }
}
