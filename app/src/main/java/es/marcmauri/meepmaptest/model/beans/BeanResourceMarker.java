package es.marcmauri.meepmaptest.model.beans;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class BeanResourceMarker implements ClusterItem {

    private final String id;
    private final String title;
    private final String snippet;
    private final LatLng position;
    private BitmapDescriptor markerDescriptor;

    public BeanResourceMarker(String id, String title, String snippet, LatLng position, BitmapDescriptor markerDescriptor) {
        this.id = id;
        this.title = title;
        this.snippet = snippet;
        this.position = position;
        this.markerDescriptor = markerDescriptor;
    }

    public String getId() {
        return id;
    }

    public BitmapDescriptor getMarkerDescriptor() {
        return markerDescriptor;
    }

    public void setMarkerDescriptor(BitmapDescriptor markerDescriptor) {
        this.markerDescriptor = markerDescriptor;
    }

    @Override
    public LatLng getPosition() {
        return position;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSnippet() {
        return snippet;
    }
}
