import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      LeMans racing =  new LeMans();
      racing.startRace();
      racing.raceFinish();

        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости


    }
}



class LeMans {

    ArrayList<RaceCar> racers = new ArrayList<>();



        public void startRace() {
            String racerName;
            int racerSpeed;
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
                System.out.println("\nИ наш " + i + "-й автомобиль?:");
                racerName = scanner.nextLine();
                System.out.println("Какая же максимальная скорость у " + racerName + "? :");
                while ((racerSpeed = scanner.nextInt()) < 0 || racerSpeed >= 250) { //я оставил, что ноль ввести тоже можно в соответствии с задачей "от 0 до 250"
                    System.out.println("Неверное значение, попробуйте вновь!"); //Проверка верно введенного значения
                }
                racers.add(new RaceCar(racerName, racerSpeed)); // добавляем
            }

            System.out.println("Заезд стартует!!!");
        }


        public void raceFinish() {
            ArrayList<RaceCar> winner = new ArrayList<>(0);
            winner.add(new RaceCar("затычка",0)); // решил пойти таким путём. Если в итоге все введут 0, то в конце метода цикл выдаст, что все заглохли
            int winnerDistance = 0;
            for (RaceCar racer : racers) {
                int distance = racer.speed * 24;
                if (winnerDistance < distance){
                    winnerDistance = distance;
                    winner.set(0, racer);
                }
            }
            if (winner.get(0).name.equals("затычка")){
                System.out.println("Гонка отменена, все машины заглохли!"); // если скорость всех гонщиков 0, то победителей нет)
            }else{                                                  // коротко говоря, я сделал 2 исхода программы, надеюсь так можно, основные условия задачи я учёл.
                System.out.println("Поздравим " + winner.get(0).name + " с победой!");
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