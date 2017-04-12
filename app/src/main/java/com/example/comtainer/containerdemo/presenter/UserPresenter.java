package com.example.comtainer.containerdemo.presenter;

import com.example.comtainer.containerdemo.model.BaseModel;
import com.example.comtainer.containerdemo.model.UserModel;
import com.example.comtainer.containerdemo.view.BaseView;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/4/12 18:20
 */

public class UserPresenter extends BasePresenter<BaseView,UserModel> {


     public UserPresenter(BaseView baseView, UserModel userModel) {
          super (baseView, userModel);
     }
     public void getUser(){
          mView.onError ("失败？");
     }
}
