package ru.netology;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Atc implements Runnable {

    ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue<>();

    // Пауза между поступлениями звонков
    private static final int SLEEP_TIME = 1;
    // Количество вызовов за раз
    private static final int CALLS_PER_SECOND = 60;
    // Количество итераций за сутки
    private static final int ITERATION = 1;


    // Генерация случайных телефонных номеров
    Random random = new Random();


    @Override
    public void run() {
        try {
            int count = 0;
            while (true) {
                if (count < ITERATION) {
                    for (int i = 0; i < CALLS_PER_SECOND; i++) {
                        long numbers = (random.nextInt(1552634) + 143) + 89220000000L;
                        queue.add(numbers);
                        count++;
                        Thread.sleep(SLEEP_TIME);
                    }
                }
            }
        } catch (InterruptedException err) {
            Thread.currentThread().interrupt();
        }
    }
}
