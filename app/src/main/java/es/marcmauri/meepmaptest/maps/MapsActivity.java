package es.marcmauri.meepmaptest.maps;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import java.util.List;

import es.marcmauri.meepmaptest.R;
import es.marcmauri.meepmaptest.databinding.ActivityMapsBinding;
import es.marcmauri.meepmaptest.model.beans.BeanResourceMarker;

public class MapsActivity extends FragmentActivity implements MapsView, OnMapReadyCallback {

    private ActivityMapsBinding binding;
    private MapsPresenter presenter;
    private GoogleMap mMap;
    private ClusterManager<BeanResourceMarker> mClusterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        } else {
            Toast.makeText(this, "Error with mapFragment", Toast.LENGTH_SHORT).show();
        }

        presenter = new MapsPresenter(this, new MapsInteractor());
        binding.fabRefreshData.setOnClickListener(v -> presenter.showAllServices());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // When the map is ready, we configure the map and its properties like the camera and the cluster manager
        configureGoogleMap(googleMap);
        // Then we try to show all services fetched from server
        presenter.showAllServices();
    }

    @Override
    public void showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAllMarkers(List<BeanResourceMarker> markers) {
        if (mMap != null) {
            // Clear items in the current Cluster before update it with new data
            mClusterManager.clearItems();
            // Add the new items to the Cluster Manager
            mClusterManager.addItems(markers);
            // Refresh the markers on the map
            mClusterManager.cluster();
        } else {
            showError("Google Map has not been initialized yet!");
        }
    }

    private void configureGoogleMap(GoogleMap googleMap) {
        mMap = googleMap;

        // Initialize the manager with the context and the map.
        mClusterManager = new ClusterManager<>(this, mMap);

        // The city of this test is Lisbon
        LatLng lisbon = new LatLng(	38.736946, 	-9.142685);

        // Configure the GoogleMap Camera
        CameraPosition camera = new CameraPosition.Builder()
                .target(lisbon)
                .zoom(13)           // limit -> 21
                .bearing(0)         // 0 - 360 degrees
                .tilt(45)           // 0 - 90 degree
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lisbon));
        mMap.setMinZoomPreference(13);      // 10 => City view, 15 => Street view
        mMap.setBuildingsEnabled(false);    // To increase the performance

        // Point the map's listeners at the listeners implemented by the cluster manager.
        mMap.setOnCameraIdleListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
    }

}
