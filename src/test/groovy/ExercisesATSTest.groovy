import classes.*
import org.junit.Test

class ExercisesATSTest {

    @Test
    void transformationToString() {
        Employee employee = new Employee(name: "koga", age: 35, wage: 1000)
        println employee
    }

    @Test
    void transformationEqualsAndHashCode() {
        Employee employee1 = new Employee(name: "koga", age: 35, wage: 1000)
        Employee employee2 = new Employee(name: "koga", age: 35, wage: 5000)
        println employee1.equals(employee2)
        println employee2.equals(employee1)
    }

    @Test
    void transformationImmutable() {
        Ticket ticket1 = new Ticket(client: "Koga", number: 1)
        Ticket ticket2 = new Ticket(client: "Koga", number: 1)
        // Call getters
        println ticket1.client + " - " + ticket1.number
        // Call toString
        println ticket1
        // Call EqualsAndHashCode
        println ticket1.equals(ticket2)
        println ticket2.equals(ticket1)
        // Call setters - but generete an exception
        /** ticket1.number = 20 **/
    }

    @Test
    void transformationSingleton() {
        Connection.instance.url = "https://google.com"
        println Connection.instance.url

        Connection connection = Connection.instance
        connection.url = "https://gmail.com"
        println Connection.instance.url

        // Gera erro
        /**
         Connection c = new Connection()
         println c
         **/
    }

    @Test
    void transformationBuilder() {
        Food food = Food.builder()
                .fruit("banana")
                .candy("chocolate")
                .drink("water")
                .build()

        println food.drink
        println food.fruit
        println food.candy
    }
}
