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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncidenciaChatFragment#} factory method to
 * create an instance of this fragment.
 */
public class IncidenciaChatFragment extends Fragment {
    private ImageView map;
    private ImageView repo;
    private ImageView emer;
    private ImageView car;
    private ImageView social;
    private NavController navController;
    public IncidenciaChatFragment() {
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
        return inflater.inflate(R.layout.fragment_incidencia_chat, container, false);
    }@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity activity = (MainActivity) getActivity();
        activity.unlockDrawer();
        navController = Navigation.findNavController(view);

        car = view.findViewById(R.id.imageSettings);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.vehiculosFragment);
            }
        });

        map = view.findViewById(R.id.imageMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.mapsFragment);
            }
        });
        repo = view.findViewById(R.id.imageGasdarkblueOne);
        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.mapRepoFragment);
            }
        });
        emer = view.findViewById(R.id.imageWarning);
        emer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.mapEmergencyFragment2);
            }
        });
        social = view.findViewById(R.id.imageNdiceOne);
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatFragment);
            }
        });
    }
}