package com.neoteric.dec_dbconnection.singleton;

public class SingleTonModel {

    private static final SingleTonModel sigletonmodel=new SingleTonModel();
    public int number=5;
    private SingleTonModel(){

    }
    public static SingleTonModel callingmethod(){
        return sigletonmodel;
    }
}
