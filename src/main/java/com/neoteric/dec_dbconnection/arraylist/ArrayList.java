package com.neoteric.dec_dbconnection.arraylist;

import java.util.List;
import java.util.Random;

public class ArrayList {
    public static void main(String[] args) {
        List<Integer> array1 = new java.util.ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            array1.add(i);
        }


        List<Integer> array2 = new java.util.ArrayList<>();
        for (int i = 300; i <= 500; i++) {
            array2.add(i);
        }

     long  startTime=System.currentTimeMillis();
        List<Integer> commonNumbers =new java.util.ArrayList<>(array1);
       commonNumbers.retainAll(array2);
//        for (){
//            for (){
//                if (){
//
//                }
//            }
//        }

        long endTime=System.currentTimeMillis();
        long totalTime=endTime-startTime;
        System.out.println("Common numbers between the two arrays:");
        System.out.println(commonNumbers);

        System.out.println("total time taken"+totalTime+"mills");


            }
        }
