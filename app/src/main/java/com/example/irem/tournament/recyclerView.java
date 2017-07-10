package com.example.irem.tournament;

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


import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

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
    private List<String> names;
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


        //recycle loop

        for (int i = 0; i < partipicantCountNumber; i++) {

                ListItem listItem = new ListItem(
                        "Katılımcı İsmi: "
                );


            listItems.add(listItem);
        }
        adapter = new Adapter(listItems, this);
        recyclerView.setAdapter(adapter);


        btnCastLots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < adapter.getItemCount(); i++) {
                    String str = adapter.listItems.get(i).getDesc();
                    Log.d("Edittext Data:", str);
                    if (TextUtils.isEmpty(str)) {
                        Toast.makeText(getApplicationContext(), "Enter participant name!", Toast.LENGTH_SHORT).show();
                    }
                    DatabaseReference dbRef = db.getReference("Participant");
                    String key = dbRef.push().getKey();//kayıtların üst üste yazılmaması için
                    DatabaseReference dbRefNew = db.getReference("Participant/" + key);
                    dbRefNew.setValue(new Participant(str));


                }
                Intent intent = new Intent(recyclerView.this,ResultElimination.class);
                Gson gson = new Gson();
                String gSonString = gson.toJson(adapter.listItems);
                intent.putExtra("list",gSonString);
                startActivity(intent);

            }


        });
    }


}






