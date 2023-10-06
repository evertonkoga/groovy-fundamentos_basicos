import classes.closure.Fan
import classes.closure.Report
import classes.closure.Singer
import classes.closure.Stage
import org.junit.Test

class ExercisesClosureTest {

    @Test
    void simpleMethod() {
        def method = { int value1, int value2 -> value1 + value2 }
        println method(1, 2)
        println method(2, 3)
    }

    @Test
    void elaborateMethod() {
        def print = { String value ->
            String temp = value.trim().replace("a","@")
            temp.toUpperCase()
        }

        println print(" Koga ")
        println print("fabiano")
    }

    @Test
    void methodWithDynamicParams() {
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
    void methodWithClosureParams() {
        def clean = { text ->
            text.trim().replace("a","@").replace(" ","").capitalize()
        }
        def report = new Report()
        report.emit(" Koga ", clean)
    }

    @Test
    void methodOmittingClosureParamWhenLastParameter() {
        def report = new Report()
        report.emit(" Everton "){ param -> "$param koga" }
        report.emit(" koga "){ param -> param.replace("a", "@") }
    }

    @Test
    void methodOmittingParameterOfClosure() {
        def report = new Report()
        report.emit("Everton") { "$it Fabiano Koga" }
        report.emit("everton") { it.reverse() }
    }

    @Test
    void methodImplementingInterfaceFuncional() {
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
    void methodImplementingInterfaceNotFuncionalWithManyMethods() {
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
}
