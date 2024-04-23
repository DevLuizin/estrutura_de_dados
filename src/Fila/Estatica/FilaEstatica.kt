class FilaEstatica(val tamanho: Int = 10) : Enfileiravel{
    //variaveis de Instância & Construtor
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    //Construtores

    //Métodos Auxiliares
    override  fun estaCheia(): Boolean {
        return (ponteiroFim == dados.size - 1)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroFim + 1 == ponteiroInicio)
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroInicio..ponteiroFim) {
            if (i == ponteiroFim)
                resultado += "${dados[i]}"
            else
                resultado += "${dados[i]},"
        }
        return "$resultado]"
    }
    //Métodos Principais
    override fun espiar() : Any? {
        var dado: Any? = null
        if (!estaVazia())
            dado = dados[ponteiroInicio]
        else
            println("Queue is empty!")
        return dado
    }

    override fun desenfileirar() : Any? {
        var dado: Any? = null
        if (!estaVazia()) {
            dado = dados[ponteiroInicio]
            ponteiroInicio++
        }
        else
            println("Queue is empty!")
        return dado
    }

    override fun atualizar(novoDado: Any) {
        if (!estaVazia())
            dados[ponteiroInicio] = novoDado
        else
            println("Queue")
    }

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
        } else {
            println("Queue is Full!")
        }
    }
}
