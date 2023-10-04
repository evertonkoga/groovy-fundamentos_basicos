import classes.Client
import classes.Connection
import classes.Employee
import classes.Invoice
import classes.Math
import classes.ProductInJava
import classes.ClientInJava as ClientJ
import classes.Client as ClientG
import classes.Sale
import classes.Ticket
import org.junit.Test
import static javax.swing.JFrame.EXIT_ON_CLOSE as EXIT_ON_CLOSE

class ExercisesTest {

    @Test
    void exercisePrimitiveTypeLiteral() {
        int number = 10
        println number.toString()

        // Valor literal Integer
        println number.class

        // Valor literal Long precisa adicionar 'L' ou 'l'
        println 12l.class.name
        // Valor literal BigInteger precisa adicionar 'G' ou 'g'
        println 12g.class.name
        // Valor literal Float precisa adicionar 'F' ou 'f'
        println 200.50f.class.name
        // Valor literal Double precisa adicionar 'D' ou 'd'
        println 200.50d.class.name
        // Valor literal BigDecimal
        println 200.50.class.name
    }

    @Test
    void exercisePOGO() {
        Client cliente = new Client()
        cliente.setName "Everton Koga"
        cliente.setCreateAt new Date()

        println cliente.sum(10, 10)
        println cliente.getName() + " - " + cliente.getCreateAt()
    }

    @Test
    void exerciseConstructorNamesArguments() {
        Client client = new Client();
        println client.getName() + " - " + client.getCreateAt()

        client = new Client(name: "Everton")
        println client.getName() + " - " + client.getCreateAt()

        client = new Client(createAt: new Date())
        println client.getName() + " - " + client.getCreateAt()

        client = new Client(name: "Everton", createAt: new Date())
        println client.getName() + " - " + client.getCreateAt()
    }

    @Test
    void exerciseSubscriptOperator() {
        Client client = new Client(name: "Everton", createAt: new Date())
        println client.getName()

        println client["name"]

        client["name"] = "Koga"
        println client["name"]
    }

    @Test
    void exerciseDirectFieldAcessOperator() {
        ProductInJava product = new ProductInJava("chocolate", 20.00d)
        println product.name
        println product.name = "bean"

        product.price = 15.00d
        println product.name + " - " + product.price
    }

    @Test
    void exerciseOperatorAs() {
        ClientJ java = new ClientJ("koga", new Date())
        println java.name + " - " + java.createAt

        ClientG groovy = new ClientG(name: "Everton", createAt: new Date())
        println groovy.name + " - " + groovy.createAt

        println EXIT_ON_CLOSE
    }

    @Test
    void exerciseOptionalParameters() {
        Sale sale = new Sale()
        println sale.sell(40.0)
        println sale.sell(40.0, 20)
    }

    @Test
    void exerciseArrayOptionalParameters() {
        Math math = new Math()
        println math.sum(10)
        println math.sum(10, 10)
        println math.sum(10, 10, 10)
    }

    @Test
    void exerciseSafeNavegatorOperator() {
        Client client = null
        // Em Java
        /** if(client != null) {
            client.setName("Everton")
            println client.getName()
        } **/
        // Em Groovy
        client?.name = "Everton"
        println client?.getName()

        Client client2 = new Client()
        client2.name = "Koga"
        println client2?.getName()
        println client2?.name
    }

    @Test
    void exerciseSpreadOperator() {
        List<String> lista = Arrays.asList(
                "Everton",
                "Fabiano",
                "Koga",
                null,
                "Everton Fabiano Koga"
        )
        println lista
         // Em Java
        /**for(String value: lista) {
            if (value != null)
                value = value.toUpperCase()
        }**/

        // Em Groovy
        lista = lista*.toUpperCase()
        println lista

        lista = lista*.replace("E", "3")
        println lista
    }

    @Test
    void exerciseCheckedExceptions() {
        // Em Java
        /**
        try {
            URL url = new URL("https://google.com.br")
        } catch (Exception ex) {
            ex.printStackTrace()
        }
        **/

        // Em Groovy
        URL url = new URL("https://google.com.br")
        println url

        /** Vai quebrar aplicação
         url = new URL("sdfoisdfsjdfsjdf")
         println url
         **/
    }

    @Test
    void exerciseBooleanAvaluation() {
        String name = null
        println getMessage("name", name)

        name = "Koga"
        println getMessage("name", name)

        int numer = 0
        println getMessage("numer", numer)

        numer = 1
        println getMessage("numer", numer)

        List list = null
        println getMessage("list", list)

        list = new ArrayList()
        println getMessage("list", list)

        list.add("Koga")
        println getMessage("list", list)

        Client client
        println getMessage("client", client)

        client = new Client()
        println getMessage("client", client)
    }

    private String getMessage(attribute, value) {
        value ? "${attribute} is not null" : "${attribute} is null"
    }

    @Test
    void exerciseOperatorOverloading() {
        Invoice invoice1 = new Invoice(itens: 20, price: 2)
        Invoice invoice2 = new Invoice(itens: 20, price: 2)
        Invoice invoice3 = invoice1 + invoice2
        println invoice3.price + " - " + invoice3.itens

        invoice1++
        println invoice1.price + " - " + invoice1.itens
    }

    @Test
    void exerciseOperatorOverloadingOfBigDecimal() {
        // Em Java
        /**
        BigDecimal price = new BigDecimal(10)
        println price
        BigDecimal sum = price.add(new BigDecimal(1))
        println sum
         **/

        // Em Groovy
        BigDecimal price = 10
        println price
        // Operator plus(+)
        price = price + 1
        println price
        // Operator next(++)
        price++
        println price
        // Operator minus(-)
        println price - 5
    }

    @Test
    void exerciseATSTransformationToString() {
        Employee employee = new Employee(name: "koga", age: 35, wage: 1000)
        println employee
    }

    @Test
    void exerciseATSTransformationEqualsAndHashCode() {
        Employee employee1 = new Employee(name: "koga", age: 35, wage: 1000)
        Employee employee2 = new Employee(name: "koga", age: 35, wage: 5000)
        println employee1.equals(employee2)
        println employee2.equals(employee1)
    }

    @Test
    void exerciseATSTransformationImmutable() {
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
    void exerciseATSTransformationSingleton() {
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
}

