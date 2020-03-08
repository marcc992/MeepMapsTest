package es.marcmauri.meepmaptest.maps;

public class MapsInteractor {

    interface OnMapListener {
        void onFetchingDataError(String error);
        void onFetchingBusDataSuccess();
        void onFetchingTrainDataSuccess();
    }

    public void getBusData(final OnMapListener listener) {
        listener.onFetchingDataError("No hay datos de bus disponibles");
    }

    public void getTrainData(final OnMapListener listener) {
        listener.onFetchingDataError("No hay datos de tren disponibles");
    }
}
