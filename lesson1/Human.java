package ru.geekbrains.java_2.homework.lesson1;

public class Human extends Participants implements Running, Jumping{

    public Human (String name, int rundist, int jumpheight) {
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
        System.out.println("Human " + name + " ran the distance");
    }

    @Override
    public void jump() {
        System.out.println("Human " + name + " jumped over the wall");
    }

}
