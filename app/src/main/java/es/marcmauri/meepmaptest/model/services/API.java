package es.marcmauri.meepmaptest.model.services;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static final String BASE_URL_PUBLIC_SERVICES = "https://apidev.meep.me/tripplan/api/v1/routers/";

    private static Retrofit retrofit_public_services = null;

    private final static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .build();

    public static Retrofit getResourcesServicesApi() {
        // Create an instance of retorfit_public_services to call REST services returning JSON objects
        if (retrofit_public_services == null) {
            retrofit_public_services = new Retrofit.Builder()
                    .baseUrl(BASE_URL_PUBLIC_SERVICES)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofit_public_services;
    }
}
