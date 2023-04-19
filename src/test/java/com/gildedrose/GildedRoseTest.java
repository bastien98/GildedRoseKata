package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.services.GildedRose;
import com.gildedrose.services.GildedRoseRefactored;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void orignalTest() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void abc() {

        // Given
        String[] nameCombos = {
            "+5 Dexterity Vest",
            "Aged Brie",
            "Elixir of the Mongoose",
            "Sulfuras, Hand of Ragnaros",
            "Backstage passes to a TAFKAL80ETC concert"};

        Integer[] sellInCombos = {-1, 0, 5, 6, 7, 10, 11, 12};

        Integer[] qualityCombos = {-1, 0, 1, 49, 50};

        // When + Then
        CombinationApprovals.verifyAllCombinations(
            this::updateItemQuality,
            nameCombos,
            sellInCombos,
            qualityCombos
        );
    }

    private String updateItemQuality(String name, int sellIn, int quality) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(name, sellIn, quality));
        GildedRoseRefactored gildedRoseRefactored = new GildedRoseRefactored(items);
        gildedRoseRefactored.updateQuality();
        return gildedRoseRefactored.items.get(0).toString();
    }


}
