package com.example.irem.tournament;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by irem on 6.07.2017.
 */


public class ResultElimination extends AppCompatActivity{

    private TextView inputName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_el);

        inputName=(TextView) findViewById(R.id.regists);
        recyclerView recycler=new recyclerView();
      

        for (String pair : names) {
            Toast.makeText(this, pair.getValue(), Toast.LENGTH_LONG).show();
        }
        Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT).show();


    }
}
