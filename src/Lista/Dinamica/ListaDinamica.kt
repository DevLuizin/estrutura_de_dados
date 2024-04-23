class ListaDinamica(private val tamanho: Int = 10): Listavel {

    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun anexar(dado: Any?) {
       if (!estaCheia()) {
           val novoNo = NoDuplo(dado)
           novoNo.anterior = ponteiroFim
           if (!estaVazia())
               ponteiroFim?.proximo = novoNo
           else
               ponteiroInicio = novoNo
           ponteiroFim = novoNo
           quantidade = quantidade.inc()

       } else {
           println("List is full!")
       }
    }

    override fun inserir(posicao: Int, dado: Any?) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                val noTemp = NoDuplo(dado)
                // noTemp.dado = dado
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                
                if (estaVazia()) {
                    ponteiroInicio = noTemp
                    ponteiroFim = noTemp 
                } else {
                    val ponteiroPro = ponteiroAux
                    val ponteiroAnt = ponteiroAux?.anterior ?: ponteiroFim

                    if (ponteiroAnt != null)
                        ponteiroAnt.proximo = noTemp
                    else
                        ponteiroInicio = noTemp
                    
                    if (ponteiroPro != null)
                        ponteiroPro.anterior = noTemp
                    else 
                        ponteiroFim = noTemp
                        
                    noTemp.proximo = ponteiroPro
                    noTemp.anterior = ponteiroAnt
                }
            } else  {
                println("Invalid Index")
            }
        } else {
            println("List is Full!")
        }
    }

    override fun selecionar(posicao: Int): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                dadoAux = ponteiroAux?.dado
            } else {
                println("Invalid Index!")
            }
        } else {
            println("List is empty!")
        }
        return dadoAux
    }

    override fun selecionarTodos(): Array<Any?> {
        var dados: Array<Any?> = arrayOfNulls(quantidade)
        var ponteiroAux = ponteiroInicio
        for (i in 0 ..< quantidade) {
            dados[i] = ponteiroAux?.dado
            ponteiroAux = ponteiroAux?.proximo
        }
        return dados
    }

    override fun atualizar(posicao: Int, dado: Any?) {
        if (!estaCheia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                ponteiroAux?.dado = dado
            } else {
                println("Invalid Index!")
            }
        } else {
            println("List is full!")
        }
    }

    override fun apagar(posicao: Int): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                var ponteiroAnt = ponteiroAux?.anterior
                var ponteiroPro = ponteiroAux?.proximo
                if (ponteiroAnt != null)
                    ponteiroAnt.proximo = ponteiroPro
                if (ponteiroPro != null)
                    ponteiroPro.anterior = ponteiroAnt
                quantidade = quantidade.dec()
            } else {
                println("Invalid Index!")
            }
        } else {
            println("List is empty!")
        }
        return dadoAux
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var resultado = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 ..< quantidade) {
            resultado += ponteiroAux?.dado
            if (i != quantidade-1)
                resultado += ", "
            ponteiroAux = ponteiroAux?.proximo
        }
        return "$resultado]"
    }

}