package com.example.fuelonroad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
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

    private NavController navController;

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
        return inflater.inflate(R.layout.fragment_recover3, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Initialize NavController
        navController = Navigation.findNavController(view);

        // Delay navigation by 4 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Navigate to another Fragment using NavController
                navController.navigate(R.id.loggingInFragment);
            }
        }, 3000);
    }

}