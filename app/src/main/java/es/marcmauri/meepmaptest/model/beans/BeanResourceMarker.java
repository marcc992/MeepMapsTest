package es.marcmauri.meepmaptest.model.beans;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class BeanResourceMarker implements ClusterItem {

    private final String id;
    private final String name;
    private final String description;
    private final LatLng position;
    private final int companyZoneId;

    public BeanResourceMarker(String id, double lat, double lng, String name, String description, int companyZoneId) {
        this.id = id;
        position = new LatLng(lat, lng);
        this.name = name;
        this.description = description;
        this.companyZoneId = companyZoneId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCompanyZoneId() {
        return companyZoneId;
    }

    @Override
    public LatLng getPosition() {
        return position;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getSnippet() {
        return description;
    }
}
