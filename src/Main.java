import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Hello There!");
    /*-----------------------------
     * considering 2000 milliseconds as one day
     ------------------------------*/

        //The function should verify whether the project can be completed if work started today.

        //We need to have resources
//        Optional<Resources> resource = Resources.getResourcesByName("java");
//
//        System.out.println(resource.get().toString()+ " " + Resources.currentsize.toString());
//        Resources.utilizeResource("java");
//        Resources.utilizeResource("excel");
//
//        System.out.println(Resources.currentsize.toString());
//
//        Resources.surrenderResource("excel");
//        Resources.surrenderResource("excel");
//        Resources.surrenderResource("excel");
//        Resources.surrenderResource("excel");
//        Resources.surrenderResource("excel");
//        Resources.surrenderResource("excel");
//        Resources.surrenderResource("excel");


//        System.out.println(Resources.currentsize.toString());

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
        User user5 = new User(0.4);
//        user1.addTasks(task1);
//        user1.addTasks(task2);
//
//        User user2 = new User(0.5);
//        user1.addTasks(task1);
//        user1.addTasks(task2);

        //To add tasks to scheduler and check the status message from the scheduler
        System.out.println(Scheduler.addTaskToScheduler(task1,3.0));
        System.out.println(Scheduler.addTaskToScheduler(task2,2.5));
        //Thread.sleep(User.day);
        System.out.println(Scheduler.addTaskToScheduler(task3,4.5));
        System.out.println(Scheduler.addTaskToScheduler(task4,5.5));
        //Thread.sleep(User.day);
        System.out.println(Scheduler.addTaskToScheduler(task5,4.0));
        System.out.println(Scheduler.addTaskToScheduler(task6,3.0));

        Set<Thread> threadSet
                = Thread.getAllStackTraces().keySet();
        // iterating over the threads to get the names of
        // all the active threads
        for (Thread x : threadSet) {
            System.out.println(x.getName());
        }
        //Thread.sleep(4000);
        //Resources.occupancyOfResource.entrySet().stream().forEach(System.out::println);




        //we need to have users performing the tasks

        //we need to have tasks with proper labels assigned

        //specify the input to check the project completion can be done (number of days )
    }
}
