package AVL

class AVL<T> : Arborizavel<T> {

    private var raiz: NoTriplo<T>? = null

    override fun getRaiz(): NoTriplo<T>? {
        return raiz
    }

    override fun limpar() {
        raiz = null
    }

    // Métodos AVL
    private fun balanceamento(nodo: NoTriplo<T>?): Int {
        // se um noFolha tem altura zero, então 
        // a ausência de nó (null), tem altura -1
        val alturaEsquerda = nodo?.esquerda?.altura ?: -1
        val alturaDireita = nodo?.direita?.altura ?: -1

        return alturaEsquerda - alturaDireita
    }

    private fun atualizaAltura(nodo: NoTriplo<T>?) {
        // se um noFolha tem altura zero, então
        // a ausência de nó (null), tem altura -1        
        val alturaEsquerda = nodo?.esquerda?.altura ?: -1
        val alturaDireita = nodo?.direita?.altura ?: -1
        // noFolha tem altura zero = 1 + (-1)
        nodo?.altura = 1 + maxOf(alturaEsquerda, alturaDireita)
    }

    // Método para rotacionar à direita ao redor de um nó
    private fun rotacaoDireita(y: NoTriplo<T>?): NoTriplo<T>? {
        //           T0     |           T0
        //           |      |           | 
        //  ANTES    y      |   DEPOIS  x
        //          / \     |          / \
        //         x  T3    |         T1  y
        //        / \	    |            / \
        //       T1  T2     |           T2 T3
        // T1 e T3 não sofrem alteração, 
        // por isso não aparecem no balanceamento
        val T0 = y?.genitor
        val x = y?.esquerda
        val T2 = x?.direita

        // corrige ponteiros, descendo e subindo
        // [T0-->x], [T0<--x]
        if (T0 != null) {
            if (y == T0.esquerda) T0.esquerda = x else T0.direita = x
        }

        x?.genitor = T0

        // [x-->y], [x<--y]
        x?.direita = y
        y?.genitor = x

        // [y-->T2], [y<--T2]
        y?.esquerda = T2
        T2?.genitor = y

        atualizaAltura(y)
        atualizaAltura(x)
        // nova raiz é x
        return x
    }

    // rotacionar à esquerda ao redor de um nó
    private fun rotacaoEsquerda(y: NoTriplo<T>?): NoTriplo<T>? {
        //         T0       |             T0
        //         |        |             | 
        //  ANTES  y        |   DEPOIS    x
        //        / \       |            / \
        //       T3  x      |           y  T1
        //          / \     |          / \  
        //         T2  T1   |         T3  T2
        // T1 e T3 não sofrem alteração, 
        // por isso não aparecem no balanceamento
        val T0 = y?.genitor
        val x = y?.direita
        val T2 = x?.esquerda

        // corrige ponteiros, descendo e subindo
        // [T0-->x], [T0<--x]
        if (T0 != null) {
            if (y == T0.esquerda) T0.esquerda = x else T0.direita = x
        }

        x?.genitor = T0

        // [x-->y], [x<--y]
        x?.esquerda = y
        y?.genitor = x

        // [y-->T2], [y<--T2]
        y?.direita = T2
        T2?.genitor = y

        // Atualiza as alturas
        atualizaAltura(y)
        atualizaAltura(x)
        // Retorna a nova raiz
        return x
    }

