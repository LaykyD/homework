package ru.geekbrains.java_2.homework.lesson1;

public class Cat extends Participants implements Running, Jumping {

    public Cat (String name, int rundist, int jumpheight) {
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
        System.out.println("Cat " + name +  " ran the distance");
    }

    @Override
    public void jump() {
        System.out.println("Cat " + name + " jumped over the wall");
    }

}
