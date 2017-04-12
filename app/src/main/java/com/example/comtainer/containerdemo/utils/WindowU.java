package com.example.comtainer.containerdemo.utils;

import android.content.Context;
import android.widget.PopupWindow;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/4/12 18:47
 */

public class WindowU {
     private static PopupWindow mWindow;
     public void showWindow(Context context){
          if(mWindow!=null && mWindow.isShowing ())
               mWindow.dismiss ();
          mWindow=new PopupWindow (context);
     }
}
