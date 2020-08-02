package com.example.cangoproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.DetailsActivity;
import com.example.cangoproject.R;
import com.example.cangoproject.RadioAsset;
import com.example.cangoproject.models.AssetModel;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.Product;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class AssetAdapter extends RecyclerView.Adapter<AssetAdapter.AssetViewholder>  {

    Context context;
    ArrayList<Product> al;

    public AssetAdapter(Context context, ArrayList<Product> al) {
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

        final Product assetModel=al.get(position);
        holder.domain_number.setText(assetModel.getRadioUnit());
        holder.domain_name.setText(assetModel.getRadioName());
        holder.domain_id.setText(assetModel.getRadioId());
        holder.imgQr.setImageResource(R.drawable.qrcode);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(context, DetailsActivity.class);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                assetModel.getImage().compress(Bitmap.CompressFormat.PNG,100,stream);
                byte[] byteArray = stream.toByteArray();
                in.putExtra("image",byteArray);
                assetModel.setImage(null);
                in.putExtra("product",assetModel);
                context.startActivity(in);
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
