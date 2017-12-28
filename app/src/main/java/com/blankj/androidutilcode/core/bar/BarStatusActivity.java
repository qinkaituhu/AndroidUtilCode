package com.blankj.androidutilcode.core.bar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.androidutilcode.R;
import com.blankj.androidutilcode.base.BaseBackActivity;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/13
 *     desc  : Activity 工具类 Demo
 * </pre>
 */
public class BarStatusActivity extends BaseBackActivity {

    private TextView tvAboutStatus;

    public static void start(Context context) {
        Intent starter = new Intent(context, BarStatusActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_bar_status;
    }


    @Override
    public void initView(Bundle savedInstanceState, View view) {
        getToolBar().setTitle(getString(R.string.demo_bar));

        tvAboutStatus = findViewById(R.id.tv_about_status);
        findViewById(R.id.btn_show_status).setOnClickListener(this);
        findViewById(R.id.btn_hide_status).setOnClickListener(this);

        tvAboutStatus.setText("statusHeight: " + BarUtils.getStatusBarHeight()
                + "\nisStatusVisible: " + BarUtils.isStatusBarVisible(this));

        BarUtils.registerNavBarChangedListener(this, new BarUtils.OnNavBarChangedListener() {
            @Override
            public void onNavBarChanged(boolean isVisible) {
                LogUtils.d(isVisible);
            }
        });
    }

    private void updateAboutNav(boolean isNavBarVisible) {

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_status:
                BarUtils.showStatusBar(this);
                break;
            case R.id.btn_hide_status:
                BarUtils.hideStatusBar(this);
                break;
        }
        tvAboutStatus.setText("statusHeight: " + BarUtils.getStatusBarHeight()
                + "\nisStatusVisible: " + BarUtils.isStatusBarVisible(this));
    }
}
