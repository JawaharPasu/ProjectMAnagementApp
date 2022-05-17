import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.DoubleStream;

//this class orchestrates the assignation of users and resources
public class Scheduler {
    //contains the task and the deadline associated with it
    private static Map<Task, Double> taskInfo = new HashMap<>();
    //using tree set to make natural ordering of the users based on skillset, least time taken will be first
    public static TreeMap<Double, User> userList = new TreeMap();

    private static Integer taskcount = 0;

    //currently adding initialised users to scheduler to track how many users are registered at a time.
    // Can be improved, but currently keeping the users to have unique value of skillset defined in User class
    public static User addUser(User user){
        return userList.put(user.getSkillLevel(), user);
    }

    public static String addTaskToScheduler(Task task, Double days){
        taskInfo.put(task, days);
        taskcount +=1;
        //once a task is added, the scheduler should look for resource availability based on skillset and
        // check whether the resource is occupied
        Double sum =0.0;
        Double maxRemainingDays=0.0;
        Double userskillSelected = 0.0;
        for(Task taskval:taskInfo.keySet()) {
            for(Resources res:taskval.getTasks()){
                //check the no of licenses available,
                // only if resource not available get the day after which it will be available
                if(Resources.currentsize.get(res.getName())==0) {
                    sum = sum + Resources.occupancyOfResource.get(res.getName());
                }
            }
        }
        //if the resources are occupied for the entire time before deadline, then return false
        if(sum > days) return "no resources available";
        //if resources are available (assuming user has all the licesnces for the req tasks)
        if(sum<=days){
            //identify the fastest user available
            if(userList.isEmpty()) return "no users in list, pls add users";
            for(Double skill: userList.keySet()){
                User usr = userList.get(skill);
                //check how many days the user is occupied
                Double occupiedDays = usr.getOccupiedDays();
                //calculate the days req to complete the task by a user based on skillset
                // and the number of resources to work for a give task
                Double daysReqForUser = skill*(task.getTasks().size());
                //add occupied days and daysreq to compute total days by which task can be completed
                //need to add the sum (from when resource will be available)
                Double daysToComplete = sum+occupiedDays+daysReqForUser;
                //if sum of ossupied days and days req to complete the job is more then task can't be done
                //skip and continue to next user
                if(daysToComplete>days) continue;
                //what if subsequent users have more idle time, we can assign if they can complete it soon
                Double currentRemDays = days-daysToComplete;
                if(maxRemainingDays<=currentRemDays){
                    maxRemainingDays = currentRemDays;
                    userskillSelected = skill;
                }
            }
            if(userskillSelected!=0.0) {
                User usr = userList.get(userskillSelected);
                usr.addTasks(task);
                return "task " + taskcount +" is added to user having skillset : " + usr.getSkillLevel().toString();
            }
        }
        return "WARNING: All users are occupied," + " task " + taskcount + " is not possible to execute";
    }
}
