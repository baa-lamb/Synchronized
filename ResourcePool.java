

import java.util.ArrayDeque;
import java.util.Random;

/**
 * Created by Alena on 16.05.2017.
 */
public class ResourcePool {
    Tourist []tour;
    Threads []threads;
    int N = 0; int M = 0;
    int freeComputers = 0;

    public ResourcePool(int n, int m) {
        N = n; M = m; freeComputers = N;
        tour = new Tourist[M];
        threads = new Threads[M];
    }

    public class Threads extends Thread {
        int NoT = 0;
        int Time = 0;

        public Threads(Tourist t) {
            NoT = t.getNumberOfTourist();
            Time = t.getTimeOfTourist();
        }

        public synchronized void GiveMeComp() throws InterruptedException {
            if(freeComputers == 0)
                System.out.println("Tourist " + NoT + " waiting for turn ");
            while (freeComputers == 0) {
                wait(1500);
            }
            freeComputers--;
            System.out.println("Tourist " + NoT + " is online ");
            threads[NoT].sleep(Time);

            int hours = 0;
            Time /= 100;
            if (Time < 60)
                System.out.println("Tourist " + NoT + " is done, having spend " + Time + " minutes online");
            else if (Time == 60)
                System.out.println("Tourist " + NoT + " is done, having spend " + 1 + " hour online");
            else if(Time > 60 && Time < 120) {
                Time -= 60;
                System.out.println("Tourist " + NoT + " is done, having spend " + 1 + " hour " + Time +" minutes online");
            }
            else
                System.out.println("Tourist " + NoT + " is done, having spend " + 2 + " hours online");
            freeComputers++;
            notify();
        }

        public void run() {
            try {
                GiveMeComp();
            } catch (InterruptedException e) {
                throw new RuntimeException("abc");
            }
        }
    }

    public void go () {
        for(int i = 0; i < M; i++) {
            tour[i] = new Tourist(i, (int)(Math.random()*10000)%10501 + 3000);
            threads[i] = new Threads(tour[i]);
            threads[i].start();
        }

    }


}
