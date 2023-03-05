package com.example.fuelonroad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class VehiculosFragment extends Fragment{

    private ImageView map;
    private ImageView repo;
    private ImageView social;
    private ImageView emer;
    private ImageView plus;
    private TextView add;
    private ImageView v1;
    private ImageView v2;
    private ImageView v3;
    private ImageView v4;
    private ImageView v5;
    private ImageView v6;
    private ImageView help;
    private RecyclerView mRecyclerView;
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
        View view = inflater.inflate(R.layout.fragment_vehiculos, container, false);

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
        ImageAdapter adapter = new ImageAdapter(images, NavHostFragment.findNavController(this));
        mRecyclerView.setAdapter(adapter);
        // Attach ItemTouchHelper to RecyclerView
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(adapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity activity = (MainActivity) getActivity();
        activity.unlockDrawer();
        navController = Navigation.findNavController(view);
        map = view.findViewById(R.id.imageMap);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_mapsFragment);
            }
        });
        repo = view.findViewById(R.id.imageGasdarkblueOne);
        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_mapRepoFragment);
            }
        });

        social = view.findViewById(R.id.imageSettings);
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_chatFragment);
            }
        });
        emer = view.findViewById(R.id.imageWarning);
        emer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_vehiculosFragment_to_mapEmergencyFragment2);
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

        help = view.findViewById(R.id.imageTransparentico);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Autor: Hao Pan\nPrototipo de una APP: \nhttps://github.com/haolgpan")
                        .setTitle("Acerca de");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity activity = (MainActivity) getActivity();
        activity.lockDrawer();
    }
}