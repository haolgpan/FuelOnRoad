package com.example.fuelonroad;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
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
    private TextView v1;
    private TextView v2;
    private TextView v3;
    private TextView v4;
    private TextView v5;
    private TextView v6;

    private NavController navController;
    MainActivity activity = (MainActivity) getActivity();

    public VehiculosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button even
                activity.lockDrawer();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
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
        activity.unlockDrawer();
        navController = Navigation.findNavController(view);
        v1 = view.findViewById(R.id.txtMat);
        v2 = view.findViewById(R.id.txtMatri);
        v3 = view.findViewById(R.id.txtMattric);
        v4 = view.findViewById(R.id.txtMatrcula);
        v5 = view.findViewById(R.id.txtMatrculaa);
        v6 = view.findViewById(R.id.txtMatrculaB);
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
                navController.navigate(R.id.action_vehiculosFragment_to_addVehiculoFragment);
            }
        });
        add = view.findViewById(R.id.txtAadirvehculo);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_addVehiculoFragment);
            }
        });
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_vehiculosModFragment);
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_vehiculosModFragment);
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_vehiculosModFragment);
            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_vehiculosModFragment);
            }
        });
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_vehiculosModFragment);
            }
        });
        v6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_vehiculosModFragment);
            }
        });


    }
}