package com.game.www.wfcc.function.openLottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseAdapter;
import com.game.www.wfcc.function.openLottery.bean.yuce.Row;

/**
 * Created by zhangdaweisir on 2017/6/9.
 */
public class Yuce2Adapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;

    public Yuce2Adapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Row data = (Row) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_yuce2, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(data.getName());
        if("1".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_ssq);
        }
        if("50".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_dlt);
        }
        if("70".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_jc);
        }
        if("71".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_jclq);
        }
        if("80".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_sfc);
        }
        if("85".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_jczq_dg);
        }
        if("3".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_3d);
        }
        if("53".equals(data.getGid())){
            viewHolder.logo.setImageResource(R.drawable.buy_main_p3);
        }
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView title;
        public ImageView logo;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            logo = (ImageView) rootView.findViewById(R.id.logo);
        }

    }
}
