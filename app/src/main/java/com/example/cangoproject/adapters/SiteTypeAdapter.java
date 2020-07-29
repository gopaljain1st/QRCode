package com.example.cangoproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.DomainActivity;
import com.example.cangoproject.ItemClickListner;
import com.example.cangoproject.R;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.SiteProjects;
import com.example.cangoproject.models.SiteType;

import java.util.ArrayList;

public class SiteTypeAdapter extends RecyclerView.Adapter<SiteTypeAdapter.SiteTypeAdapterViewHolder> {

    Context context;
    ArrayList<SiteType> al;

    public SiteTypeAdapter(Context context, ArrayList<SiteType> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public SiteTypeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.site_type_card,parent,false);
        return new SiteTypeAdapter.SiteTypeAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteTypeAdapterViewHolder holder, int position) {
        SiteType siteType=al.get(position);
        holder.assetType.setText(siteType.getAssetType());
        holder.assetNo.setText(siteType.getTypeNumber());

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                context.startActivity(new Intent(context, DomainActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class SiteTypeAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView assetType,assetNo;
        CardView site_type;
        ItemClickListner itemClickListner;
        public SiteTypeAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            assetType=itemView.findViewById(R.id.assetTypeA);
            assetNo=itemView.findViewById(R.id.nooftype);
            site_type=itemView.findViewById(R.id.site_type);
            site_type.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            this.itemClickListner.onItemClickListner(view,getLayoutPosition());
        }

        public void setItemClickListner(ItemClickListner ic){
            this.itemClickListner=ic;
        }


    }
}
