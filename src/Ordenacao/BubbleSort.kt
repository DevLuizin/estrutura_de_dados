class BubbleSort(private var dados: Array<Int>) {

    fun imprimir() {
        for (i in 0 until dados.size) {
            print(dados[i])
        }
        print("")
    }

    fun ordenar() {
        for (i in 0 until dados.size) {
            for (j in 0 until dados.size-i-1) {
                if (dados[j] > dados[j+1]) {
                    var temp = dados[j]
                    dados[j] = dados[j+1]
                    dados[j+1] = temp
                }
            }
        }
    }

    fun main() {
        val dados = arrayOf(5, 7, 2, 6, 1, 4, 5)
        val b = BubbleSort(dados)
        b.imprimir()
        b.ordenar()
        b.imprimir()
    }
}