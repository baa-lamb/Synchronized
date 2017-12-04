
import java.util.Scanner;

/**
 * Created by Алена on 09.05.2017.
 */
public class Main {
    public static void main(String []args){
        /*Car One = new Car("Hank", 1, 50);
        One.setSpeed(10); One.setTime(3);
        int end1 = One.calculateOfTime();
        int start1 = One.getTime();

        Car Two = new Car("Walt", 1, 50);
        Two.setSpeed(10); Two.setTime(2);
        int end2 = Two.calculateOfTime();
        int start2 = One.getTime();

        if(One.getRoad() != Two.getRoad()) {
            System.out.println("Succses");
            return;
        }
        if(start1 >= start2){
            if(end2 >= start1){
                waitingCar(One, Two);
                waitingCar(Two, One);
            }
            else
                System.out.println("Success");
        }
        else{
            if(end1 >= start2){
                waitingCar(Two, One);
                waitingCar(One, Two);
            }
            else
                System.out.println("Success");
        }*/

        System.out.println("Enter thr number of computers: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Enter the number of tourists: ");
        s = new Scanner(System.in);
        int m = s.nextInt();
        ResourcePool r = new ResourcePool(n,m);
        r.go();

    }

    static void waitingCar(Car One, Car Two) {
        new Thread() {
            @Override
            public void run () {
                try {
                    synchronized (One) {
                        Thread.sleep(50);
                        synchronized (Two) {
                            System.out.println(One.getNameOfDriver() + "waits until" +  Two.getNameOfDriver() + "passes");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
