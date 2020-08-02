package com.example.cangoproject.adapters;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cangoproject.models.Product;
import com.example.cangoproject.fragments.DetailsFragnment;
import com.example.cangoproject.fragments.PictureFragnment;

public class FragAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    Product product;
    Bitmap bitmap;

    public FragAdapter(Context context, FragmentManager fm, int totalTabs, Product product,Bitmap bitmap) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
        this.product = product;
        this.bitmap = bitmap;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DetailsFragnment detailsFragment = new DetailsFragnment(product);
                return detailsFragment;
            case 1:
                PictureFragnment pictureFragment = new PictureFragnment(bitmap);
                return pictureFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}