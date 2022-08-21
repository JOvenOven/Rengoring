package com.example.rengoring;

public class TipoResiduo {

    private int id_res;
    private String des_res;
    private int vis_res;

    public TipoResiduo(){
    }

    public TipoResiduo(int id_res, String des_res,int vis_res){
        this.id_res=id_res;
        this.des_res=des_res;
        this.vis_res=vis_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public void setDes_res(String des_res) {
        this.des_res = des_res;
    }

    public void setVis_res(int vis_res) {
        this.vis_res = vis_res;
    }



    public String toString(){

        return des_res;

    }



}


