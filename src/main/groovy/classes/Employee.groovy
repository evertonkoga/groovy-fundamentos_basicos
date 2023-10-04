package classes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString(includeNames = true, excludes = "age, wage")
@EqualsAndHashCode(excludes = "wage")
class Employee {
    String name
    Integer age
    Double wage

    // Em Java
    /**
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wage=" + wage +
                '}';
    }
     **/
}
