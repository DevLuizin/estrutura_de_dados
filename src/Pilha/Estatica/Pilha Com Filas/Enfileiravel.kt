package Pilha.`Pilha Com Filas`

interface Enfileiravel {
    // Metodos principais
    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun atualizar(dado: Any?)
    fun frente(): Any?
    // Métodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}