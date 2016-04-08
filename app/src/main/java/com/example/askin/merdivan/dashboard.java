package com.example.askin.merdivan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Gorkem on 5.6.2015.
 */
public class dashboard extends Activity {

    ImageButton file;
    ImageButton neighbor;
    ImageButton setting;
    ImageButton id;


            @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dashboard);

                addListenerOnButton();
    }


    public void addListenerOnButton() {

        final Context context = this;

        file = (ImageButton) findViewById(R.id.Img1);
        neighbor = (ImageButton) findViewById(R.id.Img2);
        id = (ImageButton) findViewById(R.id.Img3);
        setting = (ImageButton) findViewById(R.id.Img4);

        file.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, file_page.class);
                startActivity(intent);
            }
        });

        neighbor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, neighbor_page.class);
                startActivity(intent);
            }
        });

        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, id_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, setting_page.class);
                startActivity(intent);
            }
        });


    }
}
