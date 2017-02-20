package com.example.comtainer.containerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.comtainer.containerdemo.adapters.cardview.CardItem;
import com.example.comtainer.containerdemo.adapters.cardview.CardPagerAdapter;
import com.example.comtainer.containerdemo.adapters.cardview.ShadowTransformer;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/20/020.
 */

public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    CardPagerAdapter mCardAdapter;
    ShadowTransformer mCardShadowTransformer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("card 1", "djajfadjfjadfjajfd"));
        mCardAdapter.addCardItem(new CardItem("card 2", "gh8ooooooooooohdafagfd"));
        mCardAdapter.addCardItem(new CardItem("card 3", "dajf;fdkaf;dfd"));
        mCardAdapter.addCardItem(new CardItem("card 4", "d afajjjddddddddddddi"));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(true, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }
}
