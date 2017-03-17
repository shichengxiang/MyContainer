package com.example.comtainer.containerdemo.presenter;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/3/17 16:12
 */

public interface PageStateListener {
     void onSucess();

     void onError();

     void onEmpty();

     void onLoading();
}
