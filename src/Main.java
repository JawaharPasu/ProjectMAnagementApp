import java.util.Optional;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");

        //The function should verify whether the project can be completed if work started today.

        //We need to have resources
        Optional<Resources> resource = Resources.getResourcesByName("java");

        System.out.println(resource.get().toString()+ " " + Resources.currentsize.toString());
        Resources.utilizeResource("java");
        Resources.utilizeResource("excel");

        System.out.println(Resources.currentsize.toString());

        Resources.surrenderResource("excel");
        Resources.surrenderResource("excel");


        System.out.println(Resources.currentsize.toString());

        Task task = new Task(new String[]{"excel","word"});
        System.out.println(task.getTasks().toString());

        //we need to have users performing the tasks

        //we need to have tasks with proper labels assigned

        //specify the input to check the project completion can be done (number of days )
    }
}
