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
import com.game.www.wfcc.function.openLottery.bean.saishi.Data;

/**
 * Created by zhangdaweisir on 2017/6/1.
 */
public class SishiAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;

    public SishiAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Data detail = (Data) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_saishi, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mName.setText(detail.getMatchgbname());

        Glide.with(MyApplication.getInstance()).load(detail.getMatchlogo())
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(viewHolder.mLogo);

        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public ImageView mLogo;
        public TextView mName;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mLogo = (ImageView) rootView.findViewById(R.id.logo);
            this.mName = (TextView) rootView.findViewById(R.id.Name);
        }

    }
}
