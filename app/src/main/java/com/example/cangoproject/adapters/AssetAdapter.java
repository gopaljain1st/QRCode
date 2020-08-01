package com.example.cangoproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.RadioAsset;
import com.example.cangoproject.models.AssetModel;
import com.example.cangoproject.models.Domian;

import java.util.ArrayList;

public class AssetAdapter extends RecyclerView.Adapter<AssetAdapter.AssetViewholder>  {

    Context context;
    ArrayList<AssetModel> al;

    public AssetAdapter(Context context, ArrayList<AssetModel> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public AssetViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.asset_list_card,parent,false);
        return new AssetAdapter.AssetViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AssetViewholder holder, int position) {

        AssetModel assetModel=al.get(position);
        holder.domain_number.setText(assetModel.getAsset_number());
        holder.domain_name.setText(assetModel.getAsset_name());
        holder.domain_id.setText(assetModel.getAsset_id());
        holder.imgQr.setImageResource(assetModel.getAsset_image());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, RadioAsset.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class AssetViewholder extends RecyclerView.ViewHolder{
        TextView domain_name,domain_id,domain_number;
        CardView card;
        ImageView imgQr;
        public AssetViewholder(@NonNull View itemView) {
            super(itemView);
            domain_id=itemView.findViewById(R.id.domain_id);
            domain_name=itemView.findViewById(R.id.domian_name);
            domain_number=itemView.findViewById(R.id.domain_number);
            imgQr=itemView.findViewById(R.id.qrCodeImage);
            card=itemView.findViewById(R.id.card);
        }
    }
}
