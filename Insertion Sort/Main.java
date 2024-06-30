package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; ++i) {
            arr[i] = scanner.nextInt();
        }
        for (int i = n-2; i >= 0; --i) {
            int key = arr[i];
            int j = i + 1;
            while (j <=n-1  && arr[j] < key) {
                arr[j - 1] = arr[j];
                j = j + 1;
            }
            arr[j-1] = key;
            for (int k = 0; k < n; ++k)
                System.out.print(arr[k] + " ");

            System.out.println();
        }
    }
}
