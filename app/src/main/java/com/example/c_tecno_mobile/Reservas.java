package com.example.c_tecno_mobile;

public class Reservas {
    String Computador;
    String Salon;
    String accesorio;


    public Reservas() {
        Computador = "";
        Salon = "";
        this.accesorio = "";
    }

    public String getComputador() {
        return Computador;
    }

    public void setComputador(String computador) {
        Computador = computador;
    }

    public String getSalon() {
        return Salon;
    }

    public void setSalon(String salon) {
        Salon = salon;
    }

    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }
}
