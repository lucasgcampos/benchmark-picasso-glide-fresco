package com.lgcampos.benchmark.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lgcampos.benchmark.adapter.ImageAdapter;
import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.domain.ImageLibrary;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {

    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        Fresco.initialize(this);

        ImageLibrary library = (ImageLibrary) getIntent().getSerializableExtra("lib");

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new ImageAdapter(this, library));
    }

}
