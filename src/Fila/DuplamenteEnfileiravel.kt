interface DuplamenteEnfileiravel {
    //Métodos Principais
    fun enfileirarInicio(dado: Any?)
    fun enfileirarFim(dado: Any?)
    fun desenfileirarInicio(): Any?
    fun desenfileirarFim(): Any?
    fun espiarInicio(): Any?
    fun espiarFim(): Any?
    fun atualizarInicio(novoDado: Any?)
    fun atualizarFim(novoDado: Any?)
    //Métodos Auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimirFrentePraTras(): String
    fun imprimirTrasPraFrente(): String
}