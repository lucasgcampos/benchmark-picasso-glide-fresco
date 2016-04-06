package com.lgcampos.benchmark.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 4/1/16.
 */
public class Image {

    private String label;
    private String urlImage;

    public Image(String label, String urlImage) {
        this.label = label;
        this.urlImage = urlImage;
    }

    public String getLabel() {
        return label;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public static List<Image> getImages() {
        List<Image> images = new ArrayList<>();

        images.add(new Image("Togepi", "http://assets.pokemon.com/assets/cms2/img/pokedex/full//175.png"));
        images.add(new Image("Totodile", "http://assets.pokemon.com/assets/cms2/img/pokedex/full//158.png"));
        images.add(new Image("Bulbasaur", "http://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"));
        images.add(new Image("Charizard", "http://assets.pokemon.com/assets/cms2/img/pokedex/full/006.png"));
        images.add(new Image("Squirtle", "http://assets.pokemon.com/assets/cms2/img/pokedex/full//007.png"));
        images.add(new Image("Scyther", "http://assets.pokemon.com/assets/cms2/img/pokedex/full//123.png"));
        images.add(new Image("Tyranitar", "http://assets.pokemon.com/assets/cms2/img/pokedex/full//248.png"));

        return images;
    }
}
