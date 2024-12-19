package com.neoteric.dec_dbconnection.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraySetComparing {


        public static void main(String[] args) {

            List<Integer> array = new ArrayList<>();
            for (int i = 1; i <= 500; i++) {
                array.add(i);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 300; i <= 500; i++) {
                set.add(i);
            }
            long startTime=System.currentTimeMillis();

            List<Integer> commonNumbers = new ArrayList<>();
            for (int num : array) {
                if (set.contains(num)) {
                    commonNumbers.add(num);
                }
            }
long endTime=System.currentTimeMillis();
            long totalTime=endTime-startTime;

            System.out.println("Common numbers between the array and the set:");
            System.out.println(commonNumbers);
            System.out.println("total time taken"+totalTime+"mills");
        }
    }


