import java.util.*;

//Creating class for resources, enum defined here are not modifiable by others
public enum Resources {

    //adding resources that should be used for doing the project (name, no.of licences available)
    EXCEL("excel", 5),
    WORD("word", 4),
    SPLUNK("splunk", 3),
    JAVA("java", 2);
    //name for the resource
    private final String name;
    // total no of the resource available
    private final Integer size;

    // creating a map which contains the current resource availability at a particular time
    public static Map<String, Integer> currentsize = assignCurrentSize();

    //create a Map which stores the resource and no of days resource will be occupied
    public static Map<String, Double> occupancyOfResource = assignInitialSize();

    Resources(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public static Optional<Resources> getResourcesByName(String name){
        return Arrays.stream(Resources.values()).filter(val -> val.getName().equalsIgnoreCase(name)).findAny();
    }

    //while initial load, the available resources are equal to the predfined numebr
    private static Map<String, Integer> assignCurrentSize(){
        Map<String, Integer> result = new HashMap<>();
        Arrays.stream(Resources.values()).forEach(res -> result.put(res.getName(), res.getSize()));
        return result;
    }

    //t be used when we utilize a resource - a resource is given for use to user
    public static boolean utilizeResource(String name, Double skill){
        Integer resSize = currentsize.get(name);
        if(resSize==0) return false;
        currentsize.put(name, resSize-1);
        occupancyOfResource.put(name, occupancyOfResource.get(name)+skill);
        return true;
    }

    //to be used when we surrender a resource - a resource is given back by the user after using it
    public static boolean surrenderResource(String name, Double skill){
        Integer resSize = currentsize.get(name);
        if(resSize>=getResourcesByName(name).get().getSize()) return false;
        currentsize.put(name, resSize+1);
        occupancyOfResource.put(name, occupancyOfResource.get(name)-skill);
        return true;
    }

    //while initial load, the available resources are equal to the predfined numebr
    private static Map<String, Double> assignInitialSize(){
        Map<String, Double> result = new HashMap<>();
        Arrays.stream(Resources.values()).forEach(res -> result.put(res.getName(), 0.0));
        return result;
    }
}
