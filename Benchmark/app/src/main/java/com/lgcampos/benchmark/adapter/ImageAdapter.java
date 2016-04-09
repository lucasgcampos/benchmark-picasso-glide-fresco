package com.lgcampos.benchmark.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.activity.ImageActivity;
import com.lgcampos.benchmark.domain.model.Image;
import com.lgcampos.benchmark.domain.model.ImageLibrary;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private static final String BASE_URL_IMAGE = "http://aviewfrommyseat.com/wallpaper/%s";
    private final List<Image> images;
    private final ImageActivity activity;
    private final ImageLibrary library;

    public ImageAdapter(ImageActivity activity, List<Image> images, ImageLibrary library) {
        this.activity = activity;
        this.images = images;
        this.library = library;
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

        if (library == ImageLibrary.GLIDE) {
            Glide.with(activity).load(String.format(BASE_URL_IMAGE, imageSelected.getImage())).into(holder.image);
        } else if (library == ImageLibrary.PICASSO) {
            Picasso.with(activity).load(String.format(BASE_URL_IMAGE, imageSelected.getImage())).into(holder.image);
        } else {
            Uri imageUri = Uri.parse(String.format(BASE_URL_IMAGE, imageSelected.getImage()));
            holder.frescoImage.setImageURI(imageUri);
        }
    }


    @Override
    public int getItemCount() {
        return images.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        SimpleDraweeView frescoImage;

        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.imagem);
            text = (TextView) view.findViewById(R.id.text);
            frescoImage = (SimpleDraweeView) view.findViewById(R.id.fresco_image);
        }
    }
}
