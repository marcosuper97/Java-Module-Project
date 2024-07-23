import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      LeMans racing =  new LeMans();
      racing.startRace();
      racing.raceFinish();
    }
}

class LeMans {
    String racerName;
    int racerSpeed = -1;
    ArrayList<RaceCar> racers = new ArrayList<>();

        public void startRace() {
            System.out.println("Уважаемые посетители легендарного\n" +
                    "LeMans24 х3 chempions - приветствует Вас!!!");
            System.out.println ("╲╲╲╲┗━━┳┳━━┛╱╱╱╱\n" +
                                "╲╲╭━━╮╭┻┻╮╭━━╮╱╱\n" +
                                "╲╲┃┊┊┣┫╭╮┣┫┊┊┃╱╱\n" +
                                "╲╲╰━╭┻╯┃┃╰┻╮━╯╱╱\n" +
                                "╲╭━╮╭━╲╭╮╱━╮╭━╮╱\n" +
                                "╲┃┊┣┻━━╰╯━━┻┫┊┃╱\n" +
                                "┈╰━┗━━━━━━━━┛━╯╱\n");  // Красивое приветствие никогда не помешает :)

            System.out.println("На нашем чемпионате есть важное правило!\n" +
                    "Максимально разрешенная скорость до 250 км/ч!");

            for (int i = 1 ; i<=3 ; i++) { // 3 гонщика
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nИ наш " + i + "-й автомобиль?");
                do {
                        System.out.println("Введите марку автомобиля:");
                        racerName = scanner.nextLine();
                    }while (racerName.trim().isEmpty());

                do {
                    try {
                        System.out.println("Скорость '" + racerName + "' от 0 до 250:");
                        racerSpeed = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Неверное значение, попробуйте снова!");
                        scanner.next();
                    }
                }while(racerSpeed < 0 || racerSpeed > 250);
                racers.add(new RaceCar(racerName,racerSpeed));
            }
            System.out.println("Заезд стартует!!!");
        }

        public void raceFinish() {
            int winnerDistance = 0;
            String winner = " ";
            for (RaceCar racer : racers) {
                int distance = racer.speed * 24;
                if (winnerDistance < distance){
                    winnerDistance = distance;
                    winner = racer.name;
                }
            }
            if (winner.trim().isEmpty()){
                System.out.println("Гонка отменена, все машины заглохли!"); // если скорость всех гонщиков 0, то победителей нет)
            }else{                                                  // коротко говоря, я сделал 2 исхода программы, надеюсь так можно, основные условия задачи я учёл.
                System.out.println("Поздравим '" + winner + "' с победой!");
            }
        }
    }

    class RaceCar {
        String name;
        int speed;

        RaceCar(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }
    }
