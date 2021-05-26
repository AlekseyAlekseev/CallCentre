package ru.netology;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {


        final int SLEEP_TIME = 2000;
        Random random = new Random();
        long numbers = random.nextInt(1_000_000_000) + (random.nextInt(90) + 10) * 1_000_000_000L;
        PriorityBlockingQueue<Long> queue = new PriorityBlockingQueue<>();

        Runnable r = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(SLEEP_TIME);
                    queue.add(numbers);
                    System.out.println("От " + Thread.currentThread().getName() + " поступил звонок ");
                }
            } catch (InterruptedException err) {
                Thread.currentThread().interrupt();
            }
        };

        Thread threadCalls = new Thread(null, r, "АТС");

        threadCalls.start();

    }
}
