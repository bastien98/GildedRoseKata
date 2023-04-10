package com.gildedrose;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

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
    void goldenMasterTest() throws IOException {
        String[] days = new String[1];
        days[0] = "10";
        String goldenmasterFilePath = CreateGoldenMasterFile.FILENAME;
        File goldenmaster = new File(goldenmasterFilePath);
        String goldenmasterV1FilePath = CreateGoldenMasterFileV1.FILENAME;
        File goldenmasterV1 = new File(goldenmasterV1FilePath);

        CreateGoldenMasterFile.main(days);
        CreateGoldenMasterFileV1.main(days);

        assertEquals(FileUtils.readFileToString(goldenmaster, "utf-8"),
            FileUtils.readFileToString(goldenmasterV1, "utf-8"));
    }

}
