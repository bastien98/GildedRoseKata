package com.gildedrose.services;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemFactory;
import com.gildedrose.domain.SpecializedItem;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseRefactored {



    public List<SpecializedItem> items = new ArrayList<>();


    public GildedRoseRefactored(List<Item> items) {

        for (Item item : items) {
            this.items.add(ItemFactory.createItem(item));
        }
    }

    public void updateQuality() {
        List<SpecializedItem> newList = new ArrayList<>();
        for (SpecializedItem item : items) {
            item.updateItem();
            newList.add(item);
        }
        items = newList;
    }
}
