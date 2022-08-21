package com.example.rengoring;

public class Alcaldia {

    private int id_alc;
    private String des_alc;

    public Alcaldia(){

    }

    public Alcaldia(int id_alc, String des_alc){
        this.id_alc=id_alc;
        this.des_alc=des_alc;
    }


    public void setId_alc(int id_alc){
        this.id_alc=id_alc;
    }
    public void setDes_alc(String des_alc){
        this.des_alc=des_alc;
    }


    public String toString(){

        return des_alc;

    }


}
