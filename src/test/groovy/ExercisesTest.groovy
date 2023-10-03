import org.junit.Test

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
}
