class ABP: Arborizavel {
    
    private var raiz: NoTriplo? = null

    override fun getRaiz(): NoTriplo? {
        return raiz
    }

    override fun limpar() {
        raiz = null
    }

    //inserir
    override fun inserir(dado: Any?) {
        val novoNo = NoTriplo(dado)
        //novoNo.dado = dado

        if (raiz == null) {
            raiz = novoNo
        } else {
            var noAux = raiz
            while (noAux != null) {
                if((noAux.dado as Int) > (dado as Int)) {
                    //preciso ir para a esquerda
                    if (noAux.esquerda != null) {
                        noAux = noAux.esquerda
                    } else {
                        //Insiro o dado aqui
                        noAux.esquerda = novoNo
                        novoNo.genitor = noAux
                        break
                    }
                } else {
                    //preciso ir para a direita
                    if (noAux.direita != null) {
                        noAux = noAux.direita
                    } else {
                        //Insiro o dado aqui
                        noAux.direita = novoNo
                        novoNo.genitor = noAux
                        break
                    }
                }
            }
        }
    }

    override fun apagar(dado: Any?): Boolean {
        return false
    }

    override fun buscar(dado: Any?): NoTriplo? {
        return null
    }

    override fun existe(dado: Any?): Boolean {
        return false
    }

    //imprimir
    override fun imprimirPreOrdem(): String {
        return formataSaida(imprimirPreOrdemRec(raiz))
    }

    override fun imprimirEmOrdem(): String {
        return formataSaida(imprimirEmOrdemRec(raiz))
    }

    override fun imprimirPosOrdem(): String {
        return formataSaida(imprimirPosOrdemRec(raiz))
    }

    private fun imprimirPreOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${raiz.dado} ${imprimirPreOrdemRec(raiz.esquerda)} ${imprimirPreOrdemRec(raiz.direita)}"
        return resultado
    }

    private fun imprimirEmOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${imprimirEmOrdemRec(raiz.esquerda)} ${raiz.dado} ${imprimirEmOrdemRec(raiz.direita)}"
        return resultado
    }

    private fun imprimirPosOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${imprimirPosOrdemRec(raiz.esquerda)} ${imprimirPosOrdemRec(raiz.direita)} ${raiz.dado}"
        return resultado
    }

    private fun formataSaida(msg: String): String {
        var resultado: String
        var mensagem = msg
        do {
            resultado = mensagem
            mensagem = mensagem.replace(" ", " ")// remove excesso de espaços
        } while (mensagem != resultado)
        mensagem = mensagem.trim() //remove espaços em branco no ínicio e fim, se existir
        mensagem = mensagem.replace(" ", ",")
        return "[$mensagem]"
    }

}