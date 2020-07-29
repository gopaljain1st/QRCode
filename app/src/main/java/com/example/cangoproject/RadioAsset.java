package com.example.cangoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cangoproject.adapters.DomainAdapter;
import com.example.cangoproject.adapters.RadioAdapter;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.Radio;

import java.util.ArrayList;

public class RadioAsset extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Radio> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_asset);
        recyclerView=findViewById(R.id.rv);
        al=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        al.add(new Radio("RBS Cabinet","NE ID : 252555","1.0"));
        al.add(new Radio("Radio Unit","NE ID : 289555","1.0"));
        al.add(new Radio("BB Cabinet","NE ID : 259786","1.0"));

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RadioAdapter(this,al));


    }
}
