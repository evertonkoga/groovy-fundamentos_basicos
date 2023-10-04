package classes

import groovy.transform.ToString

@ToString(includeNames = true, excludes = "age, wage")
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
