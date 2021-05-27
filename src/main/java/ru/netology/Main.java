package ru.netology;

public class Main {
    public static void main(String[] args) {

        Atc atc = new Atc();

        Thread threadCalls = new Thread(null, atc, "АТС");

        threadCalls.setDaemon(true);
        threadCalls.start();
        getThreadSleep();

        new Thread(null, new Operator(atc), "Оператор1").start();
        new Thread(null, new Operator(atc), "Оператор2").start();
        new Thread(null, new Operator(atc), "Оператор3").start();
        new Thread(null, new Operator(atc), "Оператор4").start();
        new Thread(null, new Operator(atc), "Оператор5").start();

    }

    /**
     * Простой таймаут потока для генерации звонков
     */
    private static void getThreadSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
