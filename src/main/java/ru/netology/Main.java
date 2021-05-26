package ru.netology;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Atc atc = new Atc();
        //Operator operator = new Operator(atc);


        ThreadGroup operatorGroup = new ThreadGroup("operatorGroup");

        //atc.getValues();


        Thread threadCalls = new Thread(null, atc, "АТС");
        Thread threadOperator1 = new Thread(operatorGroup, new Operator(atc), "Оператор1");
       // Thread threadOperator2 = new Thread(operatorGroup, new Operator(atc), "Оператор2");
      //  Thread threadOperator3 = new Thread(operatorGroup, operator, "Оператор3");


        threadCalls.start();
       // Thread.sleep(2000);
       // threadOperator1.start();
        //threadOperator2.start();
       // threadOperator3.start();
    }
}
