interface EnfileiravelDupla {
    // Métodos principais
    fun enfileirarInicio(dado: Any?)
    fun enfileirarFim(dado: Any?) // Mesmo que enfileirar da Fila Comum
    fun desenfileirarInicio(): Any? // Mesmo que desenfileirar da Fila Comum
    fun desenfileirarFim(): Any?
    fun atualizarInicio(dado: Any?) // Mesmo que atualizar da Fila Comum
    fun atualizarFim(dado: Any?)
    fun frente(): Any? // Mesmo que frente da Fila Comum
    fun tras(): Any?

    // Métodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimirFrenteParaTras(): String // Mesmo que imprimir da Fila Comum
    fun imprimirTrasParaFrente(): String
}