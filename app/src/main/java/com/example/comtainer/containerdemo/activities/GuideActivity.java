package com.example.comtainer.containerdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.comtainer.containerdemo.R;
import com.example.comtainer.containerdemo.adapters.cardview.CardItem;
import com.example.comtainer.containerdemo.adapters.cardview.CardPagerAdapter;
import com.example.comtainer.containerdemo.adapters.cardview.ShadowTransformer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

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
        ButterKnife.bind(this);
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

    @OnClick(R.id.btn_toMain)public void OnClick(View view){
        startActivity(new Intent(GuideActivity.this,MainActivity.class));
    }
}
