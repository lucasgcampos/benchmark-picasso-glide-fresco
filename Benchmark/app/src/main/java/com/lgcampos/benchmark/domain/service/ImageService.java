package com.lgcampos.benchmark.domain.service;

import com.lgcampos.benchmark.domain.model.WraperObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public interface ImageService {

    @GET("featured.php?appkey=f6bcd8e8bb853890f4fb2be8ce0418fa")
    Call<WraperObject> loadImages();
}
