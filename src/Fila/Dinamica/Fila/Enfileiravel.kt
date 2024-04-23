interface Enfileiravel {
    // Métodos principais
    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun atualizar(dado: Any?)
    fun frente(): Any?

    // Métodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}