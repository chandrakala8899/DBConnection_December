package com.neoteric.dec_dbconnection.timecalculation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TimeCalculationBetweenArrayListAndSet {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(101);
        list1.add(102);
        list1.add(103);
        list1.add(104);
        list1.add(105);
        list1.add(106);
        list1.add(107);
        list1.add(108);
        list1.add(109);
        list1.add(110);

        list2.add(103);
        list2.add(104);
        list2.add(106);
        list2.add(107);
        list1.add(111);
        list1.add(112);
        list1.add(113);
        list1.add(109);
        list1.add(115);


        long startTimeArrayList = System.nanoTime();

        ArrayList<Integer> commonIdsArrayList = new ArrayList<>();
        for (Integer id1 : list1) {
            for (Integer id2 : list2) {
                if (id1.equals(id2)) {
                    commonIdsArrayList.add(id1);
                    break;
                }
            }
        }

        long endTimeArrayList = System.nanoTime();
        long timeTakenArrayList = endTimeArrayList - startTimeArrayList;

        long startTimeHashSet = System.nanoTime();

        HashSet<Integer> set1 = new HashSet<>(list1);
        HashSet<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);

        long endTimeHashSet = System.nanoTime();
        long timeTakenHashSet = endTimeHashSet - startTimeHashSet;

        System.out.println("Common Employee IDs using ArrayList: " + commonIdsArrayList);
        System.out.println("Time taken using ArrayList (Iterative): " + timeTakenArrayList + " nanoseconds");

        System.out.println("Common Employee IDs using HashSet: " + set1);
        System.out.println("Time taken using HashSet (Set-based): " + timeTakenHashSet + " nanoseconds");
    }
    }

