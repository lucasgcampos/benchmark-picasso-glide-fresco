package com.lgcampos.benchmark.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lgcampos.benchmark.adapter.ImageAdapter;
import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.domain.model.ImageLibrary;
import com.lgcampos.benchmark.domain.service.ImageService;
import com.lgcampos.benchmark.domain.service.RetrofitConfig;
import com.lgcampos.benchmark.domain.model.WraperObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        ImageService service = new RetrofitConfig().createService(ImageService.class);
        Call<WraperObject> images = service.loadImages();
        images.enqueue(new Callback<WraperObject>() {
            @Override
            public void onResponse(Call<WraperObject> call, Response<WraperObject> response) {
                ImageLibrary library = (ImageLibrary) getIntent().getSerializableExtra("lib");
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new ImageAdapter(ImageActivity.this, response.body().getAvfms(), library));
            }

            @Override
            public void onFailure(Call<WraperObject> call, Throwable t) {

            }
        });

    }

}
