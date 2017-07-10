package com.example.irem.tournament;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by irem on 6.07.2017.
 */


public class ResultElimination extends AppCompatActivity{

    private TextView inputName;
    List<ListItem> listItems;
    private String eliminationResult;
    Random randomizer = new Random();
    ListItem randomItem;
    String random;
    int randomMatchNumber;


    private int myLog(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public void matchParticipants(int participantNumber, int matchNumber){

        ArrayList<String> randoms = new ArrayList<String>();
        ArrayList<String> remains = new ArrayList<>();
        ArrayList<String> matched = new ArrayList<>();

        for(int i=0; i<matchNumber; i++){
            randomItem = listItems.get(randomizer.nextInt(listItems.size()));
            random = randomItem.getDesc();
            randoms.add(random);
            listItems.remove(randomItem);
            /*if(!random.equals(listItems.get(i).getDesc())) {
                inputName.setText(inputName.getText() + "" + (i + 1) + ". Match is :" + listItems.get(i).getDesc() + " vs " + random + "\n");

            }
            listItems.remove(matcheds.get(i));
            listItems.remove(listItems.get(i).getDesc());*/
            //inputName.setText(inputName.getText() +""+ (i + 1)+". " +random+ " vs "+ "\n");
        }
        for(int i=0; i<randoms.size(); i++){
            matched.add(listItems.get(i).getDesc());
            inputName.setText(inputName.getText() +""+ (i + 1)+". Match is :  " + matched.get(i)+ " vs "+randoms.get(i)+ "\n");

        }
        for(int i=0; i<listItems.size(); i++){
            remains.add(listItems.get(i).getDesc());
        }

        for (int i=0; i<remains.size(); i++ ){
            if(!matched.contains(remains.get(i))){
            inputName.setText(inputName.getText() + "" + (i+1) + ". Match is :  " + remains.get(i) + " vs  - \n" );
            }
        }





    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_el);
        eliminationResult = getIntent().getStringExtra("list");
        Gson gson = new Gson();
        Type type = new TypeToken<List<ListItem>>(){}.getType();
        listItems = gson.fromJson(eliminationResult,type);
        inputName=(TextView) findViewById(R.id.regists);
        recyclerView recycler=new recyclerView();



        if(listItems.size()>0){
            int a = myLog(listItems.size(), 2);
            randomMatchNumber = (int) (listItems.size() - (Math.pow(2,a)));
        }

        if(randomMatchNumber==0){
            randomMatchNumber = listItems.size()/2;
        }


        matchParticipants(listItems.size(), randomMatchNumber);




    }
}
