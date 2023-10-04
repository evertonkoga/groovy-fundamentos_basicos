package classes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString(includeNames = true, excludes = "age, wage")
@EqualsAndHashCode(excludes = "wage")
class Employee {
    String name
    Integer age
    Double wage

    // ToString em Java
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

    // EqualsAndHashCode em Java
    /**
    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.class) return false

        Employee employee = (Employee) o

        if (age != employee.age) return false
        if (name != employee.name) return false
        if (wage != employee.wage) return false

        return true
    }

    int hashCode() {
        int result
        result = (name != null ? name.hashCode() : 0)
        result = 31 * result + (age != null ? age.hashCode() : 0)
        result = 31 * result + (wage != null ? wage.hashCode() : 0)
        return result
    }
    **/
}
