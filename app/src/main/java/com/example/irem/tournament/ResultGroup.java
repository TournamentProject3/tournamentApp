package com.example.irem.tournament;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by irem on 11.07.2017.
 */

public class ResultGroup extends AppCompatActivity {

    private TextView inputNameGroup;
    List<ListItem> listItems;
    List<String> matchedGroup;
    ArrayList<String> listGroup = new ArrayList<>();
    ArrayList<String> remains = new ArrayList<>();

    private int groupCountNumber;
    private String groupResult;
    private int partipicantCountNumber;
    private Boolean radioButtonSingle;
    private Button buttonDetails;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_group);
        inputNameGroup = (TextView) findViewById(R.id.txtViewCountGroup);
        buttonDetails = (Button) findViewById(R.id.btnMatchDetails);
        groupResult = getIntent().getStringExtra("listGroup");
        Gson gson = new Gson();
        Type type = new TypeToken<List<ListItem>>() {
        }.getType();
        listItems = gson.fromJson(groupResult, type);

        groupCountNumber = Integer.parseInt(getIntent().getStringExtra("countGroup"));
        partipicantCountNumber = getIntent().getIntExtra("count", partipicantCountNumber);
        radioButtonSingle = getIntent().getBooleanExtra("radioSingle", true);

/*mesela 6 kişi 2 grup veya 8 kişi 2 grup şeklinde kalansız bölünen*/
        if ((partipicantCountNumber % groupCountNumber) == 0) {
            for (int i = 1; i < groupCountNumber + 1; i++) {
                inputNameGroup.setText(inputNameGroup.getText() + "" + i + ".Group \n");

/*bir grupta olması gereken şikileri random seçiyor*/
                for (int j = 0; j < (int) (partipicantCountNumber / groupCountNumber); j++) {

                    Random randomizer = new Random();
                    ListItem random = listItems.get(randomizer.nextInt(listItems.size()));
                    String random1 = random.getDesc();
                    inputNameGroup.setText(inputNameGroup.getText() + "" + random1 + "|");
                    listGroup.add(random1);
                    listItems.remove(random);
                }
                inputNameGroup.setText(inputNameGroup.getText() + "\n");

                Groups();/*Bir gruptaki eşleşmeleri belirliyor*/


            }
        }


/*mesela 7 kişi 2 grup şeklinde kalanlı bölünenlerde else e gidiyor*/
        else {

            for (int i = 1; i < groupCountNumber + 1; i++) {
                inputNameGroup.setText(inputNameGroup.getText() + "" + i + ".Group \n");

                for (int j = 0; j < (int) (partipicantCountNumber / groupCountNumber); j++) {/*her grup için random elemanları şeçiyor*/
                        Random randomizer = new Random();
                        ListItem random = listItems.get(randomizer.nextInt(listItems.size()));
                        String random2 = random.getDesc();
                        inputNameGroup.setText(inputNameGroup.getText() + "" + random2 + "|"+"");
                        listGroup.add(random2);
                        listItems.remove(random);


                }
/*bir ya da birden fazla gruba ekstradan eleman eklemek için*/
                if (listItems.size() > 0 & listItems.size()!=(int) (partipicantCountNumber / groupCountNumber) ) {

                    Random randomizer1 = new Random();
                    ListItem random1 = listItems.get(randomizer1.nextInt(listItems.size()));
                    String random3 = random1.getDesc();
                    inputNameGroup.setText(inputNameGroup.getText() + "" + random3 + "\n");
                    listGroup.add(random3);
                    listItems.remove(random1);


                }
                for(int x=0;x<listGroup.size();x++)
                {
                    for (int y = x+1; y < listGroup.size(); y++) {

                        inputNameGroup.setText(inputNameGroup.getText() + "" + listGroup.get(x) + " vs " + listGroup.get(y) + "\n");
                    }

                    if ((listGroup.size()) % 2 == 1) {

                        inputNameGroup.setText(inputNameGroup.getText() + "" + listGroup.get(x) + " vs " + "-" + "\n");
                    }

                }
                listGroup.clear();

                }



                inputNameGroup.setText(inputNameGroup.getText() + "\n");
            }
        }

    public void Groups()
    {
        for(int x=0;x<listGroup.size();x++)/*Grubun birinci elemanından başlıyor*/
        {

            for (int y = x+1; y < listGroup.size(); y++) {/*x elemanıyla diğer elemanları teker teker eşleştiriyor*/
            inputNameGroup.setText(inputNameGroup.getText() + "" + listGroup.get(x) + " vs " + listGroup.get(y) + "\n");
                if(y<listGroup.size())
                {
                    if ((partipicantCountNumber / groupCountNumber) % 2 == 1) {/*buy geçenleri alıyor*/
                        inputNameGroup.setText(inputNameGroup.getText() + "" + listGroup.get(x) + " vs " + "-" + "\n");
                    }
                }
            }



        }
        listGroup.clear();

    }


    public int MatchNumber(int n) {
        return (n * (n - 1)) / 2;


    }


}


