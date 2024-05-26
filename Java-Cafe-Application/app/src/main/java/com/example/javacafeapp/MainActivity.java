package com.example.javacafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model("Green Tea", getString(R.string.greentea), R.drawable.greentea ));
        modelList.add(new Model("Latte", getString(R.string.latte), R.drawable.late));
        modelList.add(new Model("Orange Smoothie", getString(R.string.orangesmoothie), R.drawable.orange));
        modelList.add(new Model("Orange Vanilla", getString(R.string.orangevanilla), R.drawable.orangevanilla));
        modelList.add(new Model("Cappucino", getString(R.string.cappcuni), R.drawable.cappcunio));
        modelList.add(new Model("Thai Milk Tea", getString(R.string.thaitea), R.drawable.thaitea));
        modelList.add(new Model("Tea", getString(R.string.tea), R.drawable.tea));
        modelList.add(new Model("Bubble Tea", getString(R.string.bubbletea), R.drawable.milk));
        modelList.add(new Model("Matcha Latte", getString(R.string.match), R.drawable.match));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.signOut){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        }

        if(id == R.id.myCart){
            Intent intent = new Intent(this, SummaryActivity.class);
            startActivity(intent);

        }

        if(id == R.id.findUs){
            Intent intent = new Intent(this, findUs.class);
            startActivity(intent);

        }

        return true;
    }
}

