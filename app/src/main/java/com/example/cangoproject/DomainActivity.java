package com.example.cangoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cangoproject.adapters.DomainAdapter;
import com.example.cangoproject.adapters.SiteTypeAdapter;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.SiteType;

import java.util.ArrayList;

public class DomainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Domian> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain);

        recyclerView=findViewById(R.id.rv);
        al=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        al.add(new Domian("Core","Core ID : 20","12"));
        al.add(new Domian("RAN","RAN ID : 25","100"));
        al.add(new Domian("TRM","TRM ID : 28","52"));
        al.add(new Domian("FTTH","FTTH ID : 30","82"));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DomainAdapter(this,al));

    }
}
