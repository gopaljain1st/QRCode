package com.example.cangoproject.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.R;
import com.example.cangoproject.adapters.BottomSheetAdapter;
import com.example.cangoproject.models.SiteName;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class SearchBottomFragnment extends BottomSheetDialogFragment {

    ImageView close;
    TextView domain, type, state, vendor;
    RadioGroup radioGroup;
    RadioButton radio_active,radio_passive,radio_delete,radio_disable,radio_deployed,radio_pending,radio_ran,radio_core,radio_ftth,radio_humai,radio_nokia,radio_cisco,radio_ericsson;


    Button btnApply,btnClearAll;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.search_bottom_fragnment, container, false);
        close = v.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        btnApply=v.findViewById(R.id.btnApply);
        btnClearAll=v.findViewById(R.id.btnClearAll);

        btnApply.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnClearAll.getText().equals("Clear All")){
                    btnClearAll.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));
                    btnApply.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                }
            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnApply.getText().equals("Apply")){
                    btnClearAll.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    btnApply.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));
                }
            }
        });

        radioGroup = v.findViewById(R.id.radio_group);

        radio_active=v.findViewById(R.id.radio_active);
        radio_passive=v.findViewById(R.id.radio_passive);
        radio_deployed=v.findViewById(R.id.radio_deployed);
        radio_pending=v.findViewById(R.id.radio_pending);
        radio_delete=v.findViewById(R.id.radio_delete);
        radio_disable=v.findViewById(R.id.radio_disable);
        radio_core=v.findViewById(R.id.radio_core);
        radio_ftth=v.findViewById(R.id.radio_ftth);
        radio_ran=v.findViewById(R.id.radio_ran);
         radio_cisco=v.findViewById(R.id.radio_cisco);
         radio_ericsson=v.findViewById(R.id.radio_eripssion);
         radio_humai=v.findViewById(R.id.radio_huwai);
         radio_nokia=v.findViewById(R.id.radio_nokia);



        domain = v.findViewById(R.id.domain);
        type = v.findViewById(R.id.assettype);
        state = v.findViewById(R.id.assetstate);
        vendor = v.findViewById(R.id.vendors);

        type.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));
        radio_active.setVisibility(View.VISIBLE);
        radio_passive.setVisibility(View.VISIBLE);

        domain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (domain.getText().equals("Domains")) {
                    domain.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));
                    type.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    state.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    vendor.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    radio_active.setVisibility(View.GONE);
                    radio_passive.setVisibility(View.GONE);
                    radio_delete.setVisibility(View.GONE);
                    radio_deployed.setVisibility(View.GONE);
                    radio_disable.setVisibility(View.GONE);
                    radio_pending.setVisibility(View.GONE);

                    radio_ran.setVisibility(View.VISIBLE);
                    radio_core.setVisibility(View.VISIBLE);
                    radio_ftth.setVisibility(View.VISIBLE);

                    radio_nokia.setVisibility(View.GONE);
                    radio_ericsson.setVisibility(View.GONE);
                    radio_humai.setVisibility(View.GONE);
                    radio_cisco.setVisibility(View.GONE);



                }
            }
        });

        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type.getText().equals("Asset Type")) {
                    type.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));
                    domain.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    state.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    vendor.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    radio_active.setVisibility(View.VISIBLE);
                    radio_passive.setVisibility(View.VISIBLE);
                    radio_delete.setVisibility(View.GONE);
                    radio_deployed.setVisibility(View.GONE);
                    radio_disable.setVisibility(View.GONE);
                    radio_pending.setVisibility(View.GONE);
                    radio_ran.setVisibility(View.GONE);
                    radio_core.setVisibility(View.GONE);
                    radio_ftth.setVisibility(View.GONE);

                    radio_nokia.setVisibility(View.GONE);
                    radio_ericsson.setVisibility(View.GONE);
                    radio_humai.setVisibility(View.GONE);
                    radio_cisco.setVisibility(View.GONE);

                }
            }
        });

        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state.getText().equals("Asset State")) {
                    type.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    domain.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    state.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));
                    vendor.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                     radio_delete.setVisibility(View.VISIBLE);
                     radio_active.setVisibility(View.GONE);
                    radio_passive.setVisibility(View.GONE);
                    radio_deployed.setVisibility(View.VISIBLE);
                    radio_disable.setVisibility(View.VISIBLE);
                    radio_pending.setVisibility(View.VISIBLE);
                    radio_ran.setVisibility(View.GONE);
                    radio_core.setVisibility(View.GONE);
                    radio_ftth.setVisibility(View.GONE);

                    radio_nokia.setVisibility(View.GONE);
                    radio_ericsson.setVisibility(View.GONE);
                    radio_humai.setVisibility(View.GONE);
                    radio_cisco.setVisibility(View.GONE);

                }
            }
        });

        vendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vendor.getText().equals("Vendors")) {
                    type.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    domain.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    state.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    vendor.setBackgroundDrawable(getResources().getDrawable(R.drawable.border1));

                    radio_nokia.setVisibility(View.VISIBLE);
                    radio_ericsson.setVisibility(View.VISIBLE);
                    radio_humai.setVisibility(View.VISIBLE);
                    radio_cisco.setVisibility(View.VISIBLE);


                    radio_delete.setVisibility(View.GONE);
                    radio_active.setVisibility(View.GONE);
                    radio_passive.setVisibility(View.GONE);
                    radio_deployed.setVisibility(View.GONE);
                    radio_disable.setVisibility(View.GONE);
                    radio_pending.setVisibility(View.GONE);
                    radio_ran.setVisibility(View.GONE);
                    radio_core.setVisibility(View.GONE);
                    radio_ftth.setVisibility(View.GONE);
                }
            }
        });


        return v;
    }
}
