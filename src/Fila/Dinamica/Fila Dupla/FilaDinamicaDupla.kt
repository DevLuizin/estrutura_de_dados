class FilaDinamicaDupla(private val tamanho: Int = 10) : EnfileiravelDupla {
    
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun enfileirarInicio(dado: Any?) {
        if (!estaCheia()) {
            var noTemp = NoDuplo(dado)
            //noTemp.dado = dado
            noTemp.proximo = ponteiroFim
            if (!estaVazia())
                ponteiroFim?.anterior = noTemp
            else
                ponteiroFim = noTemp
            ponteiroInicio = noTemp
            quantidade = quantidade.inc()
        } else {
            println("Queue is full!")
        }
    }

    override fun enfileirarFim(dado: Any?) {
        if (!estaCheia()) {
            var noTemp = NoDuplo(dado)
            //noTemp.dado = dado
            noTemp.anterior = ponteiroFim
            if (!estaVazia())
                ponteiroFim?.proximo = noTemp
            else
                ponteiroInicio = noTemp
            ponteiroFim = noTemp
            quantidade = quantidade.inc()
        } else {
            println("Queue is full!")
        }
    }

    override fun desenfileirarInicio(): Any? {
        var dadoAux: Any? = null 
        if (!estaVazia()) {
            dadoAux = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
            quantidade = quantidade.dec()
            if (!estaVazia())
                ponteiroInicio?.anterior = null 
            else
                 ponteiroFim = null
        } else {
            println("Queue is empty!")
        }
        return dadoAux
    }

    override fun desenfileirarFim(): Any? {
        var dadoAux: Any? = null 
        if (!estaVazia()) {
            dadoAux = ponteiroFim?.dado
            ponteiroFim = ponteiroFim?.proximo
            quantidade = quantidade.dec()
            if (!estaVazia())
                ponteiroFim?.anterior = null 
            else
                 ponteiroInicio = null
        } else {
            println("Queue is empty!")
        }
        return dadoAux
    }

    override fun atualizarInicio(dado: Any?) { 
        if (!estaVazia()) {
            ponteiroInicio?.dado = dado
        } else {
            println("Queue is empty!")
        }
    }

    override fun atualizarFim(dado: Any?) { 
        if (!estaVazia()) {
            ponteiroFim?.dado = dado
        } else {
            println("Queue is empty!")
        }
    }

    override fun frente(): Any? {
        var dadoAux: Any? = null 
        if (!estaVazia()) {
            dadoAux = ponteiroInicio?.dado
        } else {
            println("Queue is empty!")
        }
        return dadoAux
    }

    override fun tras(): Any? {
        var dadoAux: Any? = null 
        if (!estaVazia()) {
            dadoAux = ponteiroFim?.dado
        } else {
            println("Queue is empty!")
        }
        return dadoAux
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimirFrenteParaTras(): String {
        var ponteiroAuxiliar = ponteiroInicio
        var resultado = "["
        for (i in 0 ..< quantidade) {
            resultado += "${ponteiroAuxiliar?.dado}"
            if (i != quantidade-1)
                resultado += ", "
            ponteiroAuxiliar = ponteiroAuxiliar?.proximo
        }
        return "$resultado]"
    }

    override fun imprimirTrasParaFrente(): String {
        var ponteiroAuxiliar = ponteiroFim
        var resultado = "["
        for (i in 0 ..< quantidade) {
            resultado += "${ponteiroAuxiliar?.dado}"
            if (i != quantidade-1)
                resultado += ", "
            ponteiroAuxiliar = ponteiroAuxiliar?.anterior
        }
        return "$resultado]"
    }
}