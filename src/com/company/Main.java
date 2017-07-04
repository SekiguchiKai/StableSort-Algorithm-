package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 入力される数
            int n = Integer.parseInt(bufferedReader.readLine());

            String[] numbers = bufferedReader.readLine().split(" ");
            int[] numArray = new int[n];

            for (int i = 0; i < numbers.length; i++) {
                numArray[i] = Integer.parseInt(numbers[i]);
            }

            bubbleSort(numArray);


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void bubbleSort(int[] numArray) {
        // 整列済み
        for (int i = 0; i < numArray.length - 1; i++) {
            for (int j = numArray.length - 1; j > i; j--) {
                if (numArray[j] < numArray[j - 1]) {
                    int temp = numArray[j];
                    numArray[j] = numArray[j - 1];
                    numArray[j - 1] = temp;
                }
            }
        }
        for (int k = 0; k < numArray.length; k++) {
            if (k == numArray.length - 1) {
                System.out.print(numArray[k]);
            } else {
                System.out.print(numArray[k] + " ");
            }
        }

    }

    private static void selectionSort(int[] numArray) {

    }


}
