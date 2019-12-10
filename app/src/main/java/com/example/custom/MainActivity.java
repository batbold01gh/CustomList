package com.example.custom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    List<Hero> heroList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroList= new ArrayList<>();

        heroList.add(new Hero(R.drawable.batman, "Batman", "Justice League"));
        heroList.add(new Hero(R.drawable.captianamerica, "Captain America", "Avengers"));
        heroList.add(new Hero(R.drawable.doctorstrange, "Doctor Strange", "Avengers"));
        heroList.add(new Hero(R.drawable.ironman, "Iron Man", "Avengers"));
        heroList.add(new Hero(R.drawable.joker, "Joker", "Justice League"));
        heroList.add(new Hero(R.drawable.spiderman, "Spiderman", "Avengers"));


        listView= findViewById(R.id.listView);

        MyCustomListAdapter adapter = new
                MyCustomListAdapter(this, R.layout.my_list_item, heroList);
        listView.setAdapter(adapter);



    }
}
