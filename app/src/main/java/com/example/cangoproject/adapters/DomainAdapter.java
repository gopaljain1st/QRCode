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

import com.example.cangoproject.R;
import com.example.cangoproject.RadioAsset;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.SiteType;

import java.util.ArrayList;
import java.util.HashMap;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.DomainViewholder> {

    Context context;
    ArrayList<Domian> al;
    HashMap<String,String>hm;

    public DomainAdapter(Context context, ArrayList<Domian> al,HashMap<String,String>hm) {
        this.context = context;
        this.al = al;
        this.hm=hm;
    }

    @NonNull
    @Override
    public DomainViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.domain_card,parent,false);
        return new DomainAdapter.DomainViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DomainViewholder holder, int position) {

        final Domian domian=al.get(position);
        holder.domain_number.setText(domian.getDomain_number());
        holder.domain_name.setText(domian.getDomain_name());
        holder.domain_id.setText(domian.getDomain_id());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                hm.put("domainId",domian.getDomain_id());
                context.startActivity(new Intent(context, RadioAsset.class).putExtra("hm",hm));
            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class DomainViewholder extends RecyclerView.ViewHolder{
        TextView domain_name,domain_id,domain_number;
        CardView card;
        public DomainViewholder(@NonNull View itemView) {
            super(itemView);
            domain_id=itemView.findViewById(R.id.domain_id);
            domain_name=itemView.findViewById(R.id.domian_name);
            domain_number=itemView.findViewById(R.id.domain_number);
            card=itemView.findViewById(R.id.card);
        }
    }
}
