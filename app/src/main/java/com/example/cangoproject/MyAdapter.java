package com.example.cangoproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder>
{
    Context context;
    ArrayList<Product>al;

    public MyAdapter(Context context, ArrayList<Product> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_card,parent,false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewHolder holder, int position) {

        final Product c=al.get(position);
        holder.name.setText("Name : "+c.getName());
        holder.id.setText("Id : "+c.getId());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ItemDataActivity.class);
                intent.putExtra("product",c);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView id,name;
        ImageView item;
        public MyAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            item=itemView.findViewById(R.id.item);
            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
        }
    }
}
