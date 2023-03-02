package com.example.fuelonroad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Recover3Fragment#} factory method to
 * create an instance of this fragment.
 */
public class Recover3Fragment extends Fragment {


    public Recover3Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recover3, container, false);

        // Create a Handler object
        Handler handler = new Handler();

        // Define a Runnable that performs the navigation
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Navigate to the other fragment
                Navigation.findNavController(view).navigate(R.id.loggingInFragment);
            }
        };

        // Post the runnable with a 3 second delay
        handler.postDelayed(runnable, 2000);

        return view;

    }
}