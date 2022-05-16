import java.util.Arrays;
import java.util.Optional;

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
}
