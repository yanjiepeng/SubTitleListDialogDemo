package com.tzsafe.subtitlelistdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> datas;
    private LayoutInflater inflater;

    public ItemAdapter(Context mContext, ArrayList<String> datas) {
        this.mContext = mContext;
        this.datas = datas;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);

            viewHolder = new ViewHolder();

            viewHolder.text = (TextView) convertView.findViewById(android.R.id.text1);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.text.setText(datas.get(position));


        return convertView;
    }


    class ViewHolder {

        TextView text;

    }


}
