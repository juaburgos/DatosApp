package com.example.juanpablo.datosapp.API;

import com.example.juanpablo.datosapp.models.GuiaTuristica;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Juan Pablo on 12/10/2017.
 */

public interface DatosApi
{
    @GET("3v3e-azzg.json")
    Call<ArrayList<GuiaTuristica>> obtenerListaMunicipios();
}