package es.marcmauri.meepmaptest.maps;

import java.util.List;

import es.marcmauri.meepmaptest.model.markers.ResourceMarker;

public interface MapsView {
    void showProgress();

    void hideProgress();

    void showError(String error);

    void showAllMarkers(List<ResourceMarker> markers);

    //void showAllMarkers();

    //void showBusMarkers();

    //void showTrainMarkers();

}
