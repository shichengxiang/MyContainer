package com.example.comtainer.containerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 2017/2/18/018.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View container= LayoutInflater.from(this).inflate(R.layout.layout_bottom,null);
        container.findViewById(R.id.transition_current_scene);
        setContentView(getLayoutId());
    }
    public abstract int getLayoutId();
}
