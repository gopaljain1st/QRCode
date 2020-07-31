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

import com.example.cangoproject.AssetTypeActivity;
import com.example.cangoproject.ItemClickListner;
import com.example.cangoproject.R;
import com.example.cangoproject.models.SiteProjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SiteProjectAdapter extends RecyclerView.Adapter<SiteProjectAdapter.SiteProjectAdapterViewHolder>
{
    Context context;
    ArrayList<SiteProjects>al;
    HashMap<String,String> hm;

    public SiteProjectAdapter(Context context, ArrayList<SiteProjects> al) {
        this.context = context;
        this.al = al;
        hm=new HashMap<>();
    }

    @NonNull
    @Override
    public SiteProjectAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.site_project_card,parent,false);
        return new SiteProjectAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteProjectAdapterViewHolder holder, int position) {
      holder.code.setText("Project Code "+al.get(position).getCode());
      holder.pendingTagging.setText(al.get(position).getPendingAsset()+" Assets Pending Tagging");

      holder.setItemClickListner(new ItemClickListner() {
          @Override
          public void onItemClickListner(View v, int position)
          {
              Intent intent=new Intent(context, AssetTypeActivity.class);
              hm.put("projectCode",al.get(position).getCode());
              intent.putExtra("hm",hm);
              context.startActivity(intent);
          }
      });

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class SiteProjectAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView code,pendingTagging;
        ItemClickListner itemClickListner;
        CardView card_site;
        public SiteProjectAdapterViewHolder(@NonNull View itemView)
        {
            super(itemView);
            card_site=itemView.findViewById(R.id.card_side);
            pendingTagging=itemView.findViewById(R.id.pendingTagging);
            code=itemView.findViewById(R.id.code);
            card_site.setOnClickListener(this);
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
