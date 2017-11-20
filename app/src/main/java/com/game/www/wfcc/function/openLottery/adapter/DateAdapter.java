package com.game.www.wfcc.function.openLottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseAdapter;

/**
 * Created by zhangdaweisir on 2017/6/6.
 */
public class DateAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;

    public DateAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String date = (String) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_date, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTvDate.setText(date);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView mTvDate;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mTvDate = (TextView) rootView.findViewById(R.id.tvDate);
        }

    }
}
