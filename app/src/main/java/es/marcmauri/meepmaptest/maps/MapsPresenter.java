package es.marcmauri.meepmaptest.maps;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import java.util.List;

import es.marcmauri.meepmaptest.model.beans.BeanResource;
import es.marcmauri.meepmaptest.model.beans.BeanResourceMarker;

public class MapsPresenter implements MapsInteractor.OnMapListener {

    private MapsView mapsView;
    private GoogleMap mMap;
    private ClusterManager<BeanResourceMarker> mClusterManager;
    private MapsInteractor mapsInteractor;

    public MapsPresenter(MapsView mapsView, MapsInteractor mapsInteractor) {
        this.mapsView = mapsView;
        this.mapsInteractor = mapsInteractor;
    }

    public void configureGoogleMap(final GoogleMap map, final ClusterManager<BeanResourceMarker> clusterManager) {
        if (map != null) {
            mMap = map;
            mClusterManager = clusterManager;

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
            mMap.setMinZoomPreference(13);      // 10 => City view
            mMap.setBuildingsEnabled(false);    // To increase the performance

            // Point the map's listeners at the listeners implemented by the cluster
            // manager.
            mMap.setOnCameraIdleListener(mClusterManager);
            mMap.setOnMarkerClickListener(mClusterManager);
        } else {
            mapsView.showError("The Google Map object is wrong...");
        }
    }

    public void showAllMarkers() {
        if (mapsView != null) {
            mapsView.showProgress();
        }

        if (mClusterManager != null) {
            mClusterManager.clearItems();
            mClusterManager.cluster();
        }

        mapsInteractor.getAllServerData(
                "lisboa",new LatLng(38.711046,-9.160096),
                new LatLng(38.739429,-9.137115),this);
    }


    @Override
    public void onFetchingDataError(String error) {
        mapsView.showError(error);
    }

    @Override
    public void onFetchingAllResourcesSuccess(List<BeanResource> resourceList) {
        if (mapsView != null) {

            // todo: pasar este if a la vista (Activity)
            if (mMap != null) {

                // Clear items in the current Cluster before update it with new data
                mClusterManager.clearItems();

                for (BeanResource resource : resourceList) {
                    BeanResourceMarker marker = new BeanResourceMarker(
                            resource.getId(),
                            resource.getY(), resource.getX(),
                            resource.getName(),
                            "This could be any server resource...",
                            resource.getCompanyZoneId());

                    mClusterManager.addItem(marker);
                }

                // Refresh the markers on the map
                mClusterManager.cluster();
            } else {
                mapsView.showError("Google Map has not been initialized yet!");
            }

            mapsView.hideProgress();
        }
    }


    public void onDestroy() {
        mMap = null;
        mClusterManager = null;
        mapsView = null;
        mapsInteractor.onDestroy();
    }

}
