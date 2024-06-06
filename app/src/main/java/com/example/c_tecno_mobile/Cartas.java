package com.example.c_tecno_mobile;

public class Cartas {
    String Dato1;
    String Dato2;
    String Dato3;
    String Dato4;

    public Cartas() {
    }

    public String getDato1() {
        return Dato1;
    }

    public void setDato1(String dato1) {
        Dato1 = dato1;
    }

    public String getDato2() {
        return Dato2;
    }

    public void setDato2(String dato2) {
        Dato2 = dato2;
    }

    public String getDato3() {
        return Dato3;
    }

    public void setDato3(String dato3) {
        Dato3 = dato3;
    }

    public String getDato4() {
        return Dato4;
    }

    public void setDato4(String dato4) {
        Dato4 = dato4;
    }

    public void cartas (String dato1,String dato2,String dato3,String dato4) {
        setDato1(dato1);
        setDato2(dato2);
        setDato3(dato3);
        setDato4(dato4);
        }


}
