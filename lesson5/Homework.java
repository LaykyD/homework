package ru.geekbrains.java_2.homework.lesson5;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        timeFillArr_1();
        timeFillArr_2();
    }

    public static void timeFillArr_1 () {
        final int size = 10000000;

        float [] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long starttime = System.currentTimeMillis();
        System.out.println("Start time: " + starttime);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }

        long finaltime = System.currentTimeMillis();
        System.out.println("Final time: " + finaltime);
        System.out.println("Working time: " + (finaltime - starttime));
        System.out.println("");
    }

    public static void timeFillArr_2 () {
        final int size = 10000000;

        float [] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long starttime = System.currentTimeMillis();
        System.out.println("Start time: " + starttime);

        Thread thread_1 = new Thread(() -> {
            float [] arr_1 = new float[size/2];
            System.arraycopy(arr,0, arr_1, 0, size/2);
            for (int i = 0; i < arr_1.length; i++) {
                arr_1[i] = (float)(arr_1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr_1, 0, arr, 0, size/2);
        });

        Thread thread_2 = new Thread(() -> {
            float [] arr_2 = new float[size/2];
            System.arraycopy(arr,size/2, arr_2, 0, size/2);
            for (int i = 0; i < arr_2.length; i++) {
                arr_2[i] = (float)(arr_2[i] * Math.sin(0.2f + (i+size/2) / 5) * Math.cos(0.2f + (i+size/2) / 5) *
                        Math.cos(0.4f + (i+size/2) / 2));
            }
            System.arraycopy(arr_2, 0, arr, size/2, size/2);
        });

        thread_1.start();
        thread_2.start();

        try {
            thread_1.join();
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finaltime = System.currentTimeMillis();
        System.out.println("Final time: " + finaltime);
        System.out.println("Working time: " + (finaltime - starttime));
    }

}
