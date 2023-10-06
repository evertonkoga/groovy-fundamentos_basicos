import classes.mop.Invoice as InvoiceForMOP
import classes.mop.Travel
import org.junit.Test

class ExercisesMOPExpandoTest {

    @Test
    void metaClassAddMethodOnObject() {
        def invoice = new InvoiceForMOP()
        // Lança exceção, porque o método ainda não existe
        // invoice.sell(10.00)

        // Adiciona o método dinâmicamente no objeto
        invoice.metaClass.sell = { println "Venda no valor de $it" }
        invoice.sell(10.00)
        invoice.sell(1050.00)
    }

    @Test
    void metaClassAddMethodOnClass() {
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
    void metaClassAddAttributeOnObject() {
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
    void metaClassAddAttributeOnClass() {
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
    void metaClassAddStaticMethodOnClass() {
        InvoiceForMOP.metaClass.static.sell = { println "Fatura no valor de $it" }
        InvoiceForMOP.sell(55.00)

        def invoice = new InvoiceForMOP()
        invoice.sell(20)
    }

    @Test
    void metaClassAddStaticMethodOnObject() {
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
    void metaClassOverrideMethod() {
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
    void dynamicBean() {
        Expando client = new Expando()
        client.name = "Koga"
        client.age = 35
        client.show = { println "Nome $name idade é $age" }
        client.show()

        Expando book = new Expando(author: "koga", page: 10)
        println book.author
        println book.page
    }
}
