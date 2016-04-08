package com.example.askin.merdivan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class setting_page extends ActionBarActivity {

    Button about_us;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

       about_us = (Button) findViewById(R.id.AboutButton);


        about_us.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, about_page.class);
                startActivity(intent);
            }
        });



    }
}
