import java.util.*;

//defining user class which has specific user characteristic and tasks
public class User {
    //it provides the speed of the user in executing the task (lower is better)
    private Double skillLevel;
    //the list of tasks in plate for the user
    private List<Task> committedTasks = new ArrayList<>();

    //the resources are arranged in the sequence as FIFO
    private Queue<Resources> seqResource = new PriorityQueue<>();

    //To know how many days the user is occupied with exisitng tasks
    private Double occupiedDays = 0.0;

    public User(Double skillLevel) {
        this.skillLevel = skillLevel;
        //when new user is added this has to be communicated to scheduler
        Scheduler.addUser(this);
    }

    public Double getSkillLevel() {
        return skillLevel;
    }

    //add task to the user and the resources queue in sequence
    public List<Task> addTasks(Task task){
        committedTasks.add(task);
        seqResource.addAll(task.getTasks());
        occupiedDays = seqResource.size()*skillLevel;
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
}
