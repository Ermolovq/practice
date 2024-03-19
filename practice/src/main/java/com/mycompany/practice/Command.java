package com.mycompany.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Клас, що містить в собі макрокоманду.
 */
public class Command {
    public static void Return() {
        System.out.println("\nReturning...");
    }
    
    public static void doMath(ExecutorService math, Runnable min, Runnable max, Runnable avg) {
        math.execute(min);
        math.execute(max);
        math.execute(avg);
        math.shutdown();
                
        while(!math.isTerminated()) {
            try {
                Thread.sleep(100); // Чекаємо 100 мс перед перевіркою статусу завершення потоків
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

