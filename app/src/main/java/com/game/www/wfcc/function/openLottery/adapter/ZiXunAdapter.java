package com.game.www.wfcc.function.openLottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseAdapter;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.function.openLottery.bean.tuijian.Data;

/**
 * Created by Administrator on 2017/6/1.
 */
public class ZiXunAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;

    private OpenLotteryEnum lotteryEnum;

    public OpenLotteryEnum getLotteryEnum() {
        return lotteryEnum;
    }

    public void setLotteryEnum(OpenLotteryEnum lotteryEnum) {
        this.lotteryEnum = lotteryEnum;
    }

    public ZiXunAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Data detail = (Data) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.item_zixun, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(MyApplication.getInstance()).load(detail.getPoster().getAvatar())
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into( viewHolder.imgUrl);
        viewHolder.title.setText(detail.getRecommendInfo().getAnalysisText());
        viewHolder.source.setText(detail.getPoster().getName());
        viewHolder.createTime.setText(detail.getPublishDateText());
        viewHolder.readCount.setText(detail.getNegativeCount() + "");
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView title;
        public TextView source;
        public TextView createTime;
        public TextView readCount;
        public ImageView imgUrl;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.source = (TextView) rootView.findViewById(R.id.source);
            this.createTime = (TextView) rootView.findViewById(R.id.createTime);
            this.readCount = (TextView) rootView.findViewById(R.id.readCount);
            this.imgUrl = (ImageView) rootView.findViewById(R.id.imgUrl);
        }

    }
}
