import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Hello There!");
    /*-----------------------------
     * considering 2000 milliseconds as one day
     ------------------------------*/
        //To create tasks, pls include only the words defined in the Resources enum class
        Task task1 = new Task(new String[]{"excel","word"});
        //System.out.println(task1.getTasks().toString());
        Task task2 = new Task(new String[]{"java","splunk"});
        Task task3 = new Task(new String[]{"java","word","excel"});
        Task task4 = new Task(new String[]{"excel","splunk","java","word"});
        Task task5 = new Task(new String[]{"word","splunk","excel"});
        Task task6 = new Task(new String[]{"java","excel","splunk"});

        //To create users
        User user1 = new User(1.0);
        User user2 = new User(0.5);
        User user3 = new User(0.7);
        User user4 = new User(0.9);

        //To add tasks to scheduler and check the status message from the scheduler
        //if we have to simulate adding new tasks after few days of start,
        // pls use the commented sleep method (waits a day before providing new tasks)
        System.out.println(Scheduler.addTaskToScheduler(task1,3.0));
        System.out.println(Scheduler.addTaskToScheduler(task2,2.5));
        //Thread.sleep(User.day);
        System.out.println(Scheduler.addTaskToScheduler(task3,4.5));
        System.out.println(Scheduler.addTaskToScheduler(task4,5.5));
        //Thread.sleep(User.day);
        System.out.println(Scheduler.addTaskToScheduler(task5,4.0));
        System.out.println(Scheduler.addTaskToScheduler(task6,3.0));

        //This function is to check the active threads(users processing the tasks0
        Set<Thread> threadSet
                = Thread.getAllStackTraces().keySet();
        // iterating over the threads to get the names of
        // all the active threads
        for (Thread x : threadSet) {
            System.out.println(x.getName());
        }
    }
}
