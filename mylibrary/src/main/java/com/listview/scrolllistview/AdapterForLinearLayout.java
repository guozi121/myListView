package com.listview.scrolllistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-03-23.
 */
public class AdapterForLinearLayout extends BaseAdapter {

    private LayoutInflater mInflater;
    private int resource;
    private List<? extends Map<String, ?>> data;
    private String[] from;
    private int[] to;

    public AdapterForLinearLayout(Context context,
                                  List<? extends Map<String, ?>> data, int resouce, String[] from,
                                  int[] to) {
        this.data = data;
        this.resource = resouce;
        this.data = data;
        this.from = from;
        this.to = to;
        this.mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @SuppressWarnings("unchecked")
    public String get(int position, Object key) {
        Map<String, ?> map = (Map<String, ?>) getItem(position);
        return map.get(key).toString();
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        convertView = mInflater.inflate(resource, null);
        Map<String, ?> item = data.get(position);
        int count = to.length;
        for (int i = 0; i < count; i++) {
            View v = convertView.findViewById(to[i]);
            bindView(v, item, from[i]);
        }
        convertView.setTag(position);
        return convertView;
    }

    /**
     * 绑定视图
     * @param view
     * @param item
     * @param from
     */
    private void bindView(View view, Map<String, ?> item, String from) {
        Object data = item.get(from);
        if (view instanceof TextView) {
            ((TextView) view).setText(data == null ? "" : data.toString());
        }
    }
}
