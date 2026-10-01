package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Task1Array {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива (n >= 0): ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Ошибка: n должно быть неотрицательным.");
            return;
        }

        // Создание массива и заполнение случайными числами типа int
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }

        System.out.println("Массив: " + Arrays.toString(array));

        if (n == 0) {
            System.out.println("Массив пуст, поиск невозможен.");
            return;
        }

        // Поиск минимального значения по модулю
        int minAbs = Math.abs(array[0]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(array[i]) < minAbs) {
                minAbs = Math.abs(array[i]);
            }
        }

        System.out.println("Минимальное значение по модулю: " + minAbs);
    }
}