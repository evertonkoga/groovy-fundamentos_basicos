import classes.*
import classes.Client as ClientG
import groovy.sql.DataSet
import groovy.sql.Sql
import groovy.xml.MarkupBuilder
import org.junit.Test

import java.nio.file.Paths

import static java.util.Calendar.*

class ExercisesGDKTest {

    @Test
    void overloadBigDecimal() {
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

    @Test
    void overloadString() {
        // Comparação
        def text1 = "koga"
        def text2 = "koga"
        println text1 == text2

        // Sobrecarga do operador (-)
        def newText = text1 - "ga"
        println newText

        // Novos métodos + closures
        String fullName = "everton koga"
        println fullName.capitalize()
        println fullName.findIndexOf {it == "e"}

        // Multiline
        String largeText = '''
        My text
        is very large
        and not need add + to concact
        '''
        println largeText

        // Interporlação de string e evitar utilizar (+)
        def name = "koga"
        def age = 35
        def wage = 1000.52
        def sql = "insert into cliente(name, age, wage) values($name, $age, $wage)"
        println sql
    }

    @Test
    void overloadDate() {
        def date1 = new Date()
        println date1

        date1[YEAR] = 2010
        date1[MONTH] = 8
        date1[DATE] = 16
        println date1

        def date2 = new Date()
        date2[YEAR] = 2015
        date2[MONTH] = DECEMBER
        date2[DATE] = 25
        println date2

        if (date2 >= date1)
            println "a data 2 é maior"

        Date date = new Date()
        println date

        // Adiciona 1 dia
        date += 1
        println date
        // Subtrai 2 dia
        date -= 2
        println date

        // Adiciona 1 dia
        date++
        println date

        // Subtrai 1 dia
        date--
        println date

        // Formata data
        println date.format("dd/MM/yyyy hh:mm:ss")
    }

    @Test
    void overloadInteger() {
        // Loop que inicia de 0 até 9
        10.times { println it }
        // Loop que inicia em 5 indo até 10
        5.upto(10) { println it }
        // Loop que inicia em 3 indo até 0
        3.downto(0) { println it }
    }

    @Test
    void overloadIO() {
        // Valida e cria diretório caso não exista
        String basePath = "D:/file_teste";
        def directory = new File(basePath)
        if(!directory.exists()){
            println "Diretório $directory.path, criado com sucesso"
            directory.mkdir()
        }

        // Criar e escrever arquivo
        new FileWriter("$basePath/file1.txt")
                .withWriter {it.write("Everton Koga")}

        // Criar e escrever arquivo
        new File("$basePath/file2.txt").write("Outro teste")

        // Criar arquivo
        def file = new File("$basePath/file3.txt")
        // Adicionar texto
        file.text = "Linha 1"
        // Adicionar 5 linhas de texto
        3.times {file << "\r\nnova linha usando sobrecarga de operador" }

        // Leitura de todas as linhas através da propriedade
        println file.text
        // Leitura de todas as linhas com spread operator e convertido para caixa alta
        println file.readLines()*.toUpperCase()
        // Leitura de todas as linhas com eachLine
        file.eachLine {println it}

        // Leitura do diretório
        new File(basePath).eachFile {println it.name }

        // Deletando um arquivo específico
        if(file.exists()) {
            println "Arquivo $file.path apagado"
            file.delete()
        }
        // Deletando um diretório específico
        if (directory.exists()) {
            println "Diretório $directory.path apagado"
            directory.deleteDir()
        }
    }

    @Test
    void overloadJDBC() {
        // Obter o caminho absoluto do database
        String basePath = Paths.get("").toAbsolutePath().toString()
        String databasePath = "$basePath\\database\\hsqldb\\base"

        println databasePath

        // Create connection com database
        Sql connection = Sql.newInstance(
                "jdbc:hsqldb:file:$databasePath;shutdown=true",
                "sa",
                "1234"
        )

        String queryAllCliente = "select * from cliente"
        def closureReturnClient = { println "${it.id} - ${it.nome} - ${it.email}" }

        // Retorna todos os clientes
        connection.eachRow(queryAllCliente, closureReturnClient)

        // Retorna todos os clientes em memória
        def list = connection.rows(queryAllCliente)
        list.each {println it.email }

        // Salva um cliente com comando SQL
        connection.executeInsert("insert into cliente(nome, email) values('Koga', 'koga@teste.com.br')")
        println "\nInserindo..."
        connection.eachRow(queryAllCliente, closureReturnClient)

        // Salva um cliente com DataSet sem utilizar SQL
        DataSet table = connection.dataSet("cliente")
        table.add(nome: "Everton", email:"everton@teste.com.br")
        println "\nInserindo..."
        connection.eachRow(queryAllCliente) { println it.nome }
    }

    @Test
    void overloadCollection() {
        // Em Java
        // List<String> list = new ArrayList();

        // Em Groovy
        def list1 = [1,2,3,4]
        println list1.getClass().name

        def list2 = [ "Everton", "Fabiano", "Koga" ]
        println list2.getClass().name

        def list3 = new ArrayList<BigDecimal>()
        // Add em Java
        list3.add(1.50)
        // Add em Groovy, utilizando operador sobrecarregado
        list3 << 10.50
        list3 << 5.5

        // Iterar toda lista
        list3.each { println it }

        def total = 0
        list3.each { total += it }
        println "Total: $total"

        // Add lista de Client
        def clients = []
        clients << new ClientG(name: "Everton", createAt: new Date())
        clients << new ClientG(name: "Tatu", createAt: new Date())
        clients << new ClientG(name: "Fabiano", createAt: new Date())
        clients << new ClientG(name: "Koga", createAt: new Date())

        // Obtem o primeiro cliente que contaim 'a'
        def result = clients.find { it.name.contains("a") }
        println result

        // Obtem totos os clientes que contaim 'a'
        result = clients.findAll { it.name.contains("a") }
        println result

        // Reordena lista pelo nome desc
        clients.sort {client1, client2 -> client2.name.compareTo(client1.name)}
        println clients

        // Converte para Set
        def clientSet = clients as Set
        println clientSet.getClass().name
        // Lista os itens do Set
        clientSet.each { println it}

        // Converte para List
        def clientList = clientSet as List
        println clientList.getClass().name

        // Transforma o List e Set em imutável
        def listImmutable = clientList.asImmutable()
        def setImmutable = clientSet.asImmutable()

        // Transforma o List e Set em sincronizado
        def listSynchronized = clientList.asSynchronized()
        def setSynchronized = clientSet.asSynchronized()

        // Transforma um lista de client em uma lista de employee
        def employees = clients.collect({ new Employee(name: it.name) })
        println employees
    }

    @Test
    void overloadMap() {
        def map = [:]
        println map.getClass().name
        // Preenchendo Map com chave/valor
        map["pai"] = "Everton"
        map["mae"] = "Ariadne"
        println map

        // Obtendo valor pela chave
        println map["pai"]
        println map["mae"]

        // Removendo item no Map
        map.remove("pai")
        println map

        // Crinado Map através de construtor
        def pessoas = ["pais": 1, "maes": 9, "filhos": 10]
        println pessoas

        // Imprimindo valores do Map
        println "-----> Valores"
        pessoas.values().each { println it }

        // Imprimindo Keys do Map
        println "-----> Keys"
        pessoas.keySet().each { println it }
    }

    @Test
    void objectGraphBuilderHtml() {
        def writer = new StringWriter()
        def html = new MarkupBuilder(writer)
        html.html {
            head { title "Minha Página" }
            body(id: "main") {
                h1 "Título"
                p "Primeiro paragrafo"
                p { strong "Texto em negrito" }
                a href: "http://google.com","Clique aqui"
            }
        }
        println writer
    }
}
