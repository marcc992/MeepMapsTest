package es.marcmauri.meepmaptest.maps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import es.marcmauri.meepmaptest.model.beans.BeanResource;
import es.marcmauri.meepmaptest.model.beans.BeanResourceMarker;

import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BIKE;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BUS_ONE;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BUS_THREE;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BUS_TWO;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.ECOOLTRA;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.EMOV;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.TAXI;

public class MapsPresenter implements MapsInteractor.OnMapListener {

    private MapsView mapsView;
    private MapsInteractor mapsInteractor;

    public MapsPresenter(MapsView mapsView, MapsInteractor mapsInteractor) {
        this.mapsView = mapsView;
        this.mapsInteractor = mapsInteractor;
    }

    public void showAllServices() {
        if (mapsView != null) {
            mapsView.showProgress();
        }

        mapsInteractor.getAllResourcesData(
                "lisboa", new LatLng(38.711046, -9.160096),
                new LatLng(38.739429, -9.137115), this);
    }


    @Override
    public void onFetchingDataError(String error) {
        mapsView.showError(error);
    }

    @Override
    public void onFetchingAllResourcesSuccess(List<BeanResource> resourceList) {
        if (mapsView != null) {
            // First, create a list of markers with the interested data from resources
            List<BeanResourceMarker> actualMarkers = new ArrayList<>();

            for (BeanResource resource : resourceList) {
                String description;
                BitmapDescriptor bitmapDescriptor;
                switch (resource.getCompanyZoneId()) {
                    case BIKE:
                        description = "Bike service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
                        break;
                    case BUS_ONE:
                        description = "Bus A service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                        break;
                    case BUS_TWO:
                        description = "Bus B service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA);
                        break;
                    case BUS_THREE:
                        description = "Bus C service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE);
                        break;
                    case ECOOLTRA:
                        description = "Ecooltra service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
                        break;
                    case EMOV:
                        description = "Emov service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE);
                        break;
                    case TAXI:
                        description = "Cab service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);
                        break;
                    default:
                        description = "Unknown service";
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
                }

                actualMarkers.add(new BeanResourceMarker(
                        resource.getId(),
                        resource.getName(),
                        description,
                        new LatLng(resource.getY(), resource.getX()),
                        bitmapDescriptor));
            }

            // Finally, call the "painter" in the view
            mapsView.showAllMarkers(actualMarkers);

            mapsView.hideProgress();
        }
    }


    public void onDestroy() {
        mapsView = null;
        mapsInteractor.onDestroy();
    }

}
