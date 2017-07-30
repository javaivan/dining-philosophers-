package diningPhilosophers.entity;

import java.util.concurrent.atomic.AtomicBoolean;

public class Fork {
    private String name;
    private AtomicBoolean active;

    private Fork(){}

    public Fork(String name){
        this.name = name;
        this.active = new AtomicBoolean(false);
    }

    public String getName() {
        return name;
    }

    public Boolean check(){
        return active.get();
    }

    public boolean take(){
        if(!active.get()){
            active.set(true);
        }
        return active.get();
    }

    public void put(Boolean active){
        if(active){
            this.active.set(false);
        }
    }
}
