package com.example.cangoproject.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.SiteActivity;
import com.example.cangoproject.models.SiteName;

import java.util.ArrayList;

public class BottomSheetAdapter extends RecyclerView.Adapter<BottomSheetAdapter.BottomSheetAdapterViewHolder>
{
    Context context;
    ArrayList<SiteName>al;

    public BottomSheetAdapter(Context context, ArrayList<SiteName> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public BottomSheetAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.site_card,parent,false);
        return new BottomSheetAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BottomSheetAdapterViewHolder holder, final int position)
    {
        holder.name.setText(al.get(position).getName());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SiteActivity.class);
                intent.putExtra("id",al.get(position).getId());
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class BottomSheetAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView card;
        public BottomSheetAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            card=itemView.findViewById(R.id.card);
        }
    }
}
