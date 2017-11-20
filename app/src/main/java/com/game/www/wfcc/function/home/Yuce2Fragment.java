package com.game.www.wfcc.function.home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.activity.YuCeForActivity;
import com.game.www.wfcc.function.openLottery.adapter.Yuce2Adapter;
import com.game.www.wfcc.function.openLottery.bean.yuce.Root;
import com.game.www.wfcc.function.openLottery.bean.yuce.Row;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.ToolAlert;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.List;

/**
 * Created by zhangdaweisir on 2017/6/1.
 */
public class Yuce2Fragment extends BaseFragmentV4 implements OpenLotteryView, HanderLayout.TitleBottonLinstener {
    public static final String TAG = Yuce2Fragment.class.getSimpleName();
    public static Yuce2Fragment newInstance() {
        final Yuce2Fragment f = new Yuce2Fragment();
        return f;
    }
    private GridView mXListView;
    private TextView mTvNoDataMsg;
    private Dialog savedlg;
    private Yuce2Adapter mAdapter;
    private HanderLayout mHander;
    private void loginDialog() {
        savedlg = ToolAlert.getLoading(getActivity(), "请稍等");
    }
    public void initListView(View rootView){
        mAdapter = new Yuce2Adapter(getActivity());
        mXListView = (GridView) rootView.findViewById(R.id.xListView);
        mXListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Row row = (Row) mAdapter.getItem((int)id);
                Intent intent = new Intent(getActivity() , YuCeForActivity.class);
                intent.putExtra("gid",row.getGid());
                intent.putExtra("title",row.getName());
                startActivity(intent);
            }
        });
        mXListView.setAdapter(mAdapter);
        mTvNoDataMsg = (TextView) rootView.findViewById(R.id.tvNoDataMsg);
    }
    private OpenLotteryPrestener mOpenLotteryPrestener;
    private LayoutInflater layoutInflater;
    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return R.layout.fragment_yuce;
    }

    @Override
    public void initView(View rootView) {
        loginDialog();
        layoutInflater = LayoutInflater.from(getActivity());
        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        mHander.setTitle("首页");
        mHander.setmBtnTitleRightTextColor(R.color.loginout_red);
        initListView(rootView);
    }
    @Override
    public void doBusiness(Context mContext) {
        mOpenLotteryPrestener.getYiCe();
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
                }else{
                    if (mAdapter.getPageNo() > mAdapter.getBeginPageNo()) {
                    }
                }
            } else {
                if (mAdapter.getPageNo() == mAdapter.getBeginPageNo()) {
                    mXListView.setVisibility(View.GONE);
                    mTvNoDataMsg.setVisibility(View.VISIBLE);
                }else{
                }
            }
        }
    }

    private List<String> dates;

    @Override
    public void onFailure(String msg) {

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