    // rebalancear a árvore após inserção ou remoção
    private fun rebalancear(dado: T, noAuxiliar: NoTriplo<T>?) {
        var nodo = noAuxiliar
        while (nodo != null) {

            atualizaAltura(nodo)
            val desnivel = balanceamento(nodo)

            // Caso 1: Rotação à direita
            if (desnivel > 1 && (dado as Int) < (nodo.esquerda?.dado as Int)) {
                nodo = rotacaoDireita(nodo)
            }
            // Caso 2: Rotação à esquerda
            else if (desnivel < -1 && (dado as Int) > (nodo.direita?.dado as Int)) {
                nodo = rotacaoEsquerda(nodo)
            }
            // Caso 3: Rotação dupla a direita
            // Rotação à esquerda-direita
            else if (desnivel > 1 && (dado as Int) > (nodo.esquerda?.dado as Int)) {
                nodo.esquerda = rotacaoEsquerda(nodo.esquerda)
                nodo = rotacaoDireita(nodo)
            }
            // Caso 4: Rotação dupla a esquerda
            // Rotação à direita-esquerda
            else if (desnivel < -1 && (dado as Int) < (nodo.direita?.dado as Int)) {
                nodo.direita = rotacaoDireita(nodo.direita)
                nodo = rotacaoEsquerda(nodo)
            }

            nodo.genitor?.let { genitor ->
                if (nodo == genitor.esquerda) {
                    genitor.esquerda = nodo
                } else {
                    genitor.direita = nodo
                }
            } ?: run {
                raiz = nodo
            }

            nodo = nodo.genitor
        }
    }

    // inserir
    override fun inserir(dado: T) {
        val novoNo = NoTriplo<T>()
        novoNo.dado = dado
        if (raiz == null) {
            raiz = novoNo
        } else {
            var noAuxiliar = raiz
            while (noAuxiliar != null) {
                if ((dado as Int) < (noAuxiliar.dado as Int)) {
                    // preciso ir para a esquerda
                    if (noAuxiliar.esquerda != null) {
                        noAuxiliar = noAuxiliar.esquerda
                    } else {
                        // insiro o dado aqui
                        noAuxiliar.esquerda = novoNo
                        novoNo.genitor = noAuxiliar
                        break
                    }
                } else {
                    // preciso ir para a direita
                    if (noAuxiliar.direita != null) {
                        noAuxiliar = noAuxiliar.direita
                    } else {
                        // insiro o dado aqui
                        noAuxiliar.direita = novoNo
                        novoNo.genitor = noAuxiliar
                        break
                    }
                }
            }
            // rebalancear árvore
            rebalancear(dado, novoNo)
        }
    }

    // apagar
    override fun apagar(dado: T): T? {
        val noAuxiliar = buscar(dado)
        // Nó não encontrado na árvore
        noAuxiliar ?: return null

        // Caso 1: Nó sem filhos
        if (noAuxiliar.esquerda == null && noAuxiliar.direita == null) {
            apagarNoFolha(noAuxiliar)
        }
        // Caso 2: Nó com um filho
        else if (noAuxiliar.esquerda == null || noAuxiliar.direita == null) {
            apagarComUmFilho(noAuxiliar)
        }
        // Caso 3: Nó com dois filhos
        else {
            apagarComDoisFilhos(noAuxiliar)
        }

        // rebalancear árvore
        rebalancear(dado, noAuxiliar)

        return dado
    }

    private fun buscar(dado: T): NoTriplo<T>? {
        var noAuxiliar = raiz
        while (noAuxiliar != null) {
            if (dado == noAuxiliar.dado) {
                return noAuxiliar
            } else {
                noAuxiliar = if ((dado as Int) < (noAuxiliar.dado as Int)) {
                    noAuxiliar.esquerda
                } else {
                    noAuxiliar.direita
                }
            }
        }
        return null
    }

    private fun apagarNoFolha(nodo: NoTriplo<T>) {
        val pai = nodo.genitor
        if (pai == null) {
            raiz = null
        } else {
            if (nodo == pai.esquerda) {
                // nodo é filho da esquerda
                pai.esquerda = null
            } else {
                // nodo é filho da direita        
                pai.direita = null
            }

            nodo.genitor = null
        }
    }

    private fun apagarComUmFilho(nodo: NoTriplo<T>) {
        val pai = nodo.genitor
        val filho = nodo.esquerda ?: nodo.direita

        if (pai == null) {
            raiz = filho
        } else {
            if (nodo == pai.esquerda) {
                // nodo é filho da esquerda
                pai.esquerda = filho
            } else {
                // nodo é filho da direita        
                pai.direita = filho
            }

            filho?.genitor = pai
        }
        nodo.esquerda = null
        nodo.direita = null
        nodo.genitor = null
    }

