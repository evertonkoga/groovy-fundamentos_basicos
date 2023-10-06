package classes

import groovy.transform.ToString

@ToString
class Client {
    String name
    Date createAt

    Integer sum(Integer number1, Integer number2) {
        number1 + number2
    }
}