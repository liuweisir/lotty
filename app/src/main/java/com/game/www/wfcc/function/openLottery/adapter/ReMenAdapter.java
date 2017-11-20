package com.game.www.wfcc.function.openLottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseAdapter;
import com.game.www.wfcc.function.openLottery.bean.remenzixun.Row;

/**
 * Created by zhangdaweisir on 2017/6/9.
 */
public class ReMenAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;

    public ReMenAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Row data = (Row) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_remen, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(data.getNtitle());
        viewHolder.content.setText(data.getDescription());
        viewHolder.count.setText(data.getZan());
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView title;
        public TextView content;
        public TextView count;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.content = (TextView) rootView.findViewById(R.id.content);
            this.count = (TextView) rootView.findViewById(R.id.count);
        }

    }
}
