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

    // 00 - Inserir dado no início da lista
    fun inserirInicio(dado: Any?) {
        if (!estaCheia()) {
            ponteiroInicio = retroceder(ponteiroInicio)
            dados[ponteiroInicio] = dado
            quantidade++
            if (ponteiroFim == -1)
                ponteiroFim = ponteiroInicio
        } else {
            println("List is full!")
        }
    }

    // 01 - Inserir dado no fim da lista
    fun inserirFim(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim)
            dados[ponteiroFim] = dado
            quantidade++
        } else {
            println("List is full!")
        }
    }

    // 02 - Inserir dado em determinada posição
    fun inserir(posicao: Int, dado: Any?) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                val posicaoFisica = logicaParaFisica(posicao)
                var atual = ponteiroFim
                var anterior = atual
                atual = avancar(atual)

                for (i in posicao until quantidade) {
                    dados[atual] = dados[anterior]
                    atual = retroceder(atual)
                    anterior = retroceder(anterior)
                }

                dados[posicaoFisica] = dado
                ponteiroFim = avancar(ponteiroFim)
                quantidade++
            } else {
                println("Invalid Index!")
            }
        } else {
            println("List is full!")
        }
    }

    // 03 - Buscar um dado no início da lista
    fun buscarInicio(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia())
            dadoAux = dados[ponteiroInicio]
        else
            println("List is empty!")
        return dadoAux
    }

    // 04 - Buscar um dado no fim da lista
    fun buscarFim(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia())
            dadoAux = dados[ponteiroFim]
        else
            println("List is empty!")
        return dadoAux
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

    // 06 - Buscar todos os dados da lista
    fun buscarTodos(): Array<Any?> {
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia())
            var ponteiroAux = ponteiroInicio
            for (i in 0 until quantidade) {
                dadosAux[i] = dados[ponteiroAux]
                ponteiroAux = avancar(ponteiroAux)
            }
        else
            println("List is empty!")
        return dadosAux
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