package es.marcmauri.meepmaptest.maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.maps.android.clustering.ClusterManager;

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
        binding.fabShowAll.setOnClickListener(v -> presenter.showAllMarkers());
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Initialize the manager with the context and the map.
        mClusterManager = new ClusterManager<>(this, mMap);
        presenter.configureGoogleMap(mMap, mClusterManager);
    }

    @Override
    public void showAllMarkers() {
        presenter.showAllMarkers();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showBusMarkers() {
        //presenter.getAndShowBusMarkers();
    }

    @Override
    public void showTrainMarkers() {
        //presenter.getAndShowTrainMarkers();
    }

    @Override
    public void onDetachedFromWindow() {
        presenter.onDestroy();
        super.onDetachedFromWindow();
    }
}
