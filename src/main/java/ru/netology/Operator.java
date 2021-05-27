package ru.netology;


public class Operator implements Runnable {

    Atc atc;

    private final static int SLEEP = 2000;

    public Operator(Atc atc) {
        this.atc = atc;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (atc.queue.size() != 0) {
                    System.out.println(Thread.currentThread().getName() + " принимает вызов: " + atc.queue.poll());
                    Thread.sleep(SLEEP);
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
