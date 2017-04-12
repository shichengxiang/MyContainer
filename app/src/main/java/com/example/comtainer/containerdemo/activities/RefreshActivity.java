package com.example.comtainer.containerdemo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CalendarView;

import com.example.comtainer.containerdemo.R;
import com.lcodecore.tkrefreshlayout.header.progresslayout.MaterialProgressDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/3/28 16:34
 */

public class RefreshActivity extends AppCompatActivity {

     @BindView (R.id.swipeRefreshLayout)
     SwipeRefreshLayout mSwipeRefreshLayout;

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (R.layout.activity_refresh);
          ButterKnife.bind (this);
          Toolbar toolbar= (Toolbar) findViewById (R.id.toolbar);
          setSupportActionBar (toolbar);
     }
     @OnClick(R.id.showSwipe)
     public void onClick(View view){
          switch (view.getId ()){
               case R.id.showSwipe:
                    displaySwipe ();
                    break;
          }
     }

     /**
      * 使用swiperefreshlayout
      */
     private void displaySwipe(){
          mSwipeRefreshLayout.setVisibility (View.VISIBLE);
          mSwipeRefreshLayout.setColorSchemeColors (Color.parseColor ("#FF9BB53F"));
          mSwipeRefreshLayout.setOnRefreshListener (new SwipeRefreshLayout.OnRefreshListener () {
               @Override
               public void onRefresh() {
                    new Handler ().postDelayed (new Runnable () {
                         @Override
                         public void run() {
                              mSwipeRefreshLayout.setRefreshing (false);
                         }
                    },2000);
               }
          });
     }
}
