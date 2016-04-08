package com.example.askin.merdivan;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aşkın Sağlam on 21.12.2015.
 */

public class file_page extends ActionBarActivity {


    final List<citysdk> citysdkdatas = new ArrayList<citysdk>();
    private EditText inputSearch;
    JSONArray jArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citysdk_layout);

        try {
            loadJSONFromCitySdk();

        } catch (IOException e) {
            e.printStackTrace();
        }


        inputSearch = (EditText) findViewById(R.id.search_area);

        final ListView our_citysdk_list = (ListView) findViewById(R.id.list_area);
        final citySdkListAdapter adapter = new citySdkListAdapter(this, citysdkdatas);
        our_citysdk_list.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<citysdk> temp = new ArrayList<citysdk>();
                int textlength = inputSearch.getText().length();
                temp.clear();
                for (int i = 0; i < citysdkdatas.size(); i++) {
                    if (textlength <= citysdkdatas.get(i).getType().length()) {
                        if (inputSearch.getText().toString().equalsIgnoreCase((String) citysdkdatas.get(i).getType().subSequence(0, textlength))) {
                            temp.add(citysdkdatas.get(i));
                        }
                    }
                }

                citySdkListAdapter tempAdapter = new citySdkListAdapter(file_page.this, temp);
                our_citysdk_list.setAdapter(tempAdapter);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }



        public void loadJSONFromCitySdk() throws IOException {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected Void doInBackground(Void... params) {

                try {

                    //------------------>>
                    HttpGet httpget = new HttpGet("http://apicitysdk.ibb.gov.tr/admr.istb.fatih.kemalpasa/nodes?layer=parkingareas");
                    HttpClient httpclient = new DefaultHttpClient();
                    //   httpget.addHeader("Api-Key","317fba97898a387b4d7f987489398185f1bf7a0ea49eb8e5e5ca1a2d06f8bc3da89d9e322c00e74d1e0aaf874df7826f8da286f1bc35b15e263746f3810a3d54");
                    HttpResponse response = httpclient.execute(httpget);


                    int statuss = response.getStatusLine().getStatusCode();

                    if (statuss == 200) {
                        HttpEntity entity = response.getEntity();
                        String data = EntityUtils.toString(entity);


                        JSONObject jsono = new JSONObject(data);

                        jArray = jsono.getJSONArray("results");


                        for (int i = 0; i < jArray.length(); i++) {
                            JSONObject json_data = jArray.getJSONObject(i);

                            String name = json_data.getString("name");
                            String layer = json_data.getString("layer");
                            String type = json_data.getJSONObject("layers").getJSONObject("parkingareas").getJSONObject("data").getString("TURU");



                           citysdkdatas.add(new citysdk(type, name, layer));
                        }


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }


            @Override
            protected void onPostExecute (Void result){

            }

        }.execute();

    }

}

