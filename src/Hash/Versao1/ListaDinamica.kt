package Hash.Versao1

class ListaDinamica (private val tamanho: Int = 10) : Listavel {

    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    //Idêntico ao enfileirar de FilaDinamica
    override fun anexar(dado: Any?) {
        if (!estaCheia()) {
            val noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroFim
            if (!estaVazia())
                ponteiroFim?.proximo = noTemp
            else
                ponteiroInicio = noTemp
            ponteiroFim = noTemp
            quantidade = quantidade.inc()
        } else
            println("List is full!")
    }

    override fun selecionarTodos(): Array<Any?> {
        var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            var ponteiroAux = ponteiroInicio
            for (i in 0..< quantidade) {
                dadosAux[i] = ponteiroAux?.dado
                ponteiroAux = ponteiroAux?.proximo
            }
        } else
            println("List is empty!")
        return dadosAux
    }

    override fun selecionar(posicao: Int): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao< quantidade) {
                ///////////////////////
                //Código de posicionamento do ponteiro auxiliar, no nodo
                // que será feita alguma operação. Esse código é o mesmo
                // para os métodos update, delete, select e insert
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                ///////////////////////
                dadoAux = ponteiroAux?.dado
            } else {
                println("Indice Inválido")
            }
        } else {
            println("List empty!")
        }
        return dadoAux
    }

    override fun atualizar(posicao: Int, dado: Any?) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao< quantidade) {
                ///////////////////////
                //Código de posicionamento do ponteiro auxiliar, no nodo
                // que será feita alguma operação. Esse código é o mesmo
                // para os métodos update, delete, select e insert
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                ///////////////////////
                ponteiroAux?.dado = dado
            } else {
                println("Indice Inválido")
            }
        } else {
            println("List empty!")
        }
    }

    override fun limpar() {
        ponteiroInicio = null
        ponteiroFim = null
        quantidade = 0
    }

    override fun apagarTodos(): Array<Any?> {
        var dadosAux: Array<Any?> = selecionarTodos()
        limpar()
        return dadosAux
    }

    override fun apagar(posicao: Int): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (posicao >= 0 && posicao< quantidade) {
                ///////////////////////
                //Código de posicionamento do ponteiro auxiliar, no nodo
                // que será feita alguma operação. Esse código é o mesmo
                // para os métodos update, delete, select e insert
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                ///////////////////////
                dadoAux = ponteiroAux?.dado

                val ponteiroAnterior = ponteiroAux?.anterior
                val ponteiroProximo = ponteiroAux?.proximo

                if (ponteiroAnterior != null)
                    ponteiroAnterior.proximo = ponteiroProximo
                else //Remoção do inicio, joga o ponteiro de início para o próximo nodo.
                    ponteiroInicio = ponteiroInicio?.proximo

                if (ponteiroProximo != null)
                    ponteiroProximo.proximo = ponteiroAnterior
                else //Remoção do fim, joga o ponteiro de fim para o nodo anterior.
                    ponteiroFim = ponteiroFim?.anterior

                quantidade = quantidade.dec()
            } else {
                println("Indice Inválido")
            }
        } else {
            println("List empty!")
        }
        return dadoAux
    }

    override fun inserir(posicao: Int, dado: Any?) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao <= quantidade) {
                val noTemp = NoDuplo(dado)
                ///////////////////////
                //Código de posicionamento do ponteiro auxiliar, no nodo
                // que será feita alguma operação. Esse código é o mesmo
                // para os métodos update, delete, select e insert
                /*var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao)
                    ponteiroAux = ponteiroAux?.proximo
                ///////////////////////
                val ponteiroProximo = ponteiroAux
                val ponteiroAnterior = ponteiroFim
                if (ponteiroAux != null)
                    ponteiroAnterior = ponteiroAux.anterior*/
                var ponteiroAnterior: NoDuplo? = null
                var ponteiroProximo = ponteiroInicio

                for (i in 0 ..< posicao) {
                    ponteiroAnterior = ponteiroProximo
                    ponteiroProximo = ponteiroProximo?.proximo
                }

                //todas inserções, exceto inicio
                if (ponteiroAnterior != null)
                    ponteiroAnterior.proximo = noTemp
                else //inserção no inicio
                    ponteiroInicio = noTemp

                //todas inserções, exceto fim
                if (ponteiroProximo != null)
                    ponteiroProximo.anterior = noTemp
                else //inserção no fim
                    ponteiroFim = noTemp

                noTemp.proximo = ponteiroProximo
                noTemp.anterior = ponteiroAnterior

                quantidade = quantidade.inc()
            } else {
                println("Indice Inválido")
            }
        } else {
            println("List empty!")
        }
    }

    override fun estaCheia(): Boolean {
        return  quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun tamanho(): Int {
        return quantidade
    }

    override fun imprimir(): String {
        var ponteiroAux = ponteiroInicio
        var resultado = "["
        for (i in 0 ..< quantidade) {
            resultado += ponteiroAux?.dado
            if (i != quantidade-1)
                resultado += ", "
            ponteiroAux = ponteiroAux?.proximo
        }
        return "$resultado]"
    }
}