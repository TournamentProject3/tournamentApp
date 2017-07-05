package com.example.irem.tournament;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TournamentModes extends Activity {

    private Button btnElem;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentmodes);

        btnElem = (Button) findViewById(R.id.btn_eleminationMode);

        btnElem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TournamentModes.this, EliminationMode.class);
                startActivity(intent);
                finish();
            }
        });
    }
}