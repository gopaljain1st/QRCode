package com.example.cangoproject.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.TestFlashLight;
import com.example.cangoproject.models.Radio;

import java.util.ArrayList;
import java.util.HashMap;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.RadioViewHolder> {

    Context context;
    ArrayList<Radio> al;
    HashMap<String,String>hm;
    AlertDialog.Builder builder;

    public RadioAdapter(Context context, ArrayList<Radio> al,HashMap<String,String>hm) {
        this.context = context;
        this.al = al;
        this.hm = hm;
    }

    @NonNull
    @Override
    public RadioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.radio_card,parent,false);
        return new RadioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioViewHolder holder, int position) {

      final   Radio radio=al.get(position);
        holder.radio_unit.setText(radio.getRadio_unit());
        holder.radio_name.setText(radio.getRadio_name());
        holder.radio_id.setText(radio.getRadio_id());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                hm.put("radioId",radio.getRadio_id());
                hm.put("radioName",radio.getRadio_name());
                hm.put("radioUnit",radio.getRadio_unit());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(context,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                      //ActivityCompat.requestPermissions(new String[] {Manifest.permission.CAMERA}, 1);
                        ActivityCompat.requestPermissions((Activity)context,
                                new String[] {Manifest.permission.CAMERA},
                                1);
                    }
                    else {
                        context.startActivity(new Intent(context, TestFlashLight.class).putExtra("hm",hm));
                    }
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class RadioViewHolder extends RecyclerView.ViewHolder {
        TextView radio_name,radio_id,radio_unit;;
        CardView card;
        public RadioViewHolder(@NonNull View itemView) {
            super(itemView);

            radio_id=itemView.findViewById(R.id.domain_id);
            radio_name=itemView.findViewById(R.id.domian_name);
            radio_unit=itemView.findViewById(R.id.domain_number);
            card=itemView.findViewById(R.id.card);
        }
    }
}
