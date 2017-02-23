package com.example.comtainer.containerdemo.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * name of class: MyContainer
 * creater: scx
 * time: 2017/2/23 16:14
 */

public class ActivityManager {
     private static Stack<Activity> sStack;
     private static ActivityManager instance;
     private ActivityManager(){}
     public static ActivityManager getInstance(){
          if(instance==null)
               instance=new ActivityManager ();
          return instance;
     }

     /**
      * 添加activity
      * @param ac
      */
     public void addActivity(Activity ac){
          if(sStack==null)
               sStack=new Stack<> ();
          sStack.add (ac);
     }

     /**
      * 当前activity
      * @return
      */
     public Activity currentActivity(){
          Activity ac=sStack.lastElement ();
          return ac;
     }

     /**
      * 关闭当前activity
      */
     public void finishCurrentActivity(){
          Activity ac=sStack.lastElement ();
     }
     public void finishActivity(Activity ac){
          if(ac!=null){
               sStack.remove (ac);
               ac.finish ();
               ac=null;
          }
     }
     public void finishActivity(Class<?> clz){
          for (Activity ac:sStack){
               if(ac.getClass ().equals (clz)){
                    finishActivity (ac);
               }
          }
     }

     /**
      * 关闭所有界面
      */
     public void finishAllActivity(){
          for(int i=0,size=sStack.size ();i<size;i++){
               if(sStack.get (i)!=null){
                    sStack.get (i).finish ();
               }
          }
          sStack.clear ();
     }
}
