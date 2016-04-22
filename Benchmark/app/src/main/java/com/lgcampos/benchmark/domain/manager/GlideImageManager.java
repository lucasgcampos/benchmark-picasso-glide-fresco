package com.lgcampos.benchmark.domain.manager;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class GlideImageManager implements ImageManager {
    @Override
    public void loadImage(Activity activity, String url, ImageView image) {
        Glide.with(activity).load(url).into(image);
    }
}
