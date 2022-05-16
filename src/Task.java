import java.util.ArrayList;
import java.util.List;

//Class that defines the tasks required to complete a project
public class Task {
    private List<Resources> tasks = new ArrayList<>();

    //this function accepts array of items in the resources, each project consist of the sequence of certain resources
    public Task(String[] tasksin) {
        for(String taskentry : tasksin){
            tasks.add(Resources.getResourcesByName(taskentry).get());
        }
    }

    //To get the tasks assosciated with the given project (instance dependent)
    public List<Resources> getTasks() {
        return tasks;
    }
}
