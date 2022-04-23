package ru.geekbrains.java_2.homework.lesson1;

public class Robot extends Participants implements Running, Jumping {

    public Robot (String name, int rundist, int jumpheight) {
        this.name = name;
        this.rundist = rundist;
        this.jumpheight = jumpheight;
    }

    public int getRundist() {
        return rundist;
    }

    public int getJumpheight() {
        return jumpheight;
    }

    @Override
    public void run() {
        System.out.println("Robot " + name +  " ran the distance");
    }

    @Override
    public void jump() {
        System.out.println("Robot " + name + " jumped over the wall");
    }

}
