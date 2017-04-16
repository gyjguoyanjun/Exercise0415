package com.gyj.exercise0415;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * 类的用途：
 * Created by 郭彦君
 * 2017/4/12
 */

public class SlidingFragment extends Fragment implements View.OnClickListener {

    private TextView mQuanbu;
    private TextView mZhongyao;
    private TextView mXiyao;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sliding_menu, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //
        initView(view);
    }

    private void initData() {
    }

    @Override
    public void onResume() {
        super.onResume();
        //
    }

    private void setListen() {

    }

    private void initView(View view) {
        mQuanbu = (TextView) view.findViewById(R.id.tv_slide_01);
        mZhongyao = (TextView) view.findViewById(R.id.tv_slide_02);
        mXiyao = (TextView) view.findViewById(R.id.tv_slide_03);

        mQuanbu.setOnClickListener(this);
        mZhongyao.setOnClickListener(this);
        mXiyao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        switch (v.getId()) {
            case R.id.tv_slide_01:
                Toast.makeText(getActivity(), "111", Toast.LENGTH_SHORT).show();
                intent.putExtra("name", Url.ALL);
                intent.putExtra("title","全部");
                startActivity(intent);
                break;
            case R.id.tv_slide_02:
                Toast.makeText(getActivity(), "222", Toast.LENGTH_SHORT).show();
                intent.putExtra("name", Url.ZHONG);
                intent.putExtra("title","中药");
                startActivity(intent);
                break;
            case R.id.tv_slide_03:
                Toast.makeText(getActivity(), "333", Toast.LENGTH_SHORT).show();
                intent.putExtra("name", Url.XI);
                intent.putExtra("title","西药");
                startActivity(intent);
                break;
        }
    }
}
