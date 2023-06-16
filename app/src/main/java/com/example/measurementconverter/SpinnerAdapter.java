package com.example.measurementconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author Liang
 * @date 2023/6/15 17:04
 * description
 */
public class SpinnerAdapter extends BaseAdapter {
    private List<String> mList;
    private  Context mContext;
    SpinnerAdapter(List<String> Datas, Context context) {
        mList = Datas;
        mContext = context;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view = mLayoutInflater.inflate(R.layout.spinner_item_layout,null);
        if (view != null) {
            TextView textView = view.findViewById(R.id.input_item);
            textView.setText(mList.get(position));
        }
        return view;
    }
}
