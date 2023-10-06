package classes.gdk

class Thread {
    static main(args) {
        println "Iniciado ${new Date()}"
        java.lang.Thread.start { 5.times {println "Rodando em outra thread $it"} }
        println "Iniciado ${new Date()}"
    }
}
