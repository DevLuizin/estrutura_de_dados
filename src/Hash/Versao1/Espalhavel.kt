package Hash.Versao1

interface Espalhavel {
    //put(), armazena um par de objetos especificados
    fun adicionar(mapa: Mapa)
    //remove(), remove o objeto com a chave especificada
    fun remover(chave: Any): Any?
    //containsKey(), consulta se uma determinada chave existe na tabela
    fun contemChave(chave: Any): Boolean
    //get(), retorna o objeto associdado a chave especificada
    fun buscar(chave: Any): Any?

    //contains(), consulta se um determinado valor existe na tabela
    //fun contemValor(dado: Any): Boolean
    //getAll(), retorna todos os objetos armazenados
    //fun buscarTodos(): Array<Any>

    fun estaVazia(): Boolean
    fun imprimir(): String
    fun tamanho(): Int

}