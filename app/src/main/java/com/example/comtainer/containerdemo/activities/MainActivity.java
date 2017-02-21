package com.example.comtainer.containerdemo.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.comtainer.containerdemo.R;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

     Context mContext;
     @BindView (R.id.twinklingRefreshLayout)
     TwinklingRefreshLayout mTwinklingRefreshLayout;
     @BindView (R.id.lv_content)
     ListView mListView;
     private String[] mData={"1","2","3","2","3","2","3","2","3","2","3","2","3"};

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (R.layout.activity_main);
          mContext=this;
     }
     private class TAdapter extends BaseAdapter{
          @Override
          public int getCount() {
               return mData.length;
          }

          @Override
          public Object getItem(int position) {
               return mData[position];
          }

          @Override
          public long getItemId(int position) {
               return position;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {
               if(convertView==null){
                    convertView= LayoutInflater.from (mContext).inflate (R.layout.item_lv_main,null);
               }
               TextView viewById = (TextView) convertView.findViewById (R.id.item);
               viewById.setText (mData[position]);
               return convertView;
          }
     }
}
