package com.example.irem.tournament;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TournamentModes extends AppCompatActivity {

    private Button btnElem,btnInfo,btnGroup;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentmodes);

        btnElem = (Button) findViewById(R.id.btn_eleminationMode);
        btnInfo=(Button)findViewById(R.id.btn_modesInfo);
        btnGroup =(Button)findViewById(R.id.btn_groupMode);

        btnElem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TournamentModes.this, EliminationMode.class);
                startActivity(intent);
                finish();
            }
        });
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TournamentModes.this, GroupMode.class);
                startActivity(intent);
                finish();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TournamentModes.this, InfoModes.class);
                startActivity(intent);

            }
        });

    }
}