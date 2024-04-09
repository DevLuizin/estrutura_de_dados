// Heap - Monte
// Heapify - Organizar dados na forma de um  Heap
// Heapifiable - Amontoavel
interface Amontoavel {
    fun inserir(dado: Int) // Insert C
    fun extrair(): Int // Extract    D
    fun obter(): Int // Get          R
    fun atualizar(dado: Int) // Update U

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String

    // private fun indicePai(filho: Int): Int
    // private fun trocar(i: Int, j: Int) // Swap
    // private fun indicePai(filho: Int): Int
    // private fun indiceFilhoEsquerdo(indicePai: Int): Int
    // private fun indiceFilhoDireito(indicePai: Int): Int
    // private fun ajustarAbaixo(pai: Int) 	// HeapifyDown
	// private fun ajustarAcima(indice: Int) // HeapifyUp
}