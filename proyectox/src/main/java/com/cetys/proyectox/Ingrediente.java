package com.cetys.proyectox;

public class Ingrediente {

    private String Nombre, Unidad_medida, Cantidad;
    private double cantidad;

    public Ingrediente(String nombre) {
        this.Nombre = nombre;
    }

    public void set_cantidad(String cantidad) {
        this.Cantidad = cantidad;
    }

    public String get_cantidad() {
        return Cantidad;
    }

    public void set_Unidad(String Unidad) {
        this.Unidad_medida = Unidad;
    }

    public String get_unidad() {
        return Unidad_medida;
    }

    public String get_Nombre() {
        return Nombre;
    }

    public void set_Nombre(String nombre) {
        this.Nombre = nombre;
    }

}
