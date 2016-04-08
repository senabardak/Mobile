package com.example.askin.merdivan;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aşkın Sağlam on 8.11.2015.
 *
 */
public class ObservationList extends Activity {
    final List<Observation> observations = new ArrayList<Observation>();
    private String jsonPath = "observations.json";
    private EditText inputSearch;
    JSONArray jArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation_list);

        try {
           getObservations();
          //  loadJSONFromIBM();

        }  catch (JSONException e) {
            e.printStackTrace();
        }

        inputSearch = (EditText) findViewById(R.id.inputSearch);

        final ListView our_observation_list = (ListView) findViewById(R.id.list);
        final ObservationListAdapter adapter = new ObservationListAdapter(this, observations);
        our_observation_list.setAdapter(adapter);

        our_observation_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // selected item
                Observation observation_data = adapter.getItem(position);

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(ObservationList.this, ObservationDetail.class);
                // sending data to new activity
                i.putExtra("observation id", observation_data.getId());
                i.putExtra("observation status", observation_data.getStatus());
                i.putExtra("observation topic", observation_data.getTopic());
                i.putExtra("observation vote", (int)observation_data.getVote());
                i.putExtra("observation date", observation_data.getDate());
                i.putExtra("observation summary", observation_data.getSummary());
                i.putExtra("observation address", observation_data.getAddress());
                i.putExtra("observation user", observation_data.getUser());
                i.putExtra("observation lat", (double)observation_data.getLat());
                i.putExtra("observation lng", (double)observation_data.getLng());
                i.putExtra("observation_image", observation_data.getImage());
                startActivity(i);
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Observation> temp = new ArrayList<Observation>();
                int textlength = inputSearch.getText().length();
                temp.clear();
                for (int i = 0; i < observations.size(); i++) {
                    if (textlength <= observations.get(i).getTopic().length()) {
                        if (inputSearch.getText().toString().equalsIgnoreCase((String) observations.get(i).getTopic().subSequence(0, textlength))) {
                            temp.add(observations.get(i));
                        }
                    }
                }

                ObservationListAdapter tempAdapter = new ObservationListAdapter(ObservationList.this, temp);
                our_observation_list.setAdapter(tempAdapter);
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











    private void getObservations() throws JSONException {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }
            @Override
            protected Void doInBackground(Void... params) {
             try {
            JSONObject json = null;
            JSONParser jParser = new JSONParser();
            // Getting JSON from URL

            json = jParser.getJSONFromUrl("http://observerwebapi.eu-gb.mybluemix.net/api/last20comp.php");

            JSONArray jArray = json.getJSONArray("observations");

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);

                int id = json_data.getInt("id");
                String topic = json_data.getString("topic");
                String status = json_data.getString("status");
                String user = json_data.getString("user");
                int vote = json_data.getInt("vote");
                String date = json_data.getString("date");
                String summary = json_data.getString("summary");
                String address = json_data.getString("address");
                Double lat = json_data.getDouble("lat");
                Double lng = json_data.getDouble("lng");
              //  String image = json_data.getString("img");



                observations.add(new Observation(id, topic, status, user, vote, date, summary, address, lat, lng));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

    }

}.execute();
    }



//        public void loadJSONFromIBM() throws IOException {
//
//        new AsyncTask<Void, Void, Void>() {
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//
//            }
//
//            @Override
//            protected Void doInBackground(Void... params) {
//
//                try {
//
//                    //------------------>>
//                    HttpGet httpget = new HttpGet("https://php-api.eu-gb.mybluemix.net/api/getAllObservations");
//                    HttpClient httpclient = new DefaultHttpClient();
//                    httpget.addHeader("Api-Key","317fba97898a387b4d7f987489398185f1bf7a0ea49eb8e5e5ca1a2d06f8bc3da89d9e322c00e74d1e0aaf874df7826f8da286f1bc35b15e263746f3810a3d54");
//                    HttpResponse response = httpclient.execute(httpget);
//
//                    // StatusLine stat = response.getStatusLine();
//                    int statuss = response.getStatusLine().getStatusCode();
//
//                    if (statuss == 200) {
//                        HttpEntity entity = response.getEntity();
//                        String data = EntityUtils.toString(entity);
//
//
//                        JSONObject jsono = new JSONObject(data);
//                        //   JSONParser jParser = new JSONParser();
//                        jArray = jsono.getJSONArray("observations");
//
////                        JSONObject json = null;
////                        JSONParser jParser = new JSONParser();
////
////                        jArray = json.getJSONArray("observations");
//
//                        for (int i = 0; i < jArray.length(); i++) {
//                            JSONObject json_data = jArray.getJSONObject(i);
//
//                            int id = json_data.getInt("ObservationId");
//                            String topic = json_data.getString("ObservationType");
//                            String status = json_data.getString("StatusName");
//                            String user = json_data.getString("Username");
//                            int vote = json_data.getInt("StatusId");
//                            String date = json_data.getString("Date");
//                            String summary = json_data.getString("Summary");
//                            String address = json_data.getString("Address");
//                            Double lat = json_data.getDouble("Lat");
//                            Double lng = json_data.getDouble("Lng");
//                          // String image = json_data.getString("img");
//
//
//
//                            observations.add(new Observation(id, topic, status, user, vote, date, summary, address, lat, lng));
//                        }
//
//
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                } catch (ClientProtocolException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//
//
//            @Override
//            protected void onPostExecute (Void result){
//
//            }
//
//        }.execute();
//
//    }




}
