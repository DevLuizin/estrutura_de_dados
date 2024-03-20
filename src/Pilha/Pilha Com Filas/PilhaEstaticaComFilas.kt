package Pilha.`Pilha Com Filas`

class PilhaEstaticaComFilas(val tamanho: Int = 10) : Empilhavel {
    private var fila1: Enfileiravel = FilaEstaticaCircular(tamanho)
    private var fila2: Enfileiravel = FilaEstaticaCircular(tamanho)

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            //joga todo mundo pra fila 2
            while(!fila1.estaVazia())
                fila2.enfileirar(fila1.desenfileirar())

            //Enfileira o dado
            fila1.enfileirar(dado)
            //enfileira os dados pré-existentes
            while (!fila2.estaVazia())
                fila1.enfileirar(fila2.desenfileirar())
        } else {
            println("Stack is full!")
        }
    }

    override fun desempilhar(): Any? {
        return fila1.desenfileirar()
    }

    override fun atualizar(dado: Any?) {
       return fila1.atualizar(dado)
    }

    override fun espiar(): Any? {
       return fila1.frente()
    }

    override fun estaCheia(): Boolean {
        return fila1.estaCheia()
    }

    override fun estaVazia(): Boolean {
        return fila1.estaVazia()
    }

    override fun imprimir(): String {
        return fila1.imprimir()
    }

}