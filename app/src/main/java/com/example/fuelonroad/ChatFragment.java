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

import org.osmdroid.views.MapView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    private ImageView map;
    private ImageView repo;
    private ImageView emer;
    private ImageView inci;
    private ImageView car;
    private ImageView v1;
    private ImageView v2;
    private ImageView v3;
    private ImageView v4;
    private TextView plus;

    private NavController navController;

    public ChatFragment() {
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
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }
    @Override
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
        inci = view.findViewById(R.id.imageRemo);
        inci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.incidenciasFragment);
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
        v1 = view.findViewById(R.id.imageImage);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatTextFragment);
            }
        });
        v2 = view.findViewById(R.id.imageImageOne);
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatTextFragment);
            }
        });
        v3 = view.findViewById(R.id.imageImageThree);
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatTextFragment);
            }
        });
        v4 = view.findViewById(R.id.imageImageFour);
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatTextFragment);
            }
        });
        plus = view.findViewById(R.id.btnTwo);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatTextFragment);
            }
        });
    }
}