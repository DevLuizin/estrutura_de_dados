//Queueable
//DAO - Data Access Object
interface Enfileiravel {

    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun espiar(): Any?
    fun atualizar(dado: Any)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String //Any?
}
