package com.example.cangoproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cangoproject.R;
import com.example.cangoproject.models.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragnment extends Fragment {

    Product product;
    TextView txtTowerId,txtAssetId,txtCabinetId,txtRadioUnitId,txtRadioUnitBandId,txtRadioUnitPlacement,txtRadioUnitType,txtStatus,txtAcceptanceDate,txtIntegrationdate;

    public DetailsFragnment(Product product)
    {
          this.product = product;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_details_fragnment, container, false);

        //find all textview
        txtTowerId=v.findViewById(R.id.txtTdID);
        txtAssetId=v.findViewById(R.id.txtAssID);
        txtCabinetId=v.findViewById(R.id.txtCabID);
        txtRadioUnitId=v.findViewById(R.id.txtRUID);
        txtRadioUnitBandId=v.findViewById(R.id.txtRUBID);
        txtRadioUnitPlacement=v.findViewById(R.id.txtRUPID);
        txtRadioUnitType=v.findViewById(R.id.txtRUTID);
        txtStatus=v.findViewById(R.id.txtStatus);
        txtAcceptanceDate=v.findViewById(R.id.txtAcceptDate);
        txtIntegrationdate=v.findViewById(R.id.txtIntegrationDate);


        txtAcceptanceDate.setText(product.getAcceptanceDate());
        txtTowerId.setText(product.getTowerId());
        txtCabinetId.setText(product.getCabinetId());
        txtRadioUnitId.setText(product.getRadioUnitId());
        txtRadioUnitBandId.setText(product.getRadioUnitBand());
        txtRadioUnitPlacement.setText(product.getRadioUnitPlacement());
        txtRadioUnitType.setText(product.getRadioUnitType());
        txtStatus.setText(product.getStatus());
        txtIntegrationdate.setText(product.getIntegrationDate());
        txtAssetId.setText(product.getAssetId());

        return v;
    }
}
