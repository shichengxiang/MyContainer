package com.example.comtainer.containerdemo.adapters.cardview;

import android.support.v7.widget.CardView;

/**
 * Created by Administrator on 2017/2/20/020.
 */

public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 10;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
