package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2QuickSort {

    public static void quickSort(ArrayList<Double> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Double> list, int low, int high) {
        double pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                double temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        double temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов списка (n >= 0): ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Ошибка: n должно быть неотрицательным.");
            return;
        }

        ArrayList<Double> list = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list.add(random.nextDouble() * 200 - 100);
        }

        System.out.println("Исходный список:");
        for (Double num : list) {
            System.out.printf("%.2f  ", num);
        }
        System.out.println();

        if (n > 0) {
            quickSort(list, 0, list.size() - 1);
        }

        System.out.println("Отсортированный список (Quick Sort):");
        for (Double num : list) {
            System.out.printf("%.2f  ", num);
        }
        System.out.println();

        scanner.close();
    }
}