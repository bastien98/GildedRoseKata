package com.gildedrose.domain;


import static com.gildedrose.domain.ItemConfig.MAXIMUM_ITEM_QUALITY;

public class AgedBrie extends Item implements SpecializedItem {

    public AgedBrie(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
            this.sellIn--;
            if (this.quality < MAXIMUM_ITEM_QUALITY) {
                this.quality++;
            }
            if (this.quality < MAXIMUM_ITEM_QUALITY && this.sellIn < 0) {
                this.quality++;
            }
    }
}
