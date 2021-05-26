package ru.netology;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {

        // Пауза между поступлениями звонков
        final int SLEEP_TIME = 1000;
        // Количество вызовов за раз
        final int CALLS_PER_SECOND = 60;

        // Генерация случайных телефонных номеров
        Random random = new Random();
        long numbers = random.nextInt(1_000_000_000) + (random.nextInt(90) + 10) * 1_000_000_000L;


        PriorityBlockingQueue<Long> queue = new PriorityBlockingQueue<>();

        Runnable r = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    for (int i = 0; i < CALLS_PER_SECOND; i++) {
                        queue.add(numbers);

                    }
                    System.out.println("От " + Thread.currentThread().getName() + " поступило множество звонков");
                    Thread.sleep(SLEEP_TIME);
                }
            } catch (InterruptedException err) {
                Thread.currentThread().interrupt();
            }
        };

        Thread threadCalls = new Thread(null, r, "АТС");

        threadCalls.start();

    }
}
