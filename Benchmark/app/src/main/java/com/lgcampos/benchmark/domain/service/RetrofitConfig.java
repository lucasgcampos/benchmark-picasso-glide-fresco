package com.lgcampos.benchmark.domain.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class RetrofitConfig {

    private static final String BASE_URL = "https://aviewfrommyseat.com/avf/api/";
    private final Retrofit retrofit;

    public RetrofitConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T>T createService(Class<T> service) {
        return retrofit.create(service);
    }

}
