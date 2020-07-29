package com.example.cangoproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.models.Radio;

import java.util.ArrayList;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.RadioViewHolder> {

    Context context;
    ArrayList<Radio> al;

    public RadioAdapter(Context context, ArrayList<Radio> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public RadioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.radio_card,parent,false);
        return new RadioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioViewHolder holder, int position) {

        Radio radio=al.get(position);
        holder.radio_unit.setText(radio.getRadio_unit());
        holder.radio_name.setText(radio.getRadio_name());
        holder.radio_id.setText(radio.getRadio_id());

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class RadioViewHolder extends RecyclerView.ViewHolder{
        TextView radio_name,radio_id,radio_unit;;
        public RadioViewHolder(@NonNull View itemView) {
            super(itemView);

            radio_id=itemView.findViewById(R.id.domain_id);
            radio_name=itemView.findViewById(R.id.domian_name);
            radio_unit=itemView.findViewById(R.id.domain_number);
        }
    }
}
