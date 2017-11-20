package com.game.www.wfcc.function.openLottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseAdapter;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.bean.tuijian.Data;
import com.game.www.wfcc.ui.RoundImageView;

/**
 * Created by Administrator on 2017/6/3.
 */
public class TuiJianAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;

    public TuiJianAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Data data = (Data) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_tuijian, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(MyApplication.getInstance()).load(data.getPoster().getAvatar())
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into( viewHolder.mImgUserPhoto);
        viewHolder.mTvName.setText(data.getPoster().getName());
        viewHolder.mTvMasterLevel.setText(data.getPoster().getMasterLevel());
        viewHolder.mTvTime.setText(data.getPublishDateText());
        viewHolder.mTvNo.setText(data.getGroupTitle());
        viewHolder.mTvMatchName.setText(data.getRecommendInfo().getMatchName());
        viewHolder.mTvVersusText.setText(data.getRecommendInfo().getVersusText());
        viewHolder.mTvAnalysisText.setText(data.getRecommendInfo().getAnalysisText());
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public RoundImageView mImgUserPhoto;
        public TextView mTvName;
        public TextView mTvMasterLevel;
        public TextView mTvTime;
        public TextView mTvNo;
        public TextView mTvMatchName;
        public TextView mTvVersusText;
        public TextView mTvAnalysisText;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mImgUserPhoto = (RoundImageView) rootView.findViewById(R.id.imgUserPhoto);
            this.mTvName = (TextView) rootView.findViewById(R.id.tvName);
            this.mTvMasterLevel = (TextView) rootView.findViewById(R.id.tvMasterLevel);
            this.mTvTime = (TextView) rootView.findViewById(R.id.tvTime);
            this.mTvNo = (TextView) rootView.findViewById(R.id.tvNo);
            this.mTvMatchName = (TextView) rootView.findViewById(R.id.tvMatchName);
            this.mTvVersusText = (TextView) rootView.findViewById(R.id.tvVersusText);
            this.mTvAnalysisText = (TextView) rootView.findViewById(R.id.tvAnalysisText);
        }

    }
}
