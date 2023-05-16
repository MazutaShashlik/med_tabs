package com.example.smartlab_danilk.zagruzka;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.smartlab_danilk.R;


public class Act3 extends Fragment {

    private ImageView mImageView;
    private int mImageId;

    public Act3() {
    }

    public static Act3 newInstance(int imageId) {
        Act3 fragment = new Act3();
        Bundle args = new Bundle();
        args.putInt("image_id", imageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mImageId = getArguments().getInt("image_id");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zastavka3, container, false);
        mImageView = view.findViewById(R.id.imageView);
        mImageView.setImageResource(mImageId);
        return view;
    }
}