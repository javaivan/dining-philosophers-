package diningPhilosophers;

import diningPhilosophers.entity.Fork;
import diningPhilosophers.entity.Philosopher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int count = 100;
        List<Fork> forks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Fork fork = new Fork("Fork: " + i);
            forks.add(fork);
        }

        for (int i = 0; i < count; i++) {
            int leftPosition = i;
            int rightPosition = leftPosition + 1;
            if (count == rightPosition) {
                rightPosition = 0;
            }
            Philosopher philosopher = new Philosopher("Philosopher: "  + i, forks.get(leftPosition), forks.get(rightPosition));
            philosophers.add(philosopher);
        }

        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(philosophers.get(i));
            threads.add(thread);
        }

        for (int i = 0; i < count; i++) {
            threads.get(i).start();
        }
        TimeUnit.SECONDS.sleep(10);

        for (int i = 0; i < count; i++) {
            threads.get(i).stop();
        }

        for (int i = 0; i < count; i++) {
            philosophers.get(i).statictic();
        }
    }
}
