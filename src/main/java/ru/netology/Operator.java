package ru.netology;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Operator implements Runnable {

    Atc atc;
    ReentrantLock lock = new ReentrantLock();

    public Operator(Atc atc) {
        this.atc = atc;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            atc.queue.forEach(System.out::println);
            Thread.sleep(3000);
        } catch (InterruptedException err) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
