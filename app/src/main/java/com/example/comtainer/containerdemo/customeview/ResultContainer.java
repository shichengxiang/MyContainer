package com.example.comtainer.containerdemo.customeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.comtainer.containerdemo.R;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/4/12 11:29
 */

public class ResultContainer extends RelativeLayout {
     View mSuccessView, mErrorView, mLoadingView, mNothingView;

     public ResultContainer(Context context) {
          super (context);
          init (context, null);
     }

     public ResultContainer(Context context, AttributeSet attrs) {
          super (context, attrs);
          init (context, attrs);
     }

     private void init(Context context, AttributeSet attrs) {
          if (attrs != null) {
               TypedArray a = context.obtainStyledAttributes (attrs, R.styleable.ResultView);
               try {
                    int errorId = a.getInt (R.styleable.ResultView_errorView, R.layout.layout_error);
                    int nothingId = a.getInt (R.styleable.ResultView_nothingView, R.layout.layout_empty);
                    int successId = a.getInt (R.styleable.ResultView_successView, R.layout.layout_result);
                    int loadingId = a.getInt (R.styleable.ResultView_loadingView, R.layout.layout_loading);
                    mSuccessView = LayoutInflater.from (context).inflate (successId, null);
                    mErrorView = LayoutInflater.from (context).inflate (errorId, null);
                    mNothingView = LayoutInflater.from (context).inflate (nothingId, null);
                    mLoadingView = LayoutInflater.from (context).inflate (loadingId, null);
                    mSuccessView.setVisibility (GONE);
                    mNothingView.setVisibility (GONE);
                    mErrorView.setVisibility (GONE);
                    mLoadingView.setVisibility (GONE);
                    addView (mSuccessView);
                    addView (mNothingView);
                    addView (mErrorView);
                    addView (mLoadingView);
               } finally {
                    a.recycle ();
               }
          }
     }

     /**
      * 显示多个布局
      * @param states
      */
     public void setState(ResultState[] states){
          if(states==null || states.length<1)
               return;
          for (ResultState s:states){
               switch (s){
                    case SUCCESS:
                         mSuccessView.setVisibility (VISIBLE);
                         break;
                    case NOTHING:
                         mNothingView.setVisibility (VISIBLE);
                         break;
                    case ERROR:
                         mErrorView.setVisibility (VISIBLE);
                         break;
                    case LOADING:
                         mLoadingView.setVisibility (VISIBLE);
                         break;
               }
          }
     }

     /**
      * 显示状态
      * @param state
      */
     public void setState(ResultState state) {
          switch (state) {
               case SUCCESS:
                    mSuccessView.setVisibility (VISIBLE);
                    mNothingView.setVisibility (GONE);
                    mErrorView.setVisibility (GONE);
                    mLoadingView.setVisibility (GONE);
                    break;
               case NOTHING:
                    mSuccessView.setVisibility (GONE);
                    mNothingView.setVisibility (VISIBLE);
                    mErrorView.setVisibility (GONE);
                    mLoadingView.setVisibility (GONE);
                    break;
               case ERROR:
                    mSuccessView.setVisibility (GONE);
                    mNothingView.setVisibility (GONE);
                    mErrorView.setVisibility (VISIBLE);
                    mLoadingView.setVisibility (GONE);
                    break;
               case LOADING:
                    mSuccessView.setVisibility (GONE);
                    mNothingView.setVisibility (GONE);
                    mErrorView.setVisibility (GONE);
                    mLoadingView.setVisibility (VISIBLE);
                    break;
          }
     }

     enum ResultState {
          SUCCESS, NOTHING, ERROR, LOADING
     }
}
