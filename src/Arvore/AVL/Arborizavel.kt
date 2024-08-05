package AVL

interface Arborizavel<T> {
    val raiz: NoTriplo<T>?
    fun inserir(dado: T?)
    fun apagar(dado: T?): T?
    fun existe(dado: T): Boolean
    fun limpar()
    fun imprimirPreOrdem(): String
    fun imprimirEmOrdem(): String
    fun imprimirPosOrdem(): String
}
