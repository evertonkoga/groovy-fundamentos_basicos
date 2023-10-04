import classes.Client
import classes.Math
import classes.ProductInJava
import classes.ClientInJava as ClientJ
import classes.Client as ClientG
import classes.Sale
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
}

