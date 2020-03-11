package es.marcmauri.meepmaptest.maps;

import java.util.List;

import es.marcmauri.meepmaptest.model.beans.BeanResourceMarker;

public interface MapsView {
    void showProgress();

    void hideProgress();

    void showError(String error);

    void showAllMarkers(List<BeanResourceMarker> markers);

    //void showAllMarkers();

    //void showBusMarkers();

    //void showTrainMarkers();

}
