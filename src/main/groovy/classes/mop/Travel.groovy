package classes.mop

class Travel {
    void travel(String destination, BigDecimal price) {
        price += 0.50
        println "Viagem até $destination custa $price"
    }
}
