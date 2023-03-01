package com.example.fuelonroad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class VehiculosFragment extends Fragment {

    private ImageView map;
    private ImageView repo;
    private ImageView social;
    private ImageView inci;
    private ImageView plus;
    private TextView add;

    private NavController navController;

    public VehiculosFragment() {
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
        return inflater.inflate(R.layout.fragment_vehiculos, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        map = view.findViewById(R.id.imageMap);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.mapsFragment);
            }
        });
        //repo

        social = view.findViewById(R.id.imageSettings);
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatFragment);
            }
        });
        inci = view.findViewById(R.id.imageWarning);
        inci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.incidenciasFragment);
            }
        });
        plus = view.findViewById(R.id.imageEditpluscir);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.modificarVehiculoFragment);
            }
        });
        add = view.findViewById(R.id.txtAadirvehculo);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.modificarVehiculoFragment);
            }
        });

    }
}