package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        decrementQuality(items[i]);
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    incrementQuality(items[i]);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality < 50) {
                            if (items[i].sellIn < 11) {
                                incrementQuality(items[i]);
                            }
                            if (items[i].sellIn < 6) {
                                incrementQuality(items[i]);
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                decrementQuality(items[i]);
                            }
                        }
                    } else {
                        zeroQuality(items[i]);
                    }
                } else {
                    if (items[i].quality < 50) {
                        incrementQuality(items[i]);
                    }
                }
            }
        }
    }

    private void incrementQuality(Item item) {
        item.quality++;
    }

    private void decrementQuality(Item item) {
        item.quality--;
    }

    private void zeroQuality(Item item) {
        item.quality = 0;
    }
}
