package ru.geekbrains.java_2.homework.lesson1;

public class Homework {

    public static void main(String[] args) {

        Participants[] participants = {
                new Human("Human_1", 140, 3),
                new Robot("Robot_1", 250, 5),
                new Cat("Cat_1", 50, 1)
        };

        Obstacles[] obstacles = {
                new Treadmill(30),
                new Treadmill(100),
                new Treadmill(200),
                new Wall(3),
                new Wall(6)
        };

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {

                if (obstacles[j] instanceof Treadmill && participants[i] instanceof Human &&  ((Human) participants[i]).getRundist() >= ((Treadmill) obstacles[j]).getDist()) {
                    ((Human) participants[i]).run();
                }
               else if (obstacles[j] instanceof  Wall && participants[i] instanceof Human && ((Human) participants[i]).getJumpheight() >= ((Wall) obstacles[j]).height) {
                    ((Human) participants[i]).jump();
                }
                else if (obstacles[j] instanceof Treadmill && participants[i] instanceof Robot && ((Robot) participants[i]).getRundist() >= ((Treadmill) obstacles[j]).getDist()) {
                    ((Robot) participants[i]).run();
                }
                else if (obstacles[j] instanceof  Wall && participants[i] instanceof Robot && ((Robot) participants[i]).getJumpheight() >= ((Wall) obstacles[j]).height) {
                    ((Robot) participants[i]).jump();
                }
                else if (obstacles[j] instanceof Treadmill && participants[i] instanceof Cat && ((Cat) participants[i]).getRundist() >= ((Treadmill) obstacles[j]).getDist()) {
                    ((Cat) participants[i]).run();
                }
                else if (obstacles[j] instanceof  Wall && participants[i] instanceof Cat && ((Cat) participants[i]).getJumpheight() >= ((Wall) obstacles[j]).height) {
                    ((Cat) participants[i]).jump();
                }
                else {
                    System.out.println(participants[i].name + " cannot pass this obstacle!");
                    break;
                }
            }
        }

    }

}
