package com.example.administrator.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.mylibrary.DragListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-03-23.
 */

/*
详情：http://www.eoeandroid.com/thread-95209-1-1.html

 */
public class DragListViewDemo extends Activity {

    //数据列表
    private List<String> list = null;

    //数据适配器
    private DragListAdapter adapter = null;

    //存放分组标签
    public static List<String> groupKey= new ArrayList<String>();
    //分组一
    private List<String> navList = new ArrayList<String>();
    //分组二
    private List<String> moreList = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_list_activity);

//初始化样本数据
        initData();

//后面会介绍DragListView
        DragListView dragListView = (DragListView)findViewById(R.id.draglistview);
        dragListView.setImageID(R.id.drag_list_item_image);
        dragListView.setBoundnum(0);//这里有1和0两种选择，选择1是因为加入了标签项。
        adapter = new DragListAdapter(this, list);
        dragListView.setAdapter(adapter);
    }




    public void initData(){
//数据结果
        list = new ArrayList<String>();

//groupKey存放的是分组标签
        groupKey.add("A组");
        groupKey.add("B组");

        for(int i=0; i<5; i++){
            navList.add("A选项"+i);
        }
        list.add("A组");
        list.addAll(navList);

        for(int i=0; i<8; i++){
            moreList.add("B选项"+i);
        }
        list.add("B组");
        list.addAll(moreList);
    }





    public static class DragListAdapter extends ArrayAdapter<String> {
        public DragListAdapter(Context context, List<String> objects) {
            super(context, 0, objects);
        }
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View view = convertView;
//            if(view==null){
////加载列表项模板
//                view = LayoutInflater.from(getContext()).inflate(R.layout.drag_list_item, null);
//            }
//            TextView textView = (TextView)view.findViewById(R.id.drag_list_item_text);
//            textView.setText(getItem(position));
//            return view;
//        }

        @Override
        public boolean isEnabled(int position) {
            if(groupKey.contains(getItem(position))){
//如果是分组标签，返回false，不能选中，不能点击
                return false;
            }
            return super.isEnabled(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if(groupKey.contains(getItem(position))){
//如果是分组标签，就加载分组标签的布局文件，两个布局文件显示效果不同
                view = LayoutInflater.from(getContext()).inflate(R.layout.drag_list_item_tag, null);
            }else{
//如果是正常数据项标签，就加在正常数据项的布局文件
                view = LayoutInflater.from(getContext()).inflate(R.layout.drag_list_item, null);
            }

            TextView textView = (TextView)view.findViewById(R.id.drag_list_item_text);
            textView.setText(getItem(position));
            return view;
        }
    }
}

