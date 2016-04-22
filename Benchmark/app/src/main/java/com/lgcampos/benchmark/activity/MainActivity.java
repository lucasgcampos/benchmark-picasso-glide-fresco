package com.lgcampos.benchmark.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.domain.manager.GlideImageManager;
import com.lgcampos.benchmark.domain.manager.PicassoImageManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String IMAGE_LIBRARY = "lib";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.picasso)
    void onClickPicasso() {
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra(IMAGE_LIBRARY, new PicassoImageManager());
        startActivity(intent);
    }

    @OnClick(R.id.glide)
    void onClickGlide() {
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra(IMAGE_LIBRARY, new GlideImageManager());
        startActivity(intent);
    }

}
