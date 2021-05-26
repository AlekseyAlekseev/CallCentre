package ru.netology;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Atc implements Runnable {

    ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue<>();

    // Пауза между поступлениями звонков
    private final int SLEEP_TIME = 1;
    // Количество вызовов за раз
    private final int CALLS_PER_SECOND = 5;
    // Количество итераций за сутки
    private final int ITERATION = 3;


    // Генерация случайных телефонных номеров
    Random random = new Random();


    @Override
    public void run() {
        try {
            int count = 0;
            while (true) {
                if (count == ITERATION) {
                    break;
                }
                if (count < ITERATION) {
                    for (int i = 0; i < CALLS_PER_SECOND; i++) {
                        long numbers = random.nextInt(1_000_000_000) + (random.nextInt(90) + 10) * 1_000_000_000L;
                        queue.add(numbers);
                        System.out.println(queue.toString());
                        count++;
                        Thread.sleep(SLEEP_TIME);
                    }
                }
            }
            //System.out.println("От " + Thread.currentThread().getName() + " поступило множество звонков");
        } catch (InterruptedException err) {
            Thread.currentThread().interrupt();
        }
    }
}
