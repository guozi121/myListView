package com.listview.scrolllistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015-03-23.
 */

/*
放在ScrollView中的ListView

 */
public class LinearLayoutForListView extends LinearLayout {

    private AdapterForLinearLayout adapter;
    private OnClickListener onClickListener = null;

    /**
     * 绑定布局
     */
    public void bindLinearLayout() {
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            View v = adapter.getView(i, null, null);

            v.setOnClickListener(this.onClickListener);
            if (i == count - 1) {
                LinearLayout ly = (LinearLayout) v;
                ly.removeViewAt(2);
            }
            addView(v, i);
        }
        Log.v("countTAG", "" + count);
    }

    public LinearLayoutForListView(Context context) {
        super(context);

    }

    public LinearLayoutForListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub

    }

    /**
     * 获取Adapter
     *
     * @return adapter
     */
    public AdapterForLinearLayout getAdpater() {
        return adapter;
    }

    /**
     * 设置数据
     *
     * @param adpater
     */
    public void setAdapter(AdapterForLinearLayout adpater) {
        this.adapter = adpater;
        bindLinearLayout();
    }

    /**
     * 获取点击事件
     *
     * @return
     */
    public OnClickListener getOnclickListner() {
        return onClickListener;
    }

    /**
     * 设置点击事件
     *
     * @param onClickListener
     */
    public void setOnclickLinstener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}
