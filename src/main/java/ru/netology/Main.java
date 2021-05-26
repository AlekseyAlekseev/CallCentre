package ru.netology;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {

        Atc atc = new Atc();
        Operator operator = new Operator(atc);
        ThreadGroup operatorGroup = new ThreadGroup("operatorGroup");

        Thread threadCalls = new Thread(null, atc, "АТС");
      //  Thread threadOperator1 = new Thread(operatorGroup, operator, "Оператор1");
      //  Thread threadOperator2 = new Thread(operatorGroup, operator, "Оператор2");
      //  Thread threadOperator3 = new Thread(operatorGroup, operator, "Оператор3");
       // threadCalls.setDaemon(true);


        threadCalls.start();
       // threadOperator1.start();
       // threadOperator2.start();
       // threadOperator3.start();
    }
}
