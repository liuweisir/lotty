package com.game.www.wfcc.function.openLottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseAdapter;
import com.game.www.wfcc.function.openLottery.bean.Detail_list;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.util.DateUtil;

/**
 * Created by Administrator on 2017/6/1.
 */
public class OpenCodeAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;

    private OpenLotteryEnum lotteryEnum;

    public OpenLotteryEnum getLotteryEnum() {
        return lotteryEnum;
    }

    public void setLotteryEnum(OpenLotteryEnum lotteryEnum) {
        this.lotteryEnum = lotteryEnum;
    }

    public OpenCodeAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Detail_list detail = (Detail_list) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = inflater.inflate( R.layout.item_open_code, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(lotteryEnum.getIndex() == OpenLotteryEnum.双色球.getIndex()){
            String[] shuangCode = detail.getOPEN_CODE().split("\\|");
            String[] openHoneCodes = shuangCode[0].split(",");
            viewHolder.mTvOpen1.setText(openHoneCodes[0]);
            viewHolder.mTvOpen2.setText(openHoneCodes[1]);
            viewHolder.mTvOpen3.setText(openHoneCodes[2]);
            viewHolder.mTvOpen4.setText(openHoneCodes[3]);
            viewHolder.mTvOpen5.setText(openHoneCodes[4]);
            viewHolder.mTvOpen6.setText(openHoneCodes[5]);
            viewHolder.mTvOpen7.setText(openHoneCodes[1]);

        }
        if(lotteryEnum.getIndex() == OpenLotteryEnum.大乐透.getIndex()){
            viewHolder.mTvOpen6.setBackgroundResource(R.drawable.circle_blue_shape);
            viewHolder.mTvOpen6.setBackgroundResource(R.drawable.circle_blue_shape);
            String[] shuangCode = detail.getOPEN_CODE().split("\\|");
            String[] openHoneCodes = shuangCode[0].split(",");
            String[] openLanCodes = shuangCode[1].split(",");
            viewHolder.mTvOpen1.setText(openHoneCodes[0]);
            viewHolder.mTvOpen2.setText(openHoneCodes[1]);
            viewHolder.mTvOpen3.setText(openHoneCodes[2]);
            viewHolder.mTvOpen4.setText(openHoneCodes[3]);
            viewHolder.mTvOpen5.setText(openHoneCodes[4]);
            viewHolder.mTvOpen6.setText(openLanCodes[0]);
            viewHolder.mTvOpen7.setText(openLanCodes[1]);


        }
        if(lotteryEnum.getIndex() == OpenLotteryEnum.福彩3D.getIndex() || lotteryEnum.getIndex() == OpenLotteryEnum.排列三.getIndex()){
            viewHolder.mTvOpen4.setVisibility(View.GONE);
            viewHolder.mTvOpen5.setVisibility(View.GONE);
            viewHolder.mTvOpen6.setVisibility(View.GONE);
            viewHolder.mTvOpen7.setVisibility(View.GONE);
            String[] shuangCode = detail.getOPEN_CODE().split(",");
            viewHolder.mTvOpen1.setText(shuangCode[0]);
            viewHolder.mTvOpen2.setText(shuangCode[1]);
            viewHolder.mTvOpen3.setText(shuangCode[2]);
        }

        if(lotteryEnum.getIndex() == OpenLotteryEnum.排列五.getIndex() || lotteryEnum.getIndex() == OpenLotteryEnum.广东11选5.getIndex()
                || lotteryEnum.getIndex() == OpenLotteryEnum.江西11选5.getIndex()|| lotteryEnum.getIndex() == OpenLotteryEnum.山东11选5.getIndex()){
            viewHolder.mTvOpen6.setVisibility(View.GONE);
            viewHolder.mTvOpen7.setVisibility(View.GONE);
            String[] shuangCode = detail.getOPEN_CODE().split(",");
            viewHolder.mTvOpen1.setText(shuangCode[0]);
            viewHolder.mTvOpen2.setText(shuangCode[1]);
            viewHolder.mTvOpen3.setText(shuangCode[2]);
            viewHolder.mTvOpen4.setText(shuangCode[3]);
            viewHolder.mTvOpen5.setText(shuangCode[4]);

        }
        viewHolder.mTvOpenCodeNum.setText(detail.getEXPECT() + "期");
        viewHolder.mTvOpenCodeDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getOPENCODE_TIME())) + " 周" + detail.getOPENCODE_WEEK());
        viewHolder.mTvOpenCodeTitle.setText(OpenLotteryEnum.getOpenLotteryEnumByIndex(lotteryEnum.getIndex()).name());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView mTvOpenCodeTitle;
        public TextView mTvOpenCodeNum;
        public TextView mTvOpenCodeDate;
        public TextView mTvOpen1;
        public TextView mTvOpen2;
        public TextView mTvOpen3;
        public TextView mTvOpen4;
        public TextView mTvOpen5;
        public TextView mTvOpen6;
        public TextView mTvOpen7;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mTvOpenCodeTitle = (TextView) rootView.findViewById(R.id.tvOpenCodeTitle);
            this.mTvOpenCodeNum = (TextView) rootView.findViewById(R.id.tvOpenCodeNum);
            this.mTvOpenCodeDate = (TextView) rootView.findViewById(R.id.tvOpenCodeDate);
            this.mTvOpen1 = (TextView) rootView.findViewById(R.id.tvOpen1);
            this.mTvOpen2 = (TextView) rootView.findViewById(R.id.tvOpen2);
            this.mTvOpen3 = (TextView) rootView.findViewById(R.id.tvOpen3);
            this.mTvOpen4 = (TextView) rootView.findViewById(R.id.tvOpen4);
            this.mTvOpen5 = (TextView) rootView.findViewById(R.id.tvOpen5);
            this.mTvOpen6 = (TextView) rootView.findViewById(R.id.tvOpen6);
            this.mTvOpen7 = (TextView) rootView.findViewById(R.id.tvOpen7);
        }

    }
}
