package com.example.cangoproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.models.SiteProjects;

import java.util.ArrayList;

public class SiteProjectAdapter extends RecyclerView.Adapter<SiteProjectAdapter.SiteProjectAdapterViewHolder>
{
    Context context;
    ArrayList<SiteProjects>al;
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
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class SiteProjectAdapterViewHolder extends RecyclerView.ViewHolder
    {
        TextView code,pendingTagging;
        public SiteProjectAdapterViewHolder(@NonNull View itemView)
        {
            super(itemView);
            pendingTagging=itemView.findViewById(R.id.pendingTagging);
            code=itemView.findViewById(R.id.code);
        }
    }
}
