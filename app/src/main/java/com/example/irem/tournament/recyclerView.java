package com.example.irem.tournament;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class recyclerView extends AppCompatActivity {

    private static final String URL_DATA = "https://tournamentapp-a7af2.firebaseio.com/";
    private RecyclerView recyclerView;
    private Adapter adapter;
    private Button btnCastLots;
    private ProgressBar progressBar;
    FirebaseDatabase db;

    private List<ListItem> listItems;
    private int partipicantCountNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        db = FirebaseDatabase.getInstance();


        partipicantCountNumber = Integer.parseInt(getIntent().getStringExtra("count"));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnCastLots = (Button) findViewById(R.id.btn_castLots);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        listItems = new ArrayList<>();
        /*if (4>partipicantCountNumber || partipicantCountNumber>64  ){
            Toast.makeText(getApplicationContext(), "Please enter value between 4 and 64!", Toast.LENGTH_SHORT).show();
        }*/



       /* if(partipicantCountNumber){

        }*/




        //loadRecyclerViewData();

        //recycle loop

        for(int i = 0; i<partipicantCountNumber; i++) {

            ListItem listItem = new ListItem(
                    "Katılımcı İsmi: "
            );


                listItems.add(listItem);
        }
        adapter = new Adapter(listItems,this);
        recyclerView.setAdapter(adapter);


        btnCastLots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<adapter.getItemCount();i++){
                    String str = adapter.listItems.get(i).getDesc();
                    Log.d("Edittext Data:",str);

                }
                /*if (TextUtils.isEmpty(textViewDesc)) {
                    Toast.makeText(getApplicationContext(), "Enter participant name!", Toast.LENGTH_SHORT).show();
                }*/


                //addParticipant(participant);
             //   startActivity(new Intent(recyclerView.this, ResultElimination.class));

            }

           /* private void addParticipant(String name) {
                DatabaseReference dbRef = db.getReference("Participant");
                String key = dbRef.push().getKey();//kayıtların üst üste yazılmaması için
                DatabaseReference dbRefNew = db.getReference("Participant/" + key);
                dbRefNew.setValue(new Participant(name));

            }
            */


        });

    }


   /* private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("client_info");

                            for (int i = 0; i<array.length(); i++){
                                JSONObject o = array.getJSONObject(i);
                                ListItem item = new ListItem(
                                        o.getString("client_info")
                                );

                                listItems.add(item);
                            }
                            adapter = new Adapter(listItems,getApplicationContext());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse (VolleyError volleyError){
                            progressDialog.dismiss();
                           Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                        }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);*/

   }

