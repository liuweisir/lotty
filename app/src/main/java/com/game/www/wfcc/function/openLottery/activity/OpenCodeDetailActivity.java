package com.game.www.wfcc.function.openLottery.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseActivity;
import com.game.www.wfcc.function.openLottery.bean.Detail_list;
import com.game.www.wfcc.function.openLottery.bean.OPTIONS_LIST;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.DateUtil;

import java.util.List;

/**
 * Created by zhangdaweisir on 2017/6/1.
 */
public class OpenCodeDetailActivity extends BaseActivity implements HanderLayout.TitleBottonLinstener {

    private LayoutInflater inflater;
    private LinearLayout mLayoutViewGoud;
    private Detail_list mDetail;
    private TextView tvOpenCodeTitle;
    public TextView mTvShuangOpen1;
    public TextView mTvShuangOpen2;
    public TextView mTvShuangOpen3;
    public TextView mTvShuangOpen4;
    public TextView mTvShuangOpen5;
    public TextView mTvShuangOpen6;
    public TextView mTvShuangOpen7;
    private TextView tvOpenDate;
    private TextView tvXiaoliang;
    private OpenLotteryEnum lotteryEnum;
    private HanderLayout mHander;





    @Override
    public int bindLayout() {
        return  R.layout.activity_opencode_detail;
    }

    @Override
    public void initView(View rootView) {
        inflater = LayoutInflater.from(this);
        mDetail = (Detail_list) getIntent().getSerializableExtra("detail");
        lotteryEnum = (OpenLotteryEnum) getIntent().getSerializableExtra("lotteryEnum");
        mLayoutViewGoud = (LinearLayout) findViewById(R.id.layoutViewGrod);
        mLayoutViewGoud.removeAllViews();
        mHander = (HanderLayout) findViewById(R.id.hander);
        mHander.setBtnLinstener(this);
        mHander.setVisibility(View.VISIBLE,View.VISIBLE,View.GONE,View.GONE,View.GONE);
        mHander.setTitle("开奖详情");
        this.mTvShuangOpen1 = (TextView) rootView.findViewById(R.id.tvShuangOpen1);
        this.mTvShuangOpen2 = (TextView) rootView.findViewById(R.id.tvShuangOpen2);
        this.mTvShuangOpen3 = (TextView) rootView.findViewById(R.id.tvShuangOpen3);
        this.mTvShuangOpen4 = (TextView) rootView.findViewById(R.id.tvShuangOpen4);
        this.mTvShuangOpen5 = (TextView) rootView.findViewById(R.id.tvShuangOpen5);
        this.mTvShuangOpen6 = (TextView) rootView.findViewById(R.id.tvShuangOpen6);
        this.mTvShuangOpen7 = (TextView) rootView.findViewById(R.id.tvShuangOpen7);
        tvOpenCodeTitle = (TextView) findViewById(R.id.tvOpenCodeTitle);
        tvOpenDate = (TextView) findViewById(R.id.tvOpenDate);
        tvXiaoliang = (TextView) findViewById(R.id.tvXiaoliang);
    }

    @Override
    public void doBusiness(Context mContext) {
        if(mDetail != null && mDetail.getOPTIONS_LIST() != null && mDetail.getOPTIONS_LIST().size() > 0){
            List<OPTIONS_LIST> list = mDetail.getOPTIONS_LIST();
            for(OPTIONS_LIST options : list){
                LinearLayout newLayout = (LinearLayout) inflater.inflate(R.layout.item_add_detail,null);
                TextView tvAmt = (TextView) newLayout.findViewById(R.id.tvAmt);
                TextView tvLevel = (TextView) newLayout.findViewById(R.id.tvLevel);
                TextView tvCount = (TextView) newLayout.findViewById(R.id.tvCount);
                tvAmt.setText(options.getEach_bonus_money());
                tvLevel.setText(options.getAward_level_name());
                tvCount.setText(options.getAward_number());
                mLayoutViewGoud.addView(newLayout);
            }
        }
        if(lotteryEnum.getIndex() == OpenLotteryEnum.双色球.getIndex()){
            String[] shuangCode = mDetail.getOPEN_CODE().split("\\|");
            String[] openHoneCodes = shuangCode[0].split(",");
           mTvShuangOpen1.setText(openHoneCodes[0]);
           mTvShuangOpen2.setText(openHoneCodes[1]);
           mTvShuangOpen3.setText(openHoneCodes[2]);
           mTvShuangOpen4.setText(openHoneCodes[3]);
           mTvShuangOpen5.setText(openHoneCodes[4]);
           mTvShuangOpen6.setText(openHoneCodes[5]);
           mTvShuangOpen7.setText(openHoneCodes[1]);

        }
        if(lotteryEnum.getIndex() == OpenLotteryEnum.大乐透.getIndex()){
           mTvShuangOpen6.setBackgroundResource(R.drawable.circle_blue_shape);
           mTvShuangOpen6.setBackgroundResource(R.drawable.circle_blue_shape);
            String[] shuangCode = mDetail.getOPEN_CODE().split("\\|");
            String[] openHoneCodes = shuangCode[0].split(",");
            String[] openLanCodes = shuangCode[1].split(",");
           mTvShuangOpen1.setText(openHoneCodes[0]);
           mTvShuangOpen2.setText(openHoneCodes[1]);
           mTvShuangOpen3.setText(openHoneCodes[2]);
           mTvShuangOpen4.setText(openHoneCodes[3]);
           mTvShuangOpen5.setText(openHoneCodes[4]);
           mTvShuangOpen6.setText(openLanCodes[0]);
           mTvShuangOpen7.setText(openLanCodes[1]);


        }
        if(lotteryEnum.getIndex() == OpenLotteryEnum.福彩3D.getIndex() || lotteryEnum.getIndex() == OpenLotteryEnum.排列三.getIndex()){
           mTvShuangOpen4.setVisibility(View.GONE);
           mTvShuangOpen5.setVisibility(View.GONE);
           mTvShuangOpen6.setVisibility(View.GONE);
           mTvShuangOpen7.setVisibility(View.GONE);
            String[] shuangCode = mDetail.getOPEN_CODE().split(",");
           mTvShuangOpen1.setText(shuangCode[0]);
           mTvShuangOpen2.setText(shuangCode[1]);
           mTvShuangOpen3.setText(shuangCode[2]);
        }

        if(lotteryEnum.getIndex() == OpenLotteryEnum.排列五.getIndex() || lotteryEnum.getIndex() == OpenLotteryEnum.广东11选5.getIndex()
                || lotteryEnum.getIndex() == OpenLotteryEnum.江西11选5.getIndex()|| lotteryEnum.getIndex() == OpenLotteryEnum.山东11选5.getIndex()){
           mTvShuangOpen6.setVisibility(View.GONE);
           mTvShuangOpen7.setVisibility(View.GONE);
            String[] shuangCode = mDetail.getOPEN_CODE().split(",");
           mTvShuangOpen1.setText(shuangCode[0]);
           mTvShuangOpen2.setText(shuangCode[1]);
           mTvShuangOpen3.setText(shuangCode[2]);
           mTvShuangOpen4.setText(shuangCode[3]);
           mTvShuangOpen5.setText(shuangCode[4]);

        }
        tvOpenCodeTitle.setText(lotteryEnum.name() + mDetail.getEXPECT() + "期");
        tvOpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(mDetail.getOPENCODE_TIME())) + " 周" + mDetail.getOPENCODE_WEEK());
        tvXiaoliang.setText(mDetail.getSALES_MONEY());
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

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
