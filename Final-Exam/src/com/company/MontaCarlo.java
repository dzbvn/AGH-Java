package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class MontaCarlo {
    static BlockingQueue<Double> results = new ArrayBlockingQueue<Double>(100);
    static class MCThread extends Thread{
        Function<Double, Double> f;
        double a;
        double b;
        int n;

        MCThread(double a, double b) {
            this.a = a;
            this.b = b;
        };

        public void run() {
            double sum = 0;
            for(int i = 1; i  <= n; i++){
                double randomNum = ThreadLocalRandom.current().nextDouble(a, b + 1);
                sum += f.apply(randomNum) * (b-a)/n;
            }
            try {
                results.put(sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    void integrateSequential(int n){
        MCThread t = new MCThread(0, Math.PI);

        t.f = (x) -> (Math.sin(x));
        //t.a = 0;
        //t.b = Math.PI;
        t.n = n;
        t.start();

    }
    static void parallelMean(int k) throws InterruptedException {
        MCThread threads[]=new MCThread[k];
        for(int i = 0; i < k; i++){
            MCThread t = new MCThread(0, 10);
            threads[i] = t;
            //t.f = (x) -> (Math.sqrt(Math.sin(x)) * Math.exp(x));
            t.f = (x) -> (Math.sin(x));

            t.n = 100;
        }

        double t1 = System.nanoTime()/1e6;
        for(MCThread t : threads){
            t.start();
        }
        double t2 = System.nanoTime()/1e6;



        for(MCThread mc:threads) {
            mc.join();
        }
        double res = 0;
        for(int i = 0; i < k; i++){
            res += results.take();
        }
        double mean = res/k;

        double t3 = System.nanoTime()/1e6;
        double t2t1 = t2 - t1;
        double t3t1 = t3 - t1;
        System.out.println("Res: " + mean + "" + "\nTime t2-t1: " + t2t1 + "\nTime t3-t1: " + t3t1);


    }

    public static void main(String[] args) throws Exception {
        parallelMean(100);


    }
}
