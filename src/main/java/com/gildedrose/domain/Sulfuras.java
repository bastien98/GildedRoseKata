package com.gildedrose.domain;

public class Sulfuras extends Item implements UpdatableItem {
    public Sulfuras(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public void update() {

    }
}
