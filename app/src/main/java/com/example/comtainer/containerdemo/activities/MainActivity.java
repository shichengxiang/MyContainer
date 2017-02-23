package com.example.comtainer.containerdemo.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.comtainer.containerdemo.R;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

     Context mContext;

     @BindView (R.id.twinklingRefreshLayout)
     TwinklingRefreshLayout mTwinklingRefreshLayout;
     @BindView (R.id.lv_content)
     ListView mListView;

     private TAdapter mTAdapter;
     private String[] mData = {"ToolBar使用", "Drawer 抽屉效果", "Login UI", "Tabs of Fragment", "Setttings of Sys", "2", "3", "2", "3", "2", "3", "2", "3"};

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (R.layout.activity_main);
          ButterKnife.bind (this);
          mContext = this;
          mTAdapter = new TAdapter ();
          setListener ();
     }

     private void setListener() {
          mListView.setAdapter (mTAdapter);
          ProgressLayout headLayout = new ProgressLayout (this);
          mTwinklingRefreshLayout.setHeaderView (headLayout);
          mTwinklingRefreshLayout.setOverScrollBottomShow (true);
          mTwinklingRefreshLayout.startRefresh ();//自动更新
//          mTwinklingRefreshLayout.setEnableRefresh (false);// 是否可刷新
//          mTwinklingRefreshLayout.setEnableLoadmore (false);//是否可加载更多
          mTwinklingRefreshLayout.setOverScrollMode (TwinklingRefreshLayout.OVER_SCROLL_ALWAYS);
          mTwinklingRefreshLayout.setOnRefreshListener (new RefreshListenerAdapter () {
               @Override
               public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                    super.onRefresh (refreshLayout);
                    new Handler ().postDelayed (new Runnable () {
                         @Override
                         public void run() {
                              mTwinklingRefreshLayout.finishRefreshing ();
                         }
                    }, 2000);
               }

               @Override
               public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                    super.onLoadMore (refreshLayout);
                    new Handler ().postDelayed (new Runnable () {
                         @Override
                         public void run() {
                              mTwinklingRefreshLayout.finishLoadmore ();
                         }
                    }, 2000);
               }
          });
          TextView view = new TextView (this);
          view.setText ("FIXED");
          mTwinklingRefreshLayout.addFixedExHeader (view);
     }

     private class TAdapter extends BaseAdapter {
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
               if (convertView == null) {
                    convertView = LayoutInflater.from (mContext).inflate (R.layout.item_lv_main, null);
               }
               Intent intent = null;
               switch (position) {
                    case 0:
                         intent = new Intent (mContext, ToolBarActivity.class);
                         break;
                    case 1:
                         intent=new Intent (mContext,DrawerActivity.class);
                         break;
                    case 2:
                         intent=new Intent (mContext,LoginActivity.class);
                         break;
                    case 3:
                         intent=new Intent(mContext,TabsActivity.class);
                         break;
                    default:
                         intent = new Intent (mContext, GuideActivity.class);
                         break;
               }
               final Intent finalIntent = intent;
               convertView.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                         if (finalIntent != null)
                              MainActivity.this.startActivity (finalIntent);
                    }
               });
               TextView viewById = (TextView) convertView.findViewById (R.id.item);
               viewById.setText (mData[position]);
               return convertView;
          }
     }
}
