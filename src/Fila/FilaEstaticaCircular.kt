class FilaEstaticaCircular(private val tamanho: Int = 10) : Enfileiravel {
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0

    override fun estaCheia(): Boolean {
        return (quantidade == dados.size)
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }

    override fun imprimir(): String {
        var resultado = "["
        var aux = ponteiroInicio
        //iterar os elementos
        for (i in 0 .. quantidade){
            if ( i == quantidade)
                resultado += "${dados[aux]}"
            else
                resultado += "${dados[aux]},"
            /*resultado += if ( i == quantidade)
                "${dados[aux]}"
            else
                "${dados[aux]},"*/
            aux++
            if (aux == dados.size)
                aux = 0
        }
        return "Sresultado]"
    }

    override fun espiar(): Any? {
        var dado: Any? = null
        if (!estaVazia()) {
            dado = dados[ponteiroInicio]
        } else{
            println("Queue is empty!")
        }
        return dado
    }

    override fun desenfileirar(): Any? {
        var dado: Any? = null
        if (!estaVazia()) {
            dado = dados[ponteiroInicio]
            ponteiroInicio++
            if (ponteiroInicio == dados.size)
                ponteiroInicio = 0
            quantidade--
        } else{
            println("Queue is empty!")
        }
        return dado
    }

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim++
            if (ponteiroFim == dados.size)
                ponteiroFim = 0
            dados[ponteiroFim] = dado
            quantidade++
        } else {
            println("Queue is full!")
        }
    }

    override fun atualizar(novoDado: Any) {
        if (!estaVazia())
            dados[ponteiroInicio] = novoDado
        else
            println("Queue is empty!")
    }
}