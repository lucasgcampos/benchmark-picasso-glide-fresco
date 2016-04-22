package com.lgcampos.benchmark.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.adapter.ImageAdapter;
import com.lgcampos.benchmark.domain.manager.ImageManager;
import com.lgcampos.benchmark.domain.model.WrapperObject;
import com.lgcampos.benchmark.domain.service.ImageService;
import com.lgcampos.benchmark.domain.service.RetrofitConfig;

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

        ImageService service = new RetrofitConfig().createService(ImageService.class);
        Call<WrapperObject> images = service.loadImages();
        images.enqueue(new Callback<WrapperObject>() {
            @Override
            public void onResponse(Call<WrapperObject> call, Response<WrapperObject> response) {
                ImageManager imageManager = (ImageManager) getIntent().getSerializableExtra("lib");
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new ImageAdapter(ImageActivity.this, response.body().getAvfms(), imageManager));
            }

            @Override
            public void onFailure(Call<WrapperObject> call, Throwable t) {

            }
        });

    }

}
