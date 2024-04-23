fun main() {
    var fila: Enfileiravel = FilaDinamica(7)
    do {
        exibirMenu()
        print("Escolha uma opção (0-5): ")
        val opcao = readLine()!!.toInt()

        when(opcao) {
            0 -> {
                print("Saindo da Fila.")
                print("Até mais!")
            }
            1 -> {
                print("Digite o valor: ")
                val valor = readLine()
                fila.enfileirar(valor)
            }
            2 -> {
                print("Deseja desenfileirar [s/n]?")
                val confirmacao = readLine() ?: "n"
                if (confirmacao == "s" || confirmacao == "S")
                    fila.desenfileirar()
            }
            3 -> println("Frente: ${fila.frente()}")
            4 -> {
                print("Digite o valor")
                val valor = readLine()
                fila.atualizar(valor)
            }
            5 -> println(fila.imprimir())
            else -> {
                print("Opção inválida!")
                print("Por favor, tente novamente.")
            }
        }
    } while (opcao != 0)

    fun exibirMenu() {
        println("******************************************** Fila Dinãmica ********************************************")
        println("0. Sair")
        println("1. Enfileirar")
        println("2. Desenfileirar")
        println("3. Frente")
        println("4. Atualizar")
        println("5. Imprimir")
    }
}