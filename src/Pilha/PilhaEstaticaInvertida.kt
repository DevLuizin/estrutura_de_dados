class PilhaEstaticaInvertida : Empilhavel {
    // variáveis globais (de instância)
    private var ponteiroTopo: Int
    private var dados: Array<Any?>
    // construtores
    constructor() : this(10)

    constructor(tamanho: Int) {
        ponteiroTopo = tamanho
        dados = arrayOfNulls(tamanho)
    }

    // métodos auxiliares
    override fun estaCheia(): Boolean {
        return (ponteiroTopo == 0)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == dados.size)
    }

    override fun imprimir(): String {
        var resultado = "["
        //iterar a pilha
        for (i in ponteiroTopo .. dados.size-1){
            if (i == dados.size-1)
                resultado += "${dados[i]}"
            else
                resultado += "${dados[i]},"
        }
        return "$resultado]"
    }
    // métodos principais
    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo--
            dados[ponteiroTopo] = dado
        } else {
            println("Stack is full")
        }
    }

    override fun desempilhar(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
            ponteiroTopo++
        } else {
            println("Stack is empty!")
        }
        return retorno
    }

    override fun topo(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
        } else {
            println("Stack is empty")
        }
        return retorno

    }
}