package com.example.cangoproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.models.AssetModel;
import com.example.cangoproject.models.SyncModel;

import java.util.ArrayList;

public class SyncListAdapter extends RecyclerView.Adapter<SyncListAdapter.syncviewHolder> {
    Context context;
    ArrayList<SyncModel> al;

    public SyncListAdapter(Context context, ArrayList<SyncModel> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public syncviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.sync_list_card,parent,false);
        return new syncviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull syncviewHolder holder, int position) {
        SyncModel syncModel=al.get(position);
        holder.txtName.setText(syncModel.getSyncName());
        holder.txtId.setText(syncModel.getSyncId());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class syncviewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtId;
        public syncviewHolder(@NonNull View itemView) {
            super(itemView);
            txtId=itemView.findViewById(R.id.txtSyncId);
            txtName=itemView.findViewById(R.id.txtSyncName);
        }
    }
}
