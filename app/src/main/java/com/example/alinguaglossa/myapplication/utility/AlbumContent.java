package com.example.alinguaglossa.myapplication.utility;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class AlbumContent {

    /**
     * An array of items.
     */
    public static final List<AlbumItem> ITEMS = new ArrayList<AlbumItem>();

    /**
     * A map of items, by ID.
     */
    public static final Map<String, AlbumItem> ITEM_MAP = new HashMap<String, AlbumItem>();


    public static void addItem(AlbumItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void clearItem() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    public static AlbumItem createDummyItem(String id, String artistName, String collectionName, String trackName, Bitmap artworkUrl60, String artworkUrl100, String trackPrice, String releaseDate) {

        return new AlbumItem(id, artistName, collectionName, trackName, artworkUrl60, artworkUrl100, trackPrice, releaseDate);
    }

    /**
     * A album item representing a piece of content.
     */
    public static class AlbumItem {

        public final String id;
        public final String artistName;
        public final String collectionName;
        public final String trackName;
        public final Bitmap artworkUrl60;
        public final String artworkUrl100;
        public final String trackPrice;
        public final String releaseDate;

        public AlbumItem(String id, String artistName, String collectionName, String trackName, Bitmap artworkUrl60, String artworkUrl100, String trackPrice, String releaseDate) {
            this.id = id;
            this.artistName = artistName;
            this.collectionName = collectionName;
            this.trackName = trackName;
            this.artworkUrl60 = artworkUrl60;
            this.artworkUrl100 = artworkUrl100;
            this.trackPrice = trackPrice;
            this.releaseDate = releaseDate;
        }
    }
}
