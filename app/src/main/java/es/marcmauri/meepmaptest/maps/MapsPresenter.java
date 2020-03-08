package es.marcmauri.meepmaptest.maps;

import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsPresenter implements MapsInteractor.OnMapListener {

    private MapsView mapsView;
    private MapsInteractor mapsInteractor;

    public MapsPresenter(MapsView mapsView, MapsInteractor mapsInteractor) {
        this.mapsView = mapsView;
        this.mapsInteractor = mapsInteractor;
    }

    public void showFirstMarker(final GoogleMap map) {
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    public void getAndShowBusMarkers() {
        mapsInteractor.getBusData(this);
    }

    public void getAndShowTrainMarkers() {
        mapsInteractor.getTrainData(this);
    }


    @Override
    public void onFetchingDataError(String error) {
        mapsView.showError(error);
    }

    @Override
    public void onFetchingBusDataSuccess() {
        mapsView.showBusMarkers();
    }

    @Override
    public void onFetchingTrainDataSuccess() {
        mapsView.showTrainMarkers();
    }
}
