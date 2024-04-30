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
				//noTemp.dado = dado
				var ponteiroAuxiliar = ponteiroInicio
				for (i in 0 until posicao)
					ponteiroAuxiliar = ponteiroAuxiliar?.proximo
				
				val ponteiroProximo = ponteiroAuxiliar
				val ponteiroAnterior = ponteiroFim
				if (ponteiroAuxiliar != null)
					ponteiroAnterior = ponteiroAuxiliar.anterior
				*/
				var ponteiroAnterior: NoDuplo? = null
				var ponteiroProximo = ponteiroInicio

				for (i in 0 until posicao) {
					ponteiroAnterior = ponteiroProximo
					ponteiroProximo = ponteiroProximo?.proximo
				}

				//todas insercoes, exceto inicio
				if (ponteiroAnterior != null)						
					ponteiroAnterior.proximo = noTemp
				else
					ponteiroInicio = noTemp

				if (ponteiroProximo != null)
					ponteiroProximo.anterior = noTemp
				else	
					ponteiroFim = noTemp						
			
				noTemp.proximo = ponteiroProximo
				noTemp.anterior = ponteiroAnterior						

				quantidade = quantidade.inc()
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