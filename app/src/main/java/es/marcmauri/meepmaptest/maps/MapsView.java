package es.marcmauri.meepmaptest.maps;

public interface MapsView {
    void showError(String error);

    void showAllMarkers();

    void showBusMarkers();

    void showTrainMarkers();

}
