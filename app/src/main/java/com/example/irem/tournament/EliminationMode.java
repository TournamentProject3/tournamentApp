package com.example.irem.tournament;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by irem on 20.06.2017.
 */

public class EliminationMode extends Activity {

    private EditText txtTournamentName, txtParticipantsNumber;
    private Button btnAddParticipants;
    private LinearLayout participantsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminationmode);
        btnAddParticipants = (Button) findViewById(R.id.btnAdd);

        txtTournamentName = (EditText) findViewById(R.id.edtTextTournamentName);
        txtParticipantsNumber = (EditText) findViewById(R.id.edtTextCount);

        btnAddParticipants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtTournamentName.getText().toString().trim().equals("") )
                {
                    Toast.makeText(getApplicationContext(),"please enter the tournament name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (txtParticipantsNumber.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter value between 4 and 64!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String val = txtParticipantsNumber.getText().toString();
                int partCountVal = Integer.parseInt(val);
                if(4>partCountVal || partCountVal>64){
                    Toast.makeText(getApplicationContext(), "Please enter value between 4 and 64!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(EliminationMode.this, recyclerView.class);
                intent.putExtra("count", txtParticipantsNumber.getText().toString());
                startActivity(intent);
            }
        });
    }
}



