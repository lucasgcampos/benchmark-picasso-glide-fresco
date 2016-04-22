package com.lgcampos.benchmark.domain.manager;

import android.app.Activity;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public interface ImageManager extends Serializable {
    void loadImage(Activity activity, String url, ImageView image);
}
