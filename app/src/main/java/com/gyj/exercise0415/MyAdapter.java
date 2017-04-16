package com.gyj.exercise0415;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * 类的用途：
 * Created by 郭彦君
 * 2017/4/12
 */

public class MyAdapter extends BaseAdapter {
    List<JsonBean.DataBean> list;
    Context mContext;

    public MyAdapter(List<JsonBean.DataBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(mContext, R.layout.item, null);
        TextView t_01 = (TextView) convertView.findViewById(R.id.tv_item_01);
        TextView t_02 = (TextView) convertView.findViewById(R.id.tv_item_02);
        TextView t_03 = (TextView) convertView.findViewById(R.id.tv_item_03);
        t_01.setText(list.get(position).getTitle());
        t_02.setText(list.get(position).getApply());
        t_03.setText(list.get(position).getBuy_price() + "");
        return convertView;
    }
}
