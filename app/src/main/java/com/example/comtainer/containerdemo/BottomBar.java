package com.example.comtainer.containerdemo;

import android.content.ContentValues;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/2/21 12:56
 */

public class BottomBar extends RelativeLayout {

     private View tab1, tab2, tab3, tab4;
     private View tab_top1, tab_top2, tab_top3, tab_top4;
     private View tab_b1, tab_b2, tab_b3, tab_b4;
     private int currentIndex = 0;
     private int prevIndex = -1;
     private OnTabChangeListener mOnTabChangeListener;

     public BottomBar(Context context) {
          super(context);
     }

     public BottomBar(Context context, AttributeSet attrs) {
          super(context, attrs);
          View contentView = LayoutInflater.from(context).inflate(R.layout.layout_bottom, null);
          addView(contentView);
          tab1 = contentView.findViewById(R.id.tab1);
          tab2 = contentView.findViewById(R.id.tab2);
          tab3 = contentView.findViewById(R.id.tab3);
          tab4 = contentView.findViewById(R.id.tab4);
          tab_top1 = contentView.findViewById(R.id.iv_tab1);
          tab_top2 = contentView.findViewById(R.id.iv_tab2);
          tab_top3 = contentView.findViewById(R.id.iv_tab3);
          tab_top4 = contentView.findViewById(R.id.iv_tab4);
          tab_b1 = contentView.findViewById(R.id.tv_tab1);
          tab_b2 = contentView.findViewById(R.id.tv_tab2);
          tab_b3 = contentView.findViewById(R.id.tv_tab3);
          tab_b4 = contentView.findViewById(R.id.tv_tab4);
          setListener();
          tab1.performClick();
     }

     private void setListener() {
          tab1.setOnClickListener(new ClickListener(0));
          tab2.setOnClickListener(new ClickListener(1));
          tab3.setOnClickListener(new ClickListener(2));
          tab4.setOnClickListener(new ClickListener(3));
     }

     private class ClickListener implements OnClickListener {
          private int t = 0;

          public ClickListener(int tag) {
               t = tag;
               currentIndex = tag;
          }

          @Override
          public void onClick(View v) {
               if (mOnTabChangeListener != null & currentIndex != prevIndex) {
                    mOnTabChangeListener.onTabChangeListener(t);
               }
               switch (t) {
                    case 0:
                         tab_top1.setSelected(true);
                         tab_b1.setSelected(true);
                         tab_top2.setSelected(false);
                         tab_b2.setSelected(false);
                         tab_top3.setSelected(false);
                         tab_b3.setSelected(false);
                         tab_top4.setSelected(false);
                         tab_b4.setSelected(false);
                         break;
                    case 1:
                         tab_top1.setSelected(false);
                         tab_b1.setSelected(false);
                         tab_top2.setSelected(true);
                         tab_b2.setSelected(true);
                         tab_top3.setSelected(false);
                         tab_b3.setSelected(false);
                         tab_top4.setSelected(false);
                         tab_b4.setSelected(false);
                         break;
                    case 2:
                         tab_top1.setSelected(false);
                         tab_b1.setSelected(false);
                         tab_top2.setSelected(false);
                         tab_b2.setSelected(false);
                         tab_top3.setSelected(true);
                         tab_b3.setSelected(true);
                         tab_top4.setSelected(false);
                         tab_b4.setSelected(false);
                         break;
                    case 3:
                         tab_top1.setSelected(false);
                         tab_b1.setSelected(false);
                         tab_top2.setSelected(false);
                         tab_b2.setSelected(false);
                         tab_top3.setSelected(false);
                         tab_b3.setSelected(false);
                         tab_top4.setSelected(true);
                         tab_b4.setSelected(true);
                         break;
               }
               prevIndex = t;
          }
     }

     public interface OnTabChangeListener {
          void onTabChangeListener(int index);
     }

     public void setOnTabChangeListener(OnTabChangeListener onTabChangeListener) {
          this.mOnTabChangeListener = onTabChangeListener;
     }

     /**
      *  默认选择
      * @param index
      */
     public void setDefaultIndex(int index){
          switch (index){
               case 0:
                    tab1.performClick();
                    break;
               case 1:
                    tab2.performClick();
                    break;
               case 2:
                    tab3.performClick();
                    break;
               case 3:
                    tab4.performClick();
                    break;
          }
     }

     @Override
     protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
          super.onMeasure(widthMeasureSpec, heightMeasureSpec);
     }
}
