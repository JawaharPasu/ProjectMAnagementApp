import java.util.Optional;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello There!");

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

        //To create tasks
        Task task1 = new Task(new String[]{"excel","word"});
        //System.out.println(task1.getTasks().toString());
        Task task2 = new Task(new String[]{"java","splunk"});

        //To create users
        User user1 = new User(1.0);
        User user2 = new User(0.5);
//        user1.addTasks(task1);
//        user1.addTasks(task2);
//
//        User user2 = new User(0.5);
//        user1.addTasks(task1);
//        user1.addTasks(task2);

        //To add tasks to scheduler and check the status message from the scheduler
        System.out.println(Scheduler.addTaskToScheduler(task1,3.0));
        System.out.println(Scheduler.addTaskToScheduler(task2,1.0));



        //we need to have users performing the tasks

        //we need to have tasks with proper labels assigned

        //specify the input to check the project completion can be done (number of days )
    }
}
