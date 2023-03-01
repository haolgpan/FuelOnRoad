package com.example.fuelonroad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapController;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;

public class MapsFragment extends Fragment {
    private MapView mapView;
    private ImageView repo;
    private ImageView social;
    private ImageView inci;
    private ImageView car;

    NavController navController;
    private MapController mapController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Configuration.getInstance().load(getContext(), androidx.preference.PreferenceManager.getDefaultSharedPreferences(getContext()));
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        car = rootView.findViewById(R.id.imageNdiceOne);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.vehiculosFragment);
            }
        });

        social = rootView.findViewById(R.id.imageSettings);
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatFragment);
            }
        });
        inci = rootView.findViewById(R.id.imageWarning);
        inci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.incidenciasFragment);
            }
        });

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
        return rootView;
    }

    @Override
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
    }
}
