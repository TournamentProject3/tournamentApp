package com.example.irem.tournament;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by irem on 20.06.2017.
 */

public class EliminationMode extends Activity {
    private EditText txtTournamentName,txtParticipantsNumber;
    private Button btnAddParticipants;
    private LinearLayout participantsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminationmode);

        btnAddParticipants = (Button) findViewById(R.id.btnAdd);
        txtTournamentName = (EditText) findViewById(R.id.edtTextTournamentName);
        txtParticipantsNumber = (EditText) findViewById(R.id.edtTextCount);
        participantsLayout = (LinearLayout) findViewById(R.id.linearlayout);

        btnAddParticipants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable tournamentName = txtTournamentName.getText();
                int participantsNumber = Integer.parseInt(txtParticipantsNumber.getText().toString());
                createParticipants(participantsNumber);
            }
        });
    }
    public void createParticipants(int numOfParticipants){

        final EditText[] myEditTextViews = new EditText[numOfParticipants]; // create an empty array;

        for (int i = 0; i < numOfParticipants; i++) {
            // create a new textview
            final EditText rowEditView = new EditText(this);
            // set some properties of rowTextView or something
            rowEditView.setText("This is row #" + i);
            // add the textview to the linearlayout
            participantsLayout.addView(rowEditView);
            // save a reference to the textview for later
            myEditTextViews[i] = rowEditView;
            myEditTextViews[i].setVisibility(View.VISIBLE);

            LinearLayout parent = new LinearLayout(getContext());
            LayoutParams parentLayoutParams = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            parent.setLayoutParams(parentLayoutParams);

            outerlayout.addView(parent);


        }
    }
}
