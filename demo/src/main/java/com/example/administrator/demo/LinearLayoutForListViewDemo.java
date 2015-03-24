package com.example.administrator.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.listview.scrolllistview.AdapterForLinearLayout;
import com.listview.scrolllistview.LinearLayoutForListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015-03-23.
 */
public class LinearLayoutForListViewDemo extends Activity {
    /** Called when the activity is first created. */
    private LinearLayoutForListView lv = null;
   // ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrolllistview);
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//        加载数据如下：
        lv = (LinearLayoutForListView) findViewById(R.id.ListView01);
        for (int i = 0; i < 5; i++) {
            Log.i("info",i+"");
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("key_name", "name" + i);
            map.put("value_name", "value" + i);
            list.add( map );
        }

        final AdapterForLinearLayout Layoutadpater = new AdapterForLinearLayout(
                this, list, R.layout.to,
                new String[] {"key_name", "value_name" },
                new int[] { R.id.TextView01, R.id.TextView02 });

        //      事件操作，并通过下标得到数据源：
        lv.setOnclickLinstener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String toShow = Layoutadpater.get(Integer.parseInt(v.getTag().toString()), "key_name");
                String toshow2 = Layoutadpater.get(Integer.parseInt(v.getTag().toString()), "value_name");
                Toast.makeText(
                        LinearLayoutForListViewDemo.this,
                        toShow + "---" + toshow2, Toast.LENGTH_LONG).show();
            }
        });
        lv.setAdapter(Layoutadpater);
    }
}
