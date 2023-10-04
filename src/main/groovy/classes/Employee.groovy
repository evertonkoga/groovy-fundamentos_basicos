package classes

import groovy.transform.ToString

@ToString(includeNames = true, excludes = "age, wage")
class Employee {
    String name
    Integer age
    Double wage
}