    private fun apagarComDoisFilhos(nodo: NoTriplo<T>) {
        // encontra o sucessor in-ordem
        var sucessor = nodo.direita
        while (sucessor?.esquerda != null) {
            sucessor = sucessor.esquerda
        }
        // copia o dado do sucessor para o nodo a ser removido
        nodo.dado = sucessor?.dado
        // remove o sucessor
        if (sucessor?.genitor == nodo) {
            // sucessor é filho direto do nodo
            if (sucessor.direita != null) {
                nodo.direita = sucessor.direita
                sucessor.direita?.genitor = nodo
            } else {
                nodo.direita = null
            }
        } else {
            sucessor?.genitor?.esquerda = sucessor?.direita
            sucessor?.direita?.genitor = sucessor?.genitor
        }
    }

    private fun encontraMenorDireita(nodo: NoTriplo<T>?): NoTriplo<T>? {
        var sucessor = nodo?.direita
        while (sucessor?.esquerda != null) {
            sucessor = sucessor.esquerda
        }
        return sucessor
    }
    
    private fun encontraMaiorEsquerda(nodo: NoTriplo<T>?): NoTriplo<T>? {
        var sucessor = nodo?.esquerda
        while (sucessor?.direita != null) {
            sucessor = sucessor.direita
        }
        return sucessor
    }
    
    // existe
    override fun existe(dado: T): Boolean {
        var retorno = false
        var noAuxiliar = raiz
        while (noAuxiliar != null) {
            if (dado == noAuxiliar.dado) {
                retorno = true
                break
            } else {
                noAuxiliar = if ((dado as Int) < (noAuxiliar.dado as Int)) {
                    noAuxiliar.esquerda
                } else {
                    noAuxiliar.direita
                }
            }
        }
        return retorno
    }
    
    // imprimir
    override fun imprimirPreOrdem(): String {
        return formataSaida(imprimirPreOrdemRec(raiz))
    }
    
    override fun imprimirEmOrdem(): String {
        return formataSaida(imprimirEmOrdemRec(raiz))
    }
    
    override fun imprimirPosOrdem(): String {
        return formataSaida(imprimirPosOrdemRec(raiz))
    }
    
    private fun imprimirPreOrdemRec(raiz: NoTriplo<T>?): String {
        var resultado = ""
        if (raiz != null) {
            resultado = "${raiz.dado} ${imprimirPreOrdemRec(raiz.esquerda)} ${imprimirPreOrdemRec(raiz.direita)}"
        }
        return resultado
    }
    
    private fun imprimirEmOrdemRec(raiz: NoTriplo<T>?): String {
        var resultado = ""
        if (raiz != null) {
            resultado = "${imprimirEmOrdemRec(raiz.esquerda)} ${raiz.dado} ${imprimirEmOrdemRec(raiz.direita)}"
        }
        return resultado
    }
    
    private fun imprimirPosOrdemRec(raiz: NoTriplo<T>?): String {
        var resultado = ""
        if (raiz != null) {
            resultado = "${imprimirPosOrdemRec(raiz.esquerda)} ${imprimirPosOrdemRec(raiz.direita)} ${raiz.dado}"
        }
        return resultado
    }
    
    private fun formataSaida(msg: String): String {
        var resultado: String
        var novaMsg = msg
        do {
            resultado = novaMsg
            novaMsg = novaMsg.replace("  ", " ") // remove excesso de espaços
        } while (novaMsg != resultado)
        novaMsg = novaMsg.trim() // remove espaços em branco do início e fim, se existir
        novaMsg = novaMsg.replace(" ", ",") // troca espaço por vírgula
        return "[$novaMsg]"
    }
    
}
