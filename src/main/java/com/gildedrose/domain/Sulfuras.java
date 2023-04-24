package com.gildedrose.domain;

public class Sulfuras extends Item implements SpecializedItem {
    public Sulfuras(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public void updateItem() {

    }
}
