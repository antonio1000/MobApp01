package com.example.alinguaglossa.myapplication.utility;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.alinguaglossa.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by aLinguaglossa on 03/11/17.
 */

public class AlbumJSONParse extends AsyncTask<String, Void, JSONArray> {

    private Context context;
    private Activity mActivity;

    public AlbumJSONParse(Context context, Activity activity){
        this.context=context;
        this.mActivity=activity;
    }

    @Override
    protected JSONArray doInBackground(String... s) {
        JSONObject obj = null;
        int nItem =0;
        JSONArray jsonArray = null;

        try {

            obj = new JSONObject(s[0]);

            Log.d("My App", obj.toString());

        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + s + "\"");
        }


        try {
            assert obj != null;
            nItem = obj.getInt("resultCount");
            jsonArray = new JSONArray();
            jsonArray = obj.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonArray;

    }

    @Override
    protected void onPostExecute(JSONArray myJsonArray) {
        super.onPostExecute(myJsonArray);
        URL url = null;
        Bitmap returned_bitmap = null;
        for (int i=0; i<myJsonArray.length(); i++){
            JSONObject  tmpObj = null;
            try {
                tmpObj = myJsonArray.getJSONObject(i);
                url = new URL(tmpObj.getString("artworkUrl30"));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            DownloadImageTask load = new DownloadImageTask();

            try {
                returned_bitmap = load.execute(url).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            try {
                assert tmpObj != null;
                AlbumContent.addItem(AlbumContent.createDummyItem(String.valueOf(i), tmpObj.getString("artistName"), tmpObj.getString("collectionName"), tmpObj.getString("trackName"), returned_bitmap, tmpObj.getString("artworkUrl100"), tmpObj.getString("trackPrice"), tmpObj.getString("releaseDate")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(context, context.getString(R.string.end_search),
                Toast.LENGTH_LONG).show();

        this.mActivity.finish();
    }

}