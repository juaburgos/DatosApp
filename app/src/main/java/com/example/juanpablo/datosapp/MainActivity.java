package com.example.juanpablo.datosapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.juanpablo.datosapp.API.DatosApi;
import com.example.juanpablo.datosapp.models.GuiaTuristica;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    public final static String TAG = "DATOS COLOMBIA";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private boolean aptoParaCargar;
    private LisTurismo lisTurismo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        lisTurismo = new LisTurismo(this);
        recyclerView.setAdapter(lisTurismo);


        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            ObtenerDatos();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();

        ObtenerDatos();
    }

    private void ObtenerDatos() {
        DatosApi service = retrofit.create(DatosApi.class);
        Call<ArrayList<GuiaTuristica>> autoRespuestaCall = service.obtenerListaMunicipios();

        autoRespuestaCall.enqueue(new Callback<ArrayList<GuiaTuristica>>() {
            @Override
            public void onResponse(Call<ArrayList<GuiaTuristica>> call, Response<ArrayList<GuiaTuristica>> response) {
                if(response.isSuccessful()){
                    ArrayList lista = response.body();
                    lisTurismo.agregar(lista);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GuiaTuristica>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });

    }
}
