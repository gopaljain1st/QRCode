package com.example.cangoproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDataActivity extends AppCompatActivity 
{
    TextView id,name,type,price,description,date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_data);
        initComponent();
        Item i= (Item) getIntent().getSerializableExtra("item");
        id.setText(i.getId());
        name.setText(i.getName());
        type.setText(i.getType());
        price.setText(i.getPrice());
        description.setText(i.getDescription());
        date.setText(i.getDate());
    }

    private void initComponent()
    {
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        type=findViewById(R.id.type);
        price=findViewById(R.id.price);
        description=findViewById(R.id.description);
        date=findViewById(R.id.date);
    }
}
