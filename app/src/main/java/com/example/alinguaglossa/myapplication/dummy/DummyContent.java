package com.example.alinguaglossa.myapplication.dummy;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //private static final int COUNT = 0;

    /*static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }*/

    public static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void clearItem() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    public static DummyItem createDummyItem(String id, String artistName, String collectionName, String trackName, Bitmap artworkUrl60, String artworkUrl100, String trackPrice, String releaseDate) {

        return new DummyItem(id, artistName, collectionName, trackName, artworkUrl60, artworkUrl100, trackPrice, releaseDate);
    }

    /*private static String makeDetails(String myPosition) {
        int position = Integer.parseInt(myPosition);
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }*/

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {

        public final String id;
        //public final String wrapperType;
        //public final String kind;
        //public final Integer artistId;
        //public final Integer collectionId;
        //public final Integer trackId;
        public final String artistName; //OK
        public final String collectionName;
        public final String trackName;
        //public final String collectionCensoredName;
        //public final String trackCensoredName;
        //public final String artistViewUrl;
        //public final String collectionViewUrl;
        //public final String trackViewUrl;
        //public final String previewUrl;
        //public final String artworkUrl30;
        //public final Bitmap artworkUrl30;
        public final Bitmap artworkUrl60;
        public final String artworkUrl100;
        //public final Integer collectionPrice;
        public final String trackPrice;
        public final String releaseDate;
        //public final String collectionExplicitness;
        //public final String trackExplicitness;
        //public final Integer discCount;
        //public final Integer discNumber;
        //public final Integer trackCount;
        //public final Integer trackNumber;
        //public final Integer trackTimeMillis;
        //public final String country;
        //public final String currency;
        //public final String primaryGenreName;
        //public final Boolean isStreamable;

        public DummyItem(String id, String artistName, String collectionName, String trackName, Bitmap artworkUrl60, String artworkUrl100, String trackPrice, String releaseDate) {
            this.id = id;
            this.artistName = artistName;
            this.collectionName = collectionName;
            this.trackName = trackName;
            this.artworkUrl60 = artworkUrl60;
            this.artworkUrl100 = artworkUrl100;
            this.trackPrice = trackPrice;
            this.releaseDate = releaseDate;
        }

        @Override
        public String toString() {
            //return content;
            return trackName;
        }
    }
}
