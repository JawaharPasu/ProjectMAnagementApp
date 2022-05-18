import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

//defining user class which has specific user characteristic and tasks
public class User extends TimerTask {
    //it provides the speed of the user in executing the task (lower is better)
    private Double skillLevel;
    //the list of tasks in plate for the user
    private List<Task> committedTasks = new ArrayList<>();

    //the resources are arranged in the sequence as FIFO
    private Queue<Resources> seqResource = new PriorityQueue<>();

    //has a boolean variable that shows that if user is awaiting license for a resource
    private boolean waitingForResource = false;
    //variable to show whether a resource is surrendered or not
    private Resources surrenderedAndNext = null;

    //To know how many days the user is occupied with exisitng tasks
    private Double occupiedDays = 0.0;

    private Integer count = 0;

    //Timer timer;

    ScheduledExecutorService ses;
    ScheduledFuture<?> scheduledFuture;

    //the timer is the time each task will be performed
    // (the last method parameter below --> period) is fastness of task completion
    /*-----------------------------
     * considering 2000 milliseconds as one day
     ------------------------------*/
    public static long day = 2000;
    long speedOfExecution;

    public User(Double skillLevel) {
        this.skillLevel = skillLevel;
        //when new user is added this has to be communicated to scheduler
        Scheduler.addUser(this);
        this.speedOfExecution = (long)Math.floor(day*skillLevel);
    }

    Runnable tasks = () -> {
        run();
    };

    public Double getSkillLevel() {
        return skillLevel;
    }

    //add task to the user and the resources queue in sequence
    public List<Task> addTasks(Task task){
        committedTasks.add(task);
        seqResource.addAll(task.getTasks());
        occupiedDays = seqResource.size()*skillLevel;
        //acquire the license when it is the first task to be executed
        if(committedTasks.size()==1) {
            acquireLicense();
            //starting the timer to perform the tasks
            System.out.println("user of skill : " + this.skillLevel + " initalising timer");
            //timer = new Timer();
            //timer.scheduleAtFixedRate(this,speedOfExecution,speedOfExecution);
            ses =  Executors.newScheduledThreadPool(1);
            scheduledFuture = ses.scheduleAtFixedRate(tasks,speedOfExecution,speedOfExecution, TimeUnit.MILLISECONDS);
        }
        return committedTasks;
    }

    public List<Task> getCommittedTasks() {
        return committedTasks;
    }

    public Queue<Resources> getSeqResource() {
        return seqResource;
    }

    public Double getOccupiedDays() {
        return occupiedDays;
    }

    private void acquireLicense(){
        String res = seqResource.peek().getName();
        boolean value = Resources.utilizeResource(res, this.skillLevel);
        waitingForResource = !value ? true : false;
        System.out.println("user of: "+ this.skillLevel + " acquired the license of : " + res);
    }

    private void surrenderLicense(){
        String res = seqResource.poll().getName();
        boolean value = Resources.surrenderResource(res, this.skillLevel);
        surrenderedAndNext = seqResource.peek();
        System.out.println("user of: "+ this.skillLevel + " surrendered the license of : " + res);
    }

    private Integer counterMethod(){
        return count+=1;
    }

    private void stopTimer(){
        System.out.println("user of skill : " + this.skillLevel + " cancelling timer");
        //timer.cancel();
        scheduledFuture.cancel(true);
        ses.shutdown();
    }

    public void run(){
        //System.out.println("running repeat function of : "+ this.skillLevel + " count = " + counterMethod());
        //if there is no items in the queue stop the timer
        if(this.seqResource.size()==0) {
            stopTimer();
            this.committedTasks = new ArrayList<>();
        }
        //if user is not waiting for resource, surrender the license of the task done
        // and acquire the license of next task
        else if(!waitingForResource){
            surrenderLicense();
            //the size may become zero of the queue, s
            // o check if element available and continue to acquire the license
            if(this.seqResource.size()>0) acquireLicense();
        }else if(waitingForResource){
            //if waiting for resources, get the available license of that resource, if available, acquire license
            String res = seqResource.peek().getName();
            if(Resources.currentsize.get(res)>=1){
                acquireLicense();
                //setting false as we have acquired the license
                waitingForResource = false;
            }
        }
    }
}
