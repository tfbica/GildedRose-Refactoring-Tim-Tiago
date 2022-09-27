package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isAgedBrie(items[i]) || isBackstage(items[i])) {
                if (items[i].quality < 50) {
                    incrementQuality(items[i]);

                    if (isBackstage(items[i])) {
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

            if (!isSulfuras(items[i])) {
                decrementSellIn(items[i]);
            }
            if (isAgedBrie(items[i])) {
                updateAgedBrie(items[i]);
            }
            if (isBackstage(items[i])) {
                updateBackstage(items[i]);
            }

//            Not sure why removing the duplication of updating regular item quality fails the tests
            if (isRegularItem(items[i])){
                updateRegularItem(items[i]);
            }
        }
    }

    private void incrementQuality(Item item) {
        item.quality ++;
    }

    private void decrementQuality(Item item) {
        item.quality --;
    }

    private void zeroQuality(Item item) {
        item.quality = 0;
    }

    private void decrementSellIn(Item item) {
        item.sellIn --;
    }

    private boolean isRegularItem(Item item) {
        return !isAgedBrie(item) && !isBackstage(item) && !isSulfuras(item);
    }

    private void updateRegularItem(Item item) {
        if (item.sellIn < 0 && item.quality > 1) {
            decrementQuality(item);
            decrementQuality(item);
        } else {
            decrementQuality(item);
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void updateAgedBrie(Item item) {
        if (item.sellIn < 0 && item.quality < 50) {
            incrementQuality(item);
        }
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateBackstage(Item item) {
        if (item.sellIn < 0) {
            zeroQuality(item);
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateSulfuras(Item item) {

    }




}
