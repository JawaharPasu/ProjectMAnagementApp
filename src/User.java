import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//defining user class which has specific user characteristic and tasks
public class User {
    //it provides the speed of the user in executing the task (lower is better)
    private double skillLevel;
    //the list of tasks in plate for the user
    private List<Task> committedTasks = new ArrayList<>();

    //the resources are arranged in the sequence as FIFO
    private Queue<Resources> seqResource = new PriorityQueue<>();

    public User(double skillLevel) {
        this.skillLevel = skillLevel;
    }

    //add task to the user
    public List<Task> addTasks(Task task){
        committedTasks.add(task);
        return committedTasks;
    }

    public List<Task> getCommittedTasks() {
        return committedTasks;
    }

    //add the resources in sequence of the tasks
    public Queue<Resources> addResourcesSeqquence(Task task){
        seqResource.addAll(task.getTasks());
        return seqResource;
    }

    public Queue<Resources> getSeqResource() {
        return seqResource;
    }
}
