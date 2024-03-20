package Pilha.`Pilha Com Filas`

fun main(){
    var pilha: Empilhavel = PilhaEstaticaComFilas(7)
    pilha.empilhar("Instituto")
    pilha.empilhar("Federal")
    println("Espiar: " + pilha.espiar())
    pilha.empilhar("de")
    pilha.empilhar("Educação")
    pilha.empilhar("Ciência")
    pilha.empilhar("e")
    println("Espiar: " + pilha.espiar())
    val conteudo = pilha.desempilhar()
    pilha.desempilhar()
    pilha.empilhar("Tecnologia")
    pilha.empilhar("da")
    pilha.empilhar("Bahia")
    pilha.empilhar(pilha.desempilhar())
    pilha.empilhar(conteudo)
    println("Pilha="+pilha.imprimir())
}