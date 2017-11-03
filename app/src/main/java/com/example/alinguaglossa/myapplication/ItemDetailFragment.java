package com.example.alinguaglossa.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alinguaglossa.myapplication.utility.DownloadImageTask;
import com.example.alinguaglossa.myapplication.utility.AlbumContent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The album content this fragment is presenting.
     */
    private AlbumContent.AlbumItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = AlbumContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.trackName);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        //Create a circularImage for the artwork
        Bitmap myCircleBitmap = createCircularImageFromUrl (mItem.artworkUrl100.toString());
        // Show the album content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText("artistName: " + mItem.artistName);
            ((TextView) rootView.findViewById(R.id.item_detail2)).setText("collectionName: " + mItem.collectionName);
            ((TextView) rootView.findViewById(R.id.item_detail3)).setText("trackName: " + mItem.trackName);
            ((TextView) rootView.findViewById(R.id.item_detail4)).setText("trackPrice: " + mItem.trackPrice);
            ((TextView) rootView.findViewById(R.id.item_detail5)).setText("releaseDate: " + mItem.releaseDate);
            ((ImageView) rootView.findViewById(R.id.circularImage)).setImageBitmap(myCircleBitmap);
        }

        return rootView;
    }

    //Create a circularImage Bitmap from a string Url of an artwork image
    public Bitmap createCircularImageFromUrl (String stringUrl){
        URL url = null;
        Bitmap bitmap = null;
        Bitmap circleBitmap = null;

        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //Download the artwork image
        DownloadImageTask load = new DownloadImageTask();

        try {
            bitmap = load.execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Create a circularImage
        if (bitmap != null){
            circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

            BitmapShader shader = new BitmapShader (bitmap,  Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(shader);

            Canvas c = new Canvas(circleBitmap);
            c.drawCircle(bitmap.getWidth()/2, bitmap.getHeight()/2, bitmap.getWidth()/2, paint);
        }
        return circleBitmap;
    }
}
