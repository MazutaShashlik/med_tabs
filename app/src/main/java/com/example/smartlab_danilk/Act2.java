package com.example.smartlab_danilk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Act2 extends Fragment {

    private ImageView mImageView;
    private int mImageId;

    public Act2() {
    }

    // TODO: Rename and change types and number of parameters
    public static Act2 newInstance(int imageId) {
        Act2 fragment = new Act2();
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
        View view = inflater.inflate(R.layout.zastavka2, container, false);
        mImageView = view.findViewById(R.id.imageView);
        mImageView.setImageResource(mImageId);
        return view;
    }
}