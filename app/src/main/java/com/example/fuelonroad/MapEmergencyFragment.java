package com.example.fuelonroad;

import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.ImageView;
import android.widget.TextView;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;

import dmax.dialog.SpotsDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapEmergencyFragment#} factory method to
 * create an instance of this fragment.
 */
public class MapEmergencyFragment extends Fragment {

    private MapView mapView;
    private ImageView repo;
    private ImageView social;
    private ImageView inci;
    private ImageView car;

    private NavController navController;
    private MapController mapController;

    public MapEmergencyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_emergency, container, false);
        View dialogEmer1 = inflater.inflate(R.layout.dialog_emerg1, null);
        View dialogEmer2 = inflater.inflate(R.layout.dialog_emerg2, null);
        View dialogEmer3 = inflater.inflate(R.layout.dialog_emerg3, null);
        TextView huella = dialogEmer2.findViewById(R.id.huellaDact);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(dialogEmer1);
        builder.setView(dialogEmer2);
        builder.setView(dialogEmer3);
        SpotsDialog.Builder spots = new SpotsDialog.Builder();
        SpotsDialog spotsDialog = (SpotsDialog) spots
                .setContext(getContext())
                .setTheme(R.style.Custom2)
                .setMessage("Un momento por favor...")
                .build();
        AlertDialog dialog = builder.create();
        AlertDialog dialog2 = builder.create();
        AlertDialog dialog3 = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog3.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mapView = rootView.findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);

        mapController = (MapController) mapView.getController();
        mapController.setZoom(17);
        mapController.setCenter(new GeoPoint(41.3851, 2.1734)); // Barcelona coordinates
        // Add rotation gesture overlay
        RotationGestureOverlay rotationOverlay = new RotationGestureOverlay(mapView);
        rotationOverlay.setEnabled(true);
        mapView.getOverlays().add(rotationOverlay);

        mapView.setMultiTouchControls(true);
        dialog.setView(dialogEmer1);
        dialog2.setView(dialogEmer2);
        dialog3.setView(dialogEmer3);
        dialog.show();
        // Dismiss the dialog after 4 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    dialog2.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (dialog.isShowing()) {
                                dialog.dismiss();
                                dialog2.show();
                            }
                        }
                    }, 4000);
                }
            }
        }, 4000);

        huella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2.dismiss();
                spotsDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        spotsDialog.dismiss();
                        dialog3.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (dialog3.isShowing()) {
                                    dialog3.dismiss();
                                }
                            }
                        }, 4000);
                    }
                }, 3500);
            }
        });

        return rootView;
    } @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDetach();
        navController.navigate(R.id.mapsFragment);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        car = view.findViewById(R.id.imageSettings);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.vehiculosFragment);
            }
        });

        social = view.findViewById(R.id.imageNdiceOne);
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
    }

}