class HeapMaxPaciente(private val tamanho: Int = 10): HeapfiablePaciente {
    
    private var dados: Array<Paciente?> = arrayOfNulls(tamanho)
    private var ponteiroFim = -1

    override fun inserir(dado: Paciente) {
        if (!estaCheia()) {
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado 
            ajustarAcima(ponteiroFim)
        } else {
            println("Fila de Prioridades Cheia!")
        }
    }

    private fun ajustarAcima(indice: Int) {
        var indiceAtual = indice 
        while (indiceAtual != 0) {
            val indicePai = indicePai(indiceAtual)
            if (dados[indicePai]!!.prioridade < dados[indiceAtual]!!.prioridade) {
                trocar(indiceAtual, indicePai)
                indiceAtual = indicePai
            } else {
                break
            }
        }
    }

    private fun indicePai(indiceFilho: Int): Int {
        return (indiceFilho-1)/2
    }

    private fun indiceFilhoEsquerdo(indicePai: Int): Int {
        return 2 * indicePai + 1
    }

    private fun indiceFilhoDireito(indicePai: Int): Int {
        return 2 * indicePai + 2
    }

    private fun ajustarAbaixo(pai: Int) {
        val filhoEsquerdo = indiceFilhoEsquerdo(pai)
        val filhoDireito = indiceFilhoDireito(pai)
        var maior = pai

        if (filhoEsquerdo <= ponteiroFim)
            if (dados[maior]!!.prioridade < dados[filhoDireito]!!.prioridade)
                maior = filhoEsquerdo

        if (filhoDireito <= ponteiroFim)
            if (dados[maior]!!.prioridade < dados[filhoDireito]!!.prioridade)
                maior = filhoDireito

        if (maior != pai) {
            trocar(pai, maior)
            ajustarAbaixo(maior)
        }
    }

    private fun trocar(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    override fun extrair(): Paciente? {
        var dadoRaiz: Paciente? = null 
        if (!estaVazia()) {
            dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarAbaixo(0)
        } else {
            println("Fila de Prioridades Vazia!")
        }
        return dadoRaiz
    }

    override fun obter(): Paciente? {
        var dadoRaiz: Paciente? = null 
        if (!estaVazia()) {
            dadoRaiz = dados[0]
        } else {
            println("Fila de Prioridades Vazia!")
        }
        return dadoRaiz
    }

    override fun atualizar(dado: Paciente) {
        if (!estaVazia()) {
            dados[0] = dado 
            ajustarAbaixo(0)
        } else {
            println("Fila de Prioridades Vazia!")
        }
    }

    override fun imprimir(): String {
        var resultado = "["
        for ( i in 0 .. ponteiroFim) {
            resultado += "${dados[i]}"
            if ( i != ponteiroFim)
                resultado += ", "
        }
        return "$resultado]"
    }

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == (dados.size-1)
    }

}