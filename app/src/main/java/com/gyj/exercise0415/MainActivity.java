package com.gyj.exercise0415;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.List;

/**
 * 类的用途：
 * Created by 郭彦君
 * 2017/4/12
 */
public class MainActivity extends SlidingFragmentActivity {

    private SlidingMenu mMenu;
    private MyAdapter mAdapter;
    private ListView mListView;
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ceHua();
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("name");
        String title = intent.getStringExtra("title");
        mTextView.setText(title);
        //
        getServerData(url);
    }

    private void getServerData(String url) {
        HttpUtils.getInstance().httpXUtilsPOST(url, null, null, new HttpUtils.MyHttpCallback() {
            @Override
            public void onSuccess(String result) {
                JsonBean jsonBean = new Gson().fromJson(result, JsonBean.class);
                List<JsonBean.DataBean> data = jsonBean.getData();
                //
                initListView(data);
            }

            @Override
            public void onError(String errorMsg) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initListView(List<JsonBean.DataBean> data) {
        if (mAdapter == null) {
            mAdapter = new MyAdapter(data, MainActivity.this);
            mListView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }

    }

    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_cehua_main);
        mTextView = (TextView) findViewById(R.id.tv_title_main);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenu.toggle();
            }
        });
        mListView = (ListView) findViewById(R.id.lv_main);
    }

    public void ceHua() {
        int widthPixels = this.getResources().getDisplayMetrics().widthPixels;
        // 设置左侧滑动菜单
        setBehindContentView(R.layout.frag_cehua);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.menu_frame, new SlidingFragment()).commit();
        // 实例化滑动菜单对象
        mMenu = getSlidingMenu();
        // 设置可以左右滑动的菜单
        mMenu.setMode(SlidingMenu.LEFT);
        // 设置滑动菜单视图的宽度
        mMenu.setBehindWidth(widthPixels / 3 * 2);
        // 设置渐入渐出效果的值
        mMenu.setFadeDegree(0.35f);
        // 设置触摸屏幕的模式,这里设置为全屏
        mMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置下方视图的在滚动时的缩放比例
        mMenu.setBehindScrollScale(0.0f);
    }
}
