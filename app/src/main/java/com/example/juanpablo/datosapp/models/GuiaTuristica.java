package com.example.juanpablo.datosapp.models;

/**
 * Created by Juan Pablo on 12/10/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuiaTuristica {

    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("entidad_o_cargo")
    @Expose
    private String entidadOCargo;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("telefono_de_contacto")
    @Expose
    private String telefonoDeContacto;
    @SerializedName("tipo_de_establecimiento")
    @Expose
    private String tipoDeEstablecimiento;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEntidadOCargo() {
        return entidadOCargo;
    }

    public void setEntidadOCargo(String entidadOCargo) {
        this.entidadOCargo = entidadOCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoDeContacto() {
        return telefonoDeContacto;
    }

    public void setTelefonoDeContacto(String telefonoDeContacto) {
        this.telefonoDeContacto = telefonoDeContacto;
    }

    public String getTipoDeEstablecimiento() {
        return tipoDeEstablecimiento;
    }

    public void setTipoDeEstablecimiento(String tipoDeEstablecimiento) {
        this.tipoDeEstablecimiento = tipoDeEstablecimiento;
    }

}