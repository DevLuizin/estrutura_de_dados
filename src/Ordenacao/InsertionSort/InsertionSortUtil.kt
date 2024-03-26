import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.system.measureNanoTime

fun main() {
    val gerador = Random
    //10 números aleatórios entre 100 e 500
    val dados = Array<Int>(10) {gerador.nextInt(100,501)}
    var b = InsertionSort(dados)
    var b1 = b

    b.imprimir()
    val tempNano = measureNanoTime { b.ordenar() }

    val tempMili = measureTimeMillis { b1.ordenar() }
    b.imprimir()

    println("Tempo de Execução: $tempNano ns")
    println("Tempo de Execução: $tempMili ms")
}