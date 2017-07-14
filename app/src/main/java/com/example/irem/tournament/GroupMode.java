package com.example.irem.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by irem on 20.06.2017.
 */



public class GroupMode extends AppCompatActivity {
    private EditText txtTournamentName, txtParticipantsNumber,txtGroupNumber;
    private Button btnAddParticipants;
    private RadioButton radioBtnSingle,radioBtnDouble;
    private int partCountVal;
    private int groupCountVal;
    private RadioGroup radioGrp;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmode);


        txtTournamentName = (EditText) findViewById(R.id.edtTextTournamentNameGroup);
        txtParticipantsNumber = (EditText) findViewById(R.id.edtTextPartCountGroup);
        txtGroupNumber = (EditText) findViewById(R.id.edtTextGroupCount);
        btnAddParticipants = (Button) findViewById(R.id.btnAddGroup);
        radioBtnSingle = (RadioButton) findViewById(R.id.radioSingle);
        radioBtnDouble = (RadioButton) findViewById(R.id.radioDouble);
        radioGrp = (RadioGroup) findViewById(R.id.radioGroup);



            btnAddParticipants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtTournamentName.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter the tournament name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (txtParticipantsNumber.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter value between 4 and 64!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (txtGroupNumber.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Group number!", Toast.LENGTH_SHORT).show();
                    return;
                }


                String val = txtParticipantsNumber.getText().toString();
                partCountVal = Integer.parseInt(val);
                if (4 > partCountVal || partCountVal > 64) {
                    Toast.makeText(getApplicationContext(), "Please enter value between 4 and 64!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String val1 = txtGroupNumber.getText().toString();
                groupCountVal = Integer.parseInt(val1);
                if (2 > groupCountVal) {
                    Toast.makeText(getApplicationContext(), "Please enter value 2 or more", Toast.LENGTH_SHORT).show();
                    return;
                }

                if ((int)(partCountVal / groupCountVal) < 2) {
                    Toast.makeText(getApplicationContext(), "The number of participants must be added to each group of at least 2 participants.", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent intent = new Intent(GroupMode.this, recyclerView.class);
                intent.putExtra("count", txtParticipantsNumber.getText().toString());
                intent.putExtra("countGroup", txtGroupNumber.getText().toString());
                intent.putExtra("radioSingle",radioBtnSingle.isChecked());
                startActivity(intent);
            }
        });
        }
    }

