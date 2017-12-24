package com.yudhistiroagung.easylistview;

/**
 * Created by yudhistiroagung on 12/24/17.
 */

public class Product implements ListItem{

    private String name;
    private String description;
    private String image;

    public Product(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    @Override
    public String getTitle() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getImageUrl() {
        return this.image;
    }

}
