package com.example.comtainer.containerdemo.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.example.comtainer.containerdemo.R;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/4/12 18:41
 */

public class DialogU {

     private static AlertDialog mDialog;

     private static void showDialog(Context context) {
          if (mDialog != null & mDialog.isShowing ())
               mDialog.dismiss ();
          AlertDialog.Builder builder = new AlertDialog.Builder (context);
          builder.setView (R.layout.layout_loading);
          mDialog = builder.create ();
          mDialog.show ();
     }
}
