package com.gildedrose.services;

import com.gildedrose.domain.AgedBrie;
import com.gildedrose.domain.BackStagePass;
import com.gildedrose.domain.Item;
import com.gildedrose.domain.Normal;
import com.gildedrose.domain.Sulfuras;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseRefactored {

    public static final int MINIMUM_ITEM_QUALITY = 0;
    public static final int MAXIMUM_ITEM_QUALITY = 50;

    public  List<Item> items;


    public GildedRoseRefactored(List<Item> items) {

        this.items = items;
    }

    public void updateQuality() {
        List<Item> newList = new ArrayList<>();
        for (Item item : items) {
            if (isNormalItem(item)) {
                Normal item1 = new Normal(item.name, item.sellIn, item.quality);
                item1.updateItem();
                newList.add(item1);
            }
            if ("Aged Brie".equals(item.name)) {
                AgedBrie item1 = new AgedBrie(item.name, item.sellIn, item.quality);
                item1.updateItem();
                newList.add(item1);

            }
            if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
                // Do Nothing (Legendary Item)
                Sulfuras item1 = new Sulfuras(item.name, item.sellIn, item.quality);
                newList.add(item1);
            }
            if (isBackStageItem(item)) {
                BackStagePass item1 = new BackStagePass(item.name, item.sellIn, item.quality);
                item1.updateItem();
                newList.add(item1);
            }

        }
        items = newList;
    }

    private boolean isNormalItem(Item item) {
        return !"Sulfuras, Hand of Ragnaros".equals(item.name) && !"Aged Brie".equals(item.name) && !isBackStageItem(item);
    }

    private boolean isBackStageItem(Item item) {
        String subString = "Backstage passes";
        return item.name.contains(subString);
    }
}
