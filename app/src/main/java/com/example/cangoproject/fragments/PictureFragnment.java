package com.example.cangoproject.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cangoproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragnment extends Fragment {

    Bitmap bitmap;
    ImageView imageView;
    public PictureFragnment(Bitmap bitmap)
    {
        this.bitmap = bitmap;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_picture_fragnment, container, false);
        imageView = v.findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);
        return v;
    }
}
