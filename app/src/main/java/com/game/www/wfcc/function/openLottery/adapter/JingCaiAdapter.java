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
import com.game.www.wfcc.function.openLottery.bean.newJingCai.Matches;
import com.game.www.wfcc.util.DateUtil;

/**
 * Created by zhangdaweisir on 2017/6/1.
 */
public class JingCaiAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;

    public JingCaiAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Matches detail = (Matches) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_jingcai_open_code, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTvBiSaiName.setText(detail.getSimpleleague());
        viewHolder.mTvNo.setText(detail.getOrder());
        viewHolder.mTvTrimOneName.setText(detail.getHomesxname());
        viewHolder.mTvBiSaiState.setText(detail.getStatus_desc());
        viewHolder.mTvBifen.setText(detail.getStatus_desc().equals("未开始") ? "VS" : detail.getHomescore() + " : " +detail.getAwayscore());
        viewHolder.mTvTime.setText(DateUtil.friendlyFormat(detail.getMatchtime()));
        viewHolder.mTvTrimTwoName.setText(detail.getAwaysxname());
        Glide.with(MyApplication.getInstance()).load(detail.getHomelogo())
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(viewHolder.mImgTrimOneLogo);
        Glide.with(MyApplication.getInstance()).load(detail.getAwaylogo())
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(viewHolder.mImgTrimTwoLogo);

        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView mTvNo;
        public TextView mTvBiSaiName;
        public ImageView mImgTrimOneLogo;
        public TextView mTvTrimOneName;
        public TextView mTvBiSaiState;
        public TextView mTvBifen;
        public TextView mTvTime;
        public TextView mTvTrimTwoName;
        public ImageView mImgTrimTwoLogo;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mTvNo = (TextView) rootView.findViewById(R.id.tvNo);
            this.mTvBiSaiName = (TextView) rootView.findViewById(R.id.tvBiSaiName);
            this.mImgTrimOneLogo = (ImageView) rootView.findViewById(R.id.imgTrimOneLogo);
            this.mTvTrimOneName = (TextView) rootView.findViewById(R.id.tvTrimOneName);
            this.mTvBiSaiState = (TextView) rootView.findViewById(R.id.tvBiSaiState);
            this.mTvBifen = (TextView) rootView.findViewById(R.id.tvBifen);
            this.mTvTime = (TextView) rootView.findViewById(R.id.tvTime);
            this.mTvTrimTwoName = (TextView) rootView.findViewById(R.id.tvTrimTwoName);
            this.mImgTrimTwoLogo = (ImageView) rootView.findViewById(R.id.imgTrimTwoLogo);
        }

    }
}
