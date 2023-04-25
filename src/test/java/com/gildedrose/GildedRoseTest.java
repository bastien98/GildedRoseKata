package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemConfig;
import com.gildedrose.services.GildedRose;
import com.gildedrose.services.GildedRoseRefactored;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void originalTest() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void gildedRose_ApprovalTest() {
        // Given
        String[] nameCombos = {
            "+5 Dexterity Vest",
            "Aged Brie",
            "Elixir of the Mongoose",
            "Backstage passes to a TAFKAL80ETC concert",
            "Conjured item",
        };
        Integer[] sellInCombos = {-1, 0, 1, 4, 5, 6, 7, 9, 10, 11};
        Integer[] qualityCombos = {0, 1, 25, 49, 50};

        // When + Then
        CombinationApprovals.verifyAllCombinations(
            this::updateItemQuality,
            nameCombos,
            sellInCombos,
            qualityCombos
        );
    }

    @Test
    void sulfuras_ApprovalTest() {
        // Given
        String[] sulfuras = {
            ItemConfig.ITEM_TYPE_SULFURAS,
        };
        Integer[] sellInCombos = {-1, 0, 1, 4, 5, 6, 7, 9, 10, 11};
        Integer[] qualityCombos = {80};

        // When + Then
        CombinationApprovals.verifyAllCombinations(
            this::updateItemQuality,
            sulfuras,
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
