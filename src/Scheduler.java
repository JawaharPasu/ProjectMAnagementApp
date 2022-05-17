import java.util.*;

//this class orchestrates the assignation of users and resources
public class Scheduler {
    //contains the task and the deadline associated with it
    private Map<Task, Integer> taskInfo = new HashMap<>();
    //using tree set to make natural ordering of the users based on skillset, least time taken will be first
    public static TreeSet<Double> userList = new TreeSet<>();

    //currently adding initialised users to scheduler to track how many users are registered at a time.
    // Can be improved, but currently keeping the users to have unique value of skillset defined in User class
    public static boolean addUser(Double user){
        return userList.add(user);
    }


}
