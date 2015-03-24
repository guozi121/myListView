package com.example.administrator.demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

import com.example.administrator.mylibrary.MyListView;

import java.util.ArrayList;
import java.util.HashMap;


public class MyListViewDemo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyListView list = (MyListView) findViewById(R.id.listview);
// 生成动态数组，并且转载数据
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "This is Title.....");
            map.put("ItemText", "This is text.....");
            mylist.add(map);
        }
// 生成适配器，数组===》ListItem
        SimpleAdapter mSchedule = new SimpleAdapter(this, // 没什么解释
                mylist,// 数据来源
                R.layout.my_listitem,// ListItem的XML实现
// 动态数组与ListItem对应的子项
                new String[] { "ItemTitle", "ItemText" },
// ListItem的XML文件里面的两个TextView ID
                new int[] { R.id.ItemTitle, R.id.ItemText });
// 添加并且显示
        list.setAdapter(mSchedule);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
