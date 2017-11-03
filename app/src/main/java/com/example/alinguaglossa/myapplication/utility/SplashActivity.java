package com.example.alinguaglossa.myapplication.utility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.alinguaglossa.myapplication.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get the search query from other activivy
        Bundle b = getIntent().getExtras();
        String query = null; // or other values
        if(b != null)
            query = b.getString("query");

        TextView myAwesomeTextView = findViewById(R.id.searchText);
        myAwesomeTextView.setText("Ricerca in corso per: " + query);

        assert query != null;
        new GetAlbumData(getBaseContext(), SplashActivity.this).execute("http://itunes.apple.com/search?term=" + query.replace(" ", "+"));
    }
}
