class ArvoreBinariaHeapMax(tamanho: Int = 10): Amontoavel {

    private var dados = IntArray(tamanho){0}
    private var ponteiroFim = -1


    override fun inserir(dado: Int) {
        if (!estaCheia()) {
            ponteiroFim++ //ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap is full!")
        }
    }

    private fun ajustarAcima(indice: Int) {
        var indiceAux = indice
        while (indiceAux != 0) {
            var pai = indicePai(indiceAux)
            var filho = indiceAux
            if (dados[pai] < dados[filho]) {
                troca(pai, filho)
                indiceAux = pai
            } else {
                break
            }
        }
    }

    override fun extrair(): Int {
        var raiz = 0
        if (!estaVazia()) {
            // Retorno o que está na raiz
            // Último dado inserido que está em PonteiroFim
            // Coloco na raiz
            // Ajustar abaixo
            raiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarAbaixo(0)
        } else {
            println("Heap is empty!")
        }
        return raiz
    }

    private fun ajustarAbaixo(pai: Int) {
        var filhoEsquerdo = indiceFilhoEsquerdo(pai)
        var filhoDireito = indiceFilhoDireito(pai)
        var menor = pai

        if (filhoEsquerdo <= ponteiroFim){
            if (dados[menor] < dados[filhoEsquerdo]) {
                menor = filhoEsquerdo
            }
        }

        if (filhoDireito <= ponteiroFim) {
            if (dados[menor] < dados[filhoDireito]) {
                menor = filhoDireito
            }
        }

        if (menor != pai) {
            troca(menor, pai)
            ajustarAbaixo(menor)
        }
    }

    override fun obter(): Int {
        var raiz = -1
        if (!estaVazia()) {
            raiz = dados[0]
        } else
            println("Heap is empty!")
        return raiz
    }

    override  fun atualizar(dado: Int) {
        if (!estaVazia()) {
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            println("Heap is empty!")
        }
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == (dados.size-1)
    }

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    override  fun imprimir(): String {
        var resultado = "["
        for (i in 0 .. ponteiroFim) {
            resultado += "${dados[i]}"
            if (i != ponteiroFim)
                resultado += ", "
        }

        return "$resultado]"
    }

    private fun troca(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    private fun indicePai(indiceFilho: Int): Int {
        return (indiceFilho-1)/2
    }

    private fun indiceFilhoEsquerdo(indicePai: Int): Int {
        return indicePai * 2 + 1
    }

    private fun indiceFilhoDireito(indicePai: Int): Int {
        return  indicePai * 2 + 2
    }
}