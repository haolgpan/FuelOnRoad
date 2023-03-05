package com.example.fuelonroad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestPurposeFragment#} factory method to
 * create an instance of this fragment.
 */
public class TestPurposeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    public TestPurposeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_purpose, container, false);

        // Create RecyclerView
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create ImageAdapter and set to RecyclerView
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.car1);
        images.add(R.drawable.car2);
        images.add(R.drawable.car3);
        images.add(R.drawable.car4);
        images.add(R.drawable.car5);
        images.add(R.drawable.car6);
//        ImageAdapter adapter = new ImageAdapter(images);
//        mRecyclerView.setAdapter(adapter);

        return view;
    }
}