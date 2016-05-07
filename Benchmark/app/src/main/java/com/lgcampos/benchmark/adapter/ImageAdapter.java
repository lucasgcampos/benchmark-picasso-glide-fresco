package com.lgcampos.benchmark.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.activity.ImageActivity;
import com.lgcampos.benchmark.domain.manager.ImageManager;
import com.lgcampos.benchmark.domain.model.Image;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private static final String BASE_URL_IMAGE = "http://aviewfrommyseat.com/wallpaper/%s";
    private final List<Image> images;
    private final ImageActivity activity;
    private final ImageManager imageManager;

    public ImageAdapter(ImageActivity activity, List<Image> images, ImageManager imageManager) {
        this.activity = activity;
        this.images = images;
        this.imageManager = imageManager;
    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.linha, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, int position) {
        Image imageSelected = images.get(position);
        holder.text.setText(imageSelected.getVenue());
        imageManager.loadImage(activity, String.format(BASE_URL_IMAGE, imageSelected.getImage()), holder.image);
    }

    @Override
    public int getItemCount() {
        /**
         * Always consider the nullPointerException protection on this method
         */
        return images != null ? images.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;

        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.imagem);
            text = (TextView) view.findViewById(R.id.text);
        }
    }
}
