package com.neoteric.dec_dbconnection.singleton;

public class SingleTonTest {

    public static void main(String[] args) {
        SingleTonModel singleTonModel1=SingleTonModel.callingmethod();
       System.out.println(singleTonModel1.number);
        singleTonModel1.number=10;
        System.out.println(singleTonModel1.number);
        System.out.println(singleTonModel1.hashCode());

        SingleTonModel singleTonModel2=SingleTonModel.callingmethod();
        System.out.println(singleTonModel2.number);
        singleTonModel2.number=20;
        System.out.println(singleTonModel2.number);
        System.out.println(singleTonModel2.hashCode());
    }
}
