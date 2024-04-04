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

    private fun logicaParaFisica(posicao: Int): Int {
        return (ponteiroInicio + posicao) % dados.size
    }

    private fun avancar(ponteiro: Int): Int {
        var aux = ponteiro
        aux++
        return if (aux == dados.size) 0 else aux
    }

    private fun retroceder(ponteiro: Int): Int {
        var aux = ponteiro
        aux--
        return if (aux == -1) dados.size-1 else aux
    }

    private fun trocar(i: Int, j: Int) {
        var dadoAux = dados[i]
        dados[i] = dados[j]
        dados[j] = dadoAux
    }

    // 05 - Buscar um dado de uma posição lógica específica em uma Lista Estatica Circular
    fun Buscar(posicao: Int): Any? {
        var dadoRetono: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                //Mapeamento de posição física
                var posiçãoFisica = (posicao+ponteiroInicio) % dados.size
                dadoRetono = dados[posiçãoFisica]
            } else {
                println("Invalid Index!")
            }
        } else {
            println("List is Empty!")
        }
        return dadoRetono
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