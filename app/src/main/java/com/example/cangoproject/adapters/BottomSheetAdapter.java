package com.example.cangoproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
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
    public void onBindViewHolder(@NonNull BottomSheetAdapterViewHolder holder, int position)
    {
        holder.name.setText(al.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class BottomSheetAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public BottomSheetAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
