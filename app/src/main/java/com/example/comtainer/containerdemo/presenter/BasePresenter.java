package com.example.comtainer.containerdemo.presenter;

import com.example.comtainer.containerdemo.model.BaseModel;
import com.example.comtainer.containerdemo.view.BaseView;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/4/12 18:18
 */

public class BasePresenter<T extends BaseView, V extends BaseModel> {
     public BaseView mView;
     public BaseModel mModel;

     public BasePresenter(T t, V v) {
          this.mView = t;
          this.mModel = v;
     }
}
