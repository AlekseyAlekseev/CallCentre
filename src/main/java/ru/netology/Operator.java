package ru.netology;

public class Operator implements Runnable {

    Atc atc;

    public Operator(Atc atc) {
        this.atc = atc;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (atc.queue.size() != 0) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " принимает вызов...");
                    atc.queue.poll();
                    Thread.sleep(2000);
                } else {
                    System.out.println("Звонков не осталось");
                    break;
                }
            }
        } catch (InterruptedException err) {
            Thread.currentThread().interrupt();
        }
    }
}
