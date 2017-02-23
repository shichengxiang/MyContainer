package com.example.comtainer.containerdemo.utils;

import com.example.comtainer.containerdemo.beans.Android;
import com.example.comtainer.containerdemo.beans.User;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/2/23 16:30
 */

public class CacheData {
     /**
      * 用户，应用 信息的保存
      */
     private User mUser;
     private Android mAndroid;

     public User getUser() {
          return mUser;
     }

     public void setUser(User user) {
          mUser = user;
     }

     public Android getAndroid() {
          return mAndroid;
     }

     public void setAndroid(Android android) {
          mAndroid = android;
     }
}
