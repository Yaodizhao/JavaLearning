package JavaCoreLearning1.package1;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public abstract String getDescription();
    
    public String getName() {
        return name;
    }
}

