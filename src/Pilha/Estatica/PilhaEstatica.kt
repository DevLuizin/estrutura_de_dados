class PilhaEstatica : Empilhavel {
    // variáveis globais (de instância)
    private var ponteiroTopo: Int
    private var dados: Array<Any?>
    // construtores
    constructor() : this(10)

    constructor(tamanho: Int) {
        ponteiroTopo = -1
        dados = arrayOfNulls(tamanho)
    }
    // métodos auxiliares
    override fun estaCheia(): Boolean {
        return (ponteiroTopo == dados.size - 1)
        /*if (ponteiroTopo == dados.size - 1) {
            return true
        else
            return false
        }*/
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == -1)
    }

    override fun imprimir(): String {
        var resultado = "["
        //iterar a pilha
        for (i in ponteiroTopo downTo 0){
            if (i == 0)
                resultado += "${dados[i]}"
            else
                resultado += "${dados[i]},"
        }
        return "$resultado]"
        //[A,Z,G,F]
    }
    // métodos principais
    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        } else {
            println("Stack is full!")
        }
    }

    override fun desempilhar(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
            ponteiroTopo--
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
            println("Stack is empty!")
        }
        return retorno

    }
}