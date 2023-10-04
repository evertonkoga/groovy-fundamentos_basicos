package classes

class Invoice {
    Integer itens
    Double price

    Invoice plus(Invoice invoice) {
        println "Operador plus(*)"
        Invoice newInvoice = new Invoice()
        newInvoice.itens = this.itens + invoice.itens
        newInvoice.price = this.price + invoice.price
        newInvoice
    }

    Invoice next() {
        println "Operador next(++)"
        this.itens += 1
        this.price *= 2
        this
    }

    Invoice previous() {
        println "Operador previous(--)"
    }

    Invoice minus(Invoice invoice) {
        println "Operador minus(-)"
    }

    Invoice multiply(Invoice invoice) {
        println "Operador multiply(*)"
    }

    Invoice div(Invoice invoice) {
        println "Operador div(/)"
    }

    Invoice mod(Invoice invoice) {
        println "Operador mod(%)"
    }

    Invoice power(Invoice invoice) {
        println "Operador power(**)"
    }

    Invoice or(Invoice invoice) {
        println "Operador or(|)"
    }

    Invoice and(Invoice invoice) {
        println "Operador and(&)"
    }

    Invoice xor(Invoice invoice) {
        println "Operador xor(^)"
    }
}
