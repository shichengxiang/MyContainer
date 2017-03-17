package com.example.comtainer.containerdemo.presenter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.comtainer.containerdemo.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/3/17 15:03
 */

public class PageStateLayout extends LinearLayout implements PageStateListener {
     private Context mContext;
     private View mErrorView;
     private View mEmptyView;
     private View mSuccessView;
     private View mLoadingView;
     private View mTopView;
     private PageState currentState = PageState.SUCCESS;

     @Override
     public void onSucess() {
          currentState = PageState.SUCCESS;
          show (PageState.SUCCESS);
     }

     @Override
     public void onError() {
          currentState = PageState.ERROR;
          show (PageState.ERROR);
     }

     @Override
     public void onEmpty() {
          currentState = PageState.EMPTY;
          show (PageState.EMPTY);
     }

     @Override
     public void onLoading() {
          currentState = PageState.LOADING;
          show (PageState.LOADING);
     }
     public PageState getCurrentState(){
          return currentState;
     }
     public View getTopView(){
          return mTopView;
     }

     public static enum PageState {
          EMPTY, ERROR, SUCCESS, LOADING
     }

     public PageStateLayout(Context context) {
          super (context);
          this.mContext = context;
          init ();
     }

     public PageStateLayout(Context context, AttributeSet attrs) {
          super (context, attrs);
          this.mContext = context;
          init ();
     }

     private void init() {
          setOrientation (VERTICAL);
          LinearLayout.LayoutParams params = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
          setLayoutParams (params);
     }

     private void show(PageState state) {
          if(Builder.hasTopView & mTopView!=null){
               mTopView=LayoutInflater.from (mContext).inflate (R.layout.layout_bottom,null);
               addView (mTopView);
          }
          if (mLoadingView == null) {
               mLoadingView = getLoadingView ();
               addView (mLoadingView);
          }
          if (mEmptyView == null) {
               mEmptyView = getEmptyView ();
               addView (mEmptyView);
          }
          if (mErrorView == null) {
               mErrorView = getErrorView ();
               addView (mErrorView);
          }
          if (mSuccessView == null) {
               mSuccessView = getSuccessView ();
               addView (mSuccessView);
          }
          mLoadingView.setVisibility (state == PageState.LOADING ? VISIBLE : GONE);
          mEmptyView.setVisibility (state == PageState.EMPTY ? VISIBLE : GONE);
          mErrorView.setVisibility (state == PageState.ERROR ? VISIBLE : GONE);
          mSuccessView.setVisibility (state == PageState.SUCCESS ? VISIBLE : GONE);
     }

     public static class Builder {
          static int mLoadingId = 0, mEmptyId = 0, mErrorId = 0, mSuccessId = 0;
          static boolean hasTopView=false;
          private static final Builder mInstance = new Builder ();

          private Builder() {
          }

          public static Builder setLoadingView(@LayoutRes int resId) {
               mLoadingId = resId;
               return mInstance;
          }

          public static Builder setEmptyView(@LayoutRes int resId) {
               mEmptyId = resId;
               return mInstance;
          }

          public static Builder setErrorView(@LayoutRes int resId) {
               mErrorId = resId;
               return mInstance;
          }

          public static Builder setSuccessView(@LayoutRes int resId) {
               mSuccessId = resId;
               return mInstance;
          }
          public static Builder hasTopView(boolean has){
               hasTopView=has;
               return mInstance;
          }
     }

     private View getLoadingView() {
          if (Builder.mLoadingId != 0) {
               this.mLoadingView = LayoutInflater.from (mContext).inflate (Builder.mLoadingId, null);
          }
          return mLoadingView;
     }

     private View getSuccessView() {
          if (Builder.mSuccessId != 0) {
               this.mSuccessView = LayoutInflater.from (mContext).inflate (Builder.mSuccessId, null);
          }
          return mSuccessView;
     }

     private View getErrorView() {
          if (Builder.mErrorId != 0) {
               this.mErrorView = LayoutInflater.from (mContext).inflate (Builder.mErrorId, null);
          }
          return mErrorView;
     }

     private View getEmptyView() {
          if (Builder.mEmptyId != 0) {
               this.mEmptyView = LayoutInflater.from (mContext).inflate (Builder.mEmptyId, null);
          }
          return mEmptyView;
     }

}
