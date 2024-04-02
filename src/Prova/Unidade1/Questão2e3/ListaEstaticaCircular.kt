class ListaEstaticaCircular(val tamanho: Int = 10) {
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0
    private var ponteiroInicio = 0
    private var ponteiroFim = -1

    fun estaCheia(): Boolean {
        return quantidade == dados.size
    }

    fun estaVazia(): Boolean {
        return quantidade == 0
    }

    // 10 - Atualizar o dado do fim de uma Lista Estatica Circular
    fun atualizarFim(dado: Any?) {
        if (!estaVazia()) {
            dados[ponteiroFim] = dado
        } else {
            println("List is Empty!")
        }
    }
    
}