package com.lgcampos.benchmark.domain.manager;

import android.app.Activity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class PicassoImageManager implements ImageManager {
    @Override
    public void loadImage(Activity activity, String url, ImageView image) {
        Picasso.with(activity).load(url).into(image);
    }
}
