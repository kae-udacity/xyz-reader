package com.example.xyzreader.ui;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.xyzreader.R;

public class ParallaxPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(@NonNull View page, float position) {
        int pageWidth = page.getWidth();

        if (position <= -1.0f) {
            page.setAlpha(1);
        } else if (position > 1.0f) {
            page.setAlpha(1);
        } else {
            View photo = page.findViewById(R.id.photo);
            photo.setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

            float alpha = 1.0f - Math.abs(position);
            View articleTitle = page.findViewById(R.id.article_title);
            articleTitle.setAlpha(alpha);

            View articleByline = page.findViewById(R.id.article_byline);
            articleByline.setAlpha(alpha);

            View articleBody = page.findViewById(R.id.article_body);
            articleBody.setAlpha(alpha);

            View fab = page.findViewById(R.id.share_fab);
            fab.setAlpha(alpha);

            float rotation = position * 540;
            fab.setRotation(rotation);
        }
    }

}
