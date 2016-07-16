package edu.galileo.android.rifamania.rifalistitem.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import edu.galileo.android.rifamania.R;

public class RifaListItemActivity extends AppCompatActivity {
    private String name;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rifa_list_item);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        name = intent.getStringExtra("nombre");
        Log.d("DATOS",id + " - " + name);
    }
}
