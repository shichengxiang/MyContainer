package com.example.comtainer.containerdemo.view;

import android.view.View;
import android.view.ViewGroup;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/3/7 18:52
 */

public class RequestView {
     private View mSuccessView = null;
     private View mErrorView=null;
     private View mEmptyView=null;
     private View mLoadingView=null;

     void onSuccess() {
          if(mSuccessView!=null)
               mSuccessView.setVisibility (View.VISIBLE);
     }

     void onLoading() {
     }

     void onError() {
     }

     void setSuccessView(View view) {
          mSuccessView=view;
     }

     public static class PageStateListener{

     }
}
