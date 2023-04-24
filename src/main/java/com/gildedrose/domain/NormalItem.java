package com.gildedrose.domain;


import static com.gildedrose.domain.ItemConfig.MINIMUM_ITEM_QUALITY;

public class NormalItem extends Item implements SpecializedItem {
    public NormalItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        this.sellIn--;
        if (this.quality > MINIMUM_ITEM_QUALITY) {
            this.quality--;
        }

        if (this.sellIn < 0 && this.quality > MINIMUM_ITEM_QUALITY) {
            this.quality--;
        }
    }
}
