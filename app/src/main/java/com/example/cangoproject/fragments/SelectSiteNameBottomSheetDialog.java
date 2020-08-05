package com.example.cangoproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.adapters.BottomSheetAdapter;
import com.example.cangoproject.models.SiteName;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class SelectSiteNameBottomSheetDialog extends BottomSheetDialogFragment
{
    RecyclerView recyclerView;
    ArrayList<SiteName>al;
    ImageView close;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.site_bottom_fragment,container,false);
          recyclerView=v.findViewById(R.id.rv);
          close=v.findViewById(R.id.close);
          close.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  dismiss();
              }
          });
          recyclerView.setHasFixedSize(true);
          al=new ArrayList<>();
          al.add(new SiteName(1,"PAG-684638-DYL"));
          al.add(new SiteName(2,"HDK-847478-DUO"));
          al.add(new SiteName(3,"TWI-739633-BUW"));
          al.add(new SiteName(4,"PEQ-392641-LWU"));
          recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
          recyclerView.setAdapter(new BottomSheetAdapter(getContext(),al));
          return v;
    }

}
