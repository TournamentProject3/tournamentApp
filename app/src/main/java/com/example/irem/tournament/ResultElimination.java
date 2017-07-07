package com.example.irem.tournament;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by irem on 6.07.2017.
 */


public class ResultElimination extends AppCompatActivity{

    private TextView inputName;
    private String eliminationResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_el);
            eliminationResult = getIntent().getStringExtra("list");
        Gson gson = new Gson();
        Type type = new TypeToken<List<ListItem>>(){}.getType();
        List<ListItem> listItems = gson.fromJson(eliminationResult,type);
        inputName=(TextView) findViewById(R.id.regists);
        recyclerView recycler=new recyclerView();
        /*StringBuilder builder = new StringBuilder();
        for (String details : names) {
            builder.append(details + "\n");
        }

        inputName.setText(builder.toString());*/


      for(int i=0;i<listItems.size(); i++)
           //Toast.makeText(this, names.get(i), Toast.LENGTH_LONG).show();
       inputName.setText(inputName.getText()+""+listItems.get(i).getDesc()+"");




    }
}
