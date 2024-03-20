package Pilha.`Pilha Com Filas`

interface Empilhavel {
    // Métodos principais
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun atualizar(dado: Any?)
    fun espiar(): Any?
    // Métodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}