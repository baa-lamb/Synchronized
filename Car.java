
/**
 * Created by Алена on 09.05.2017.
 */
public class Car {
    private String NameOfDriver = ""; // имя водителя машины

    private int road = 0;  // номер дороги, по которой едет машина
    private int distance = 0; // длина дороги

    private int speed = 0;  // скорость, с которой едет машина
    private int time = 0;   // ко скольки часам машинист подъезжает к дороге

    public Car(String name, int Road, int Distance){
        NameOfDriver = name;
        road = Road;
        distance = Distance;
    }

    public void setSpeed(int speed1){speed  = speed1;}
    public void setTime(int t1){time = t1;}
/*    public void setLenght(int speed1, int time1){
        speed = speed1; time = time1;
        lenght = speed * time;
    }*/

    public String getNameOfDriver() { return NameOfDriver; }
    public int getRoad() { return road; }
    public int getDistance() { return distance; }
    public int getSpeed() { return speed; }
    public int getTime() { return time; }

    public int calculateOfTime() { //к какому часу мошина проедет дорогу
        return time +  distance / speed;
    }

}
