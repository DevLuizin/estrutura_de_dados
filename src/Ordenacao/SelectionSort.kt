class SelectionSort(private var dados: Array<Int>) {

    fun imprimir() {
        for (i in 0 until dados.size) {
            print(dados[i])
        }
        print("")
    }

    fun ordenar() {
        for (j in 0 until dados.size) {
            var indiceMenor = j
            for (i in j+1 until dados.size) {
                if (dados[i] < dados[indiceMenor])
                    indiceMenor = i
            }
        }
        trocar(i, j)
    }

    fun trocar(i: Int, j: Int) {
        var temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    fun main() {
        val dados = arrayOf(5, 7, 2, 6, 1, 4, 5)
        val s = SelectionSort(dados)
        s.imprimir()
        s.ordenar()
        s.imprimir()
    }
}