package diningPhilosophers.entity;


import diningPhilosophers.Helper;

import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{
    private String name;
    private Fork forkLeft;
    private Fork forkRight;
    private Boolean forkLeftStatus;
    private Boolean forkRightStatus;
    private Long think;
    private Long eat;
    private Long unsuccessfullyEat;
    private Long sleep = 1L;

    private Philosopher(){}

    public Philosopher(String name, Fork forkLeft, Fork forkRight){
        this.name = name;
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
        think = 0L;
        eat = 0L;
        unsuccessfullyEat = 0L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fork getForkLeft() {
        return forkLeft;
    }

    public void setForkLeft(Fork forkLeft) {
        this.forkLeft = forkLeft;
    }

    public Fork getForkRight() {
        return forkRight;
    }

    public void setForkRight(Fork forkRight) {
        this.forkRight = forkRight;
    }


    private void think() throws InterruptedException {
        think++;
        sleep("think");
    }

    public void eat() throws InterruptedException {
        //if(!forkLeft.check() && !forkRight.check()) {
            if(Helper.getRandomBoolean()){
                forkLeftStatus = forkLeft.take();
                forkRightStatus = forkRight.take();
            } else {
                forkRightStatus = forkRight.take();
                forkLeftStatus = forkLeft.take();
            }
            sleep("eat work");
            if (forkLeftStatus && forkRightStatus) {
                eat++;
            } else {
                unsuccessfullyEat++;
            }
            if(Helper.getRandomBoolean()) {
                forkLeft.put(forkLeftStatus);
                forkRight.put(forkRightStatus);
            } else {
                forkRight.put(forkRightStatus);
                forkLeft.put(forkLeftStatus);
            }
            sleep("eat stop");
       // }
    }

    public void statictic(){
        System.out.println("Philosopher: " + name + " Think: " + think + " Eat: " + eat + " Unsuccessfully: " + unsuccessfullyEat);
    }

    @Override
    public void run(){
        while (true){
            try {
                if(Helper.getRandomBoolean()){
                    think();
                    eat();
                } else {
                    eat();
                    think();
                }
                sleep("run");
            } catch (InterruptedException e) {
                statictic();
                forkLeft.put(forkLeftStatus);
                forkRight.put(forkRightStatus);
                break;
            }
        }
    }

    public void sleep(String event) throws InterruptedException {
        System.out.println(name + " : " + event);
        TimeUnit.NANOSECONDS.sleep(sleep);
    }

}
