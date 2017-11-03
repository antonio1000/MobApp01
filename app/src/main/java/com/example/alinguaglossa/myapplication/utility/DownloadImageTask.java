package com.example.alinguaglossa.myapplication.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by aLinguaglossa on 02/11/17.
 */

public class DownloadImageTask extends AsyncTask<URL, Void, Bitmap> {

    private static final String LOG_E_TAG = "DownloadImageTask";

    @Override
    protected Bitmap doInBackground(URL... params) {
        URL imageURL = params[0];
        Bitmap downloadedBitmap = null;
        try {
            InputStream inputStream = imageURL.openStream();
            downloadedBitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            Log.e(LOG_E_TAG, e.getMessage());
            e.printStackTrace();
        }
        return downloadedBitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
    }
}

