import classes.Client
import classes.Connection
import classes.DynamicDef
import classes.Employee
import classes.Food
import classes.Invoice
import classes.Math
import classes.ProductInJava
import classes.ClientInJava as ClientJ
import classes.Client as ClientG
import classes.Sale
import classes.Ticket
import classes.closure.Fan
import classes.closure.Report
import classes.closure.Singer
import classes.closure.Stage
import classes.mop.Invoice as InvoiceForMOP
import classes.mop.Travel
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

    @Test
    void exerciseATSTransformationBuilder() {
        Food food = Food.builder()
                .fruit("banana")
                .candy("chocolate")
                .drink("water")
                .build()

        println food.drink
        println food.fruit
        println food.candy
    }

    @Test
    void exerciseOperatorDef() {
        def object = "koga"
        println object.getClass()

        object = 10
        println object.getClass()

        object = 20.9
        println object.getClass()

        object = 20.9f
        println object.getClass()

        object = new Ticket(client: "koga", number: 10)
        println object.getClass()

        object = new Employee(name: "koga", age: 35, wage: 1000.00)
        println object.getClass()
    }

    @Test
    void exerciseOperatorDynamicDef() {
        def object = new DynamicDef()
        def value = object.call("koga_")
        println value.getClass()
        println value

        value = object.call(5)
        println value.getClass()
        println value

        value = object.call(5d)
        println value.getClass()
        println value

        value = object.call(5.0)
        println value.getClass()
        println value
    }

    @Test
    void exerciseOperatorForIn() {
        def list = new ArrayList<String>()
        list.add("Everton")
        list.add("Koga")
        for (item in list) {
            println item.getClass()
            println item
        }

        list = new ArrayList<Integer>()
        list.add(10)
        list.add(120)
        for (item in list) {
            println item.getClass()
            println item
        }

        list = "Koga"
        for (item in list) {
            println item.getClass()
            println item
        }

        list = 10
        for (item in list) {
            println item.getClass()
            println item
        }
    }

    @Test
    void exerciseClosureSimpleMethod() {
        def method = { int value1, int value2 -> value1 + value2 }
        println method(1, 2)
        println method(2, 3)
    }

    @Test
    void exerciseClosureElaborateMethod() {
        def print = { String value ->
            String temp = value.trim().replace("a","@")
            temp.toUpperCase()
        }

        println print(" Koga ")
        println print("fabiano")
    }

    @Test
    void exerciseClosureMethodWithDynamicParams() {
        def method = { param1, param2 -> param1 + param2 }
        def result = method(5, 5)
        println result.class
        println result

        result = method( "ko", "ga")
        println result.class
        println result

        result = method( 10.5, 9.5)
        println result.class
        println result
    }

    @Test
    void exerciseClosureMethodWithClosureParams() {
        def clean = { text ->
            text.trim().replace("a","@").replace(" ","").capitalize()
        }
        def report = new Report()
        report.emit(" Koga ", clean)
    }

    @Test
    void exerciseClosureMethodOmittingClosureParamWhenLastParameter() {
        def report = new Report()
        report.emit(" Everton "){ param -> "$param koga" }
        report.emit(" koga "){ param -> param.replace("a", "@") }
    }

    @Test
    void exerciseClosureMethodOmittingParameterOfClosure() {
        def report = new Report()
        report.emit("Everton") { "$it Fabiano Koga" }
        report.emit("everton") { it.reverse() }
    }

    @Test
    void exerciseClosureMethodImplementingInterfaceFuncional() {
        Stage stage = new Stage()
        Singer singer

        def implementation = { println "Vou cantar" }
        singer = implementation
        singer.sing()
        stage.show(singer)

        singer = { println "Estou cantando" }
        singer.sing()

        stage.show({ println "Parei de cantar" })
    }

    @Test
    void exerciseClosureMethodImplementingInterfaceNotFuncionalWithManyMethods() {
        Fan fan
        def santos = [
                jump: { println "Os santistas estão pulando" },
                scream: { println "$it santos" }
        ] as Fan
        fan = santos
        fan.jump()
        fan.scream("vai ")

        def gremio = [
                jump: { println "Os gremistas estão pulando" },
                scream: { println "$it gremio" }
        ] as Fan
        fan = gremio
        fan.jump()
        fan.scream("vai ")
    }

    @Test
    void exerciseMOPExpandoMetaClassAddMethodOnObject() {
        def invoice = new InvoiceForMOP()
        // Lança exceção, porque o método ainda não existe
        // invoice.sell(10.00)

        // Adiciona o método dinâmicamente no objeto
        invoice.metaClass.sell = { println "Venda no valor de $it" }
        invoice.sell(10.00)
        invoice.sell(1050.00)
    }

    @Test
    void exerciseMOPExpandoMetaClassAddMethodOnClass() {
        def invoice = new InvoiceForMOP()
        // Lança exceção, porque o método ainda não existe
        // invoice.sell(10.00)

        // Adiciona o método dinâmicamente na classe
        InvoiceForMOP.metaClass.sell = { println "Fatura no valor de $it" }

        invoice = new InvoiceForMOP()
        invoice.sell(20)

        invoice = new InvoiceForMOP()
        invoice.sell(55.00)
    }

    @Test
    void exerciseMOPExpandoMetaClassAddAttributeOnObject() {
        def invoice = new InvoiceForMOP()
        // Lança exceção, porque o atributo ainda não existe
        // invoice.client = "Koga"

        // Adiciona o atributo dinâmicamente no objeto
        invoice.metaClass.client = "Koga"
        println invoice.client

        // Atribuido novo valor ao atributo
        invoice.client = "Everton"
        println invoice.client
    }

    @Test
    void exerciseMOPExpandoMetaClassAddAttributeOnClass() {
        def invoice = new InvoiceForMOP()
        // Lança exceção, porque o atributo ainda não existe
        // invoice.client = "Koga"

        // Adiciona o atributo dinâmicamente na classe
        InvoiceForMOP.metaClass.client = null
        invoice = new InvoiceForMOP()
        invoice.client = "Koga"
        println invoice.client

        // Atribuido novo valor ao atributo
        invoice.client = "Everton"
        println invoice.client
    }

    @Test
    void exerciseMOPExpandoMetaClassAddStaticMethodOnClass() {
        InvoiceForMOP.metaClass.static.sell = { println "Fatura no valor de $it" }
        InvoiceForMOP.sell(55.00)

        def invoice = new InvoiceForMOP()
        invoice.sell(20)
    }

    @Test
    void exerciseMOPExpandoMetaClassAddStaticMethodOnObject() {
        def invoice = new InvoiceForMOP()
        invoice.metaClass.static.sell = { println "Fatura no valor de $it" }
        invoice.sell(20)

        /**
         * Lança uma exceção, porque o método estatico foi adicionado em outra instancia
         */
        // invoice = new InvoiceForMOP()
        // invoice.sell(30)

        /**
         * Lança uma exceção, porque o método estatico não foi adicionado na classe
         */
        // InvoiceForMOP.sell(55.00)
    }

    @Test
    void exerciseMOPExpandoMetaClassOverrideMethod() {
        String expectedDestination = "Londrina"
        BigDecimal expectedPrice = 9.99

        Travel travel = new Travel()
        travel.travel(expectedDestination, expectedPrice)

        // Para fazer o override é necessário adicionar a tipagem no(s) parametros
        def newMethod = { String destination, BigDecimal price ->
            price += 3.5
            println "Novo valor para $destination será $price"
        }
        travel.metaClass.travel = newMethod
        travel.travel(expectedDestination, expectedPrice)
    }

    @Test
    void exerciseMOPExpandoDynamicBean() {
        Expando client = new Expando()
        client.name = "Koga"
        client.age = 35
        client.show = { println "Nome $name idade é $age" }
        client.show()

        Expando book = new Expando(author: "koga", page: 10)
        println book.author
        println book.page
    }

    @Test
    void exerciseGDKOverloadBigDecimal() {
        def value1 = new BigDecimal(10.5)
        def value2 = 10.5

        println value2.getClass()
        println value1 == value2

        def value3 = value1 + value2
        println value3.getClass()
        println value3

        value3 = value1 - value2
        println value3

        value3 = value1 * value2
        println value3
    }
}
