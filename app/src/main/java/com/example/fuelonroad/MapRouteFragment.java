package com.example.fuelonroad;

import android.graphics.Color;
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

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapRouteFragment#} factory method to
 * create an instance of this fragment.
 */
public class MapRouteFragment extends Fragment {
    private MapView mapView;
    private ImageView repo;
    private ImageView social;
    private ImageView car;
    private ImageView emer;
    private Polyline route = new Polyline();

    private NavController navController;
    private MapController mapController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Configuration.getInstance().load(getContext(), androidx.preference.PreferenceManager.getDefaultSharedPreferences(getContext()));
        View rootView = inflater.inflate(R.layout.fragment_map_route, container, false);

        mapView = rootView.findViewById(R.id.mapView2);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        // create route
        List<GeoPoint> points = new ArrayList<>();
        points.add(new GeoPoint(41.388774, 2.182847)); // Barcelona
        points.add(new GeoPoint(41.404315, 2.162707)); // Tibidabo
        route = new Polyline(mapView);
        route.setPoints(points);

        // add route to map
        mapView.getOverlayManager().add(route);
        route.setPoints(points);
        route.setColor(Color.RED); // set line color
        route.setWidth(20f); // set line width

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

        social = view.findViewById(R.id.imageNdiceOne);
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.chatFragment);
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
    }
}