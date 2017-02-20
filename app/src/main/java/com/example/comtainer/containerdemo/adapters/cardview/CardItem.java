package com.example.comtainer.containerdemo.adapters.cardview;

/**
 * Created by Administrator on 2017/2/20/020.
 */

public class CardItem {
    String mTitle;
    String mContent;
    public CardItem(String title,String content){
        this.mTitle=title;
        this.mContent=content;
    }
    public String getTitle(){
        return mTitle;
    }
    public String getContent(){
        return mContent;
    }
}
