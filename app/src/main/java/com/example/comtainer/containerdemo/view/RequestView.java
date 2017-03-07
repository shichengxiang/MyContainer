package com.example.comtainer.containerdemo.view;

import android.view.View;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/3/7 18:52
 */

public abstract class RequestView {
     public View mSuccessView = null;

     void onSuccess() {
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
