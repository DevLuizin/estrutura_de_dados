class PilhaDinamica(private val tamanho: Int = 10) : Empilhavel {

	private var ponteiroTopo: NoDuplo? = null
	private var quantidade = 0

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun empilhar(dado: Any?) {
		if (!estaCheia()) {
			var noTemp: NoDuplo? = NoDuplo(dado)
			//noTemp?.dado = dado
			noTemp?.anterior = ponteiroTopo
			if (!estaVazia())
				ponteiroTopo?.proximo = noTemp
			
			ponteiroTopo = noTemp
			quantidade = quantidade.inc()
		} else {
			println("Stack is full!")
		}
	}
	
	override fun desempilhar(): Any? {
		var dadoTopo: Any? = null
		if (!estaVazia()) {
			dadoTopo = ponteiroTopo?.dado
			ponteiroTopo = ponteiroTopo?.anterior
			quantidade = quantidade.dec()
			if (!estaVazia())
				ponteiroTopo?.proximo = null
				
		} else {
			println("Stack is empty!")
		}
		
		return dadoTopo
	}

    override fun espiar(): Any? {
		var dadoTopo: Any? = null
		if (!estaVazia())
			dadoTopo = ponteiroTopo?.dado
		else
			println("Pilha Vazia!")

		return dadoTopo
	}
	
	override fun atualizar(dado: Any?) {
		if (!estaVazia())
			ponteiroTopo?.dado = dado
		else
			println("Pilha Vazia!")
	}

    override fun imprimir(): String {
		var ponteiroAuxiliar = ponteiroTopo
		var resultado = "["
		for (i in 0 until quantidade) {
			resultado += "${ponteiroAuxiliar?.dado}"
			if (i != quantidade-1)
				resultado += ","
			
			ponteiroAuxiliar = ponteiroAuxiliar?.anterior
		}
		return "$resultado]"
	}
}