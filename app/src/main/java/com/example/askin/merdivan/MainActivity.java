package com.example.askin.merdivan;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;


public class MainActivity extends TabActivity {

    Button observationButton;
    Button observationListButton;
    Button dashboardButton;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_tab);
        //addListenerOnButton();
        //Intent intent = new Intent(getApplicationContext(), ObservationCreate.class);
        //startActivity(intent);

        TabHost tabspace = getTabHost();
        TabHost.TabSpec sekme;
        Intent i ;

        i = new Intent(this,dashboard.class);
        sekme = tabspace.newTabSpec("dashboard").setIndicator("", getResources().getDrawable(R.drawable.home_icon)).setContent(i);
        tabspace.addTab(sekme);

        i = new Intent(this,ObservationCreate.class);
        sekme = tabspace.newTabSpec("observationCreate").setIndicator("", getResources().getDrawable(R.drawable.eye_icon)).setContent(i);
        tabspace.addTab(sekme);

        i = new Intent(this,ObservationList.class);
        sekme = tabspace.newTabSpec("observationList").setIndicator("", getResources().getDrawable(R.drawable.clipboard_icon)).setContent(i);
        tabspace.addTab(sekme);

        tabspace.setCurrentTab(1);
    }

//    public void onResume()
//    {
//        super.onResume();
//        db = new Database(getApplicationContext());
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    public void addListenerOnButton() {
//
//        final Context context = this;
//
//        observationButton = (Button) findViewById(R.id.button1);
//        observationListButton = (Button) findViewById(R.id.button3);
//        dashboardButton = (Button) findViewById(R.id.button2);
//
//        observationButton.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                Intent intent = new Intent(context, ObservationCreate.class);
//                startActivity(intent);
//            }
//        });
//
//        observationListButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ObservationList.class);
//                startActivity(intent);
//            }
//        });
//
//        dashboardButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, dashboard.class);
//                startActivity(intent);
//            }
//        });


//    }


}
