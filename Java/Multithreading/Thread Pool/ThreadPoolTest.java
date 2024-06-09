import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

    String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
    }

}

public class ThreadPoolTest {

    public static void main(String[] args) {

        int nTasks = 10;
        int tpSize = 10;

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(tpSize, tpSize, 50000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        Task[] tasks = new Task[nTasks];
        for (int i = 0; i < nTasks; i++) {
            tasks[i] = new Task("Task " + i);
            tpe.execute(tasks[i]);
        }
        tpe.shutdown();

    }

}
