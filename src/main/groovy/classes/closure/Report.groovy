package classes.closure

class Report {
    void emit(client, header) {
        def report = header(client)
        println "Relatório de vendas: $report !!!"
    }
}
