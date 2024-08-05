package AVL

fun main() {
    // Testar entrada nesta ordem:
    // 4 2 6 1 3 5 7
    // Pre Ordem: [4,2,1,3,6,5,7]
    // Em Ordem:  [1,2,3,4,5,6,7]
    // Pos Ordem: [1,3,2,5,7,6,4]
    val arvore: Arborizavel<Int> = AVL()
    do {
        exibirMenu()
        val opcao = readLine()!!.toInt()
        when (opcao) {
            0 -> println("Saindo da ABP. Até mais!")
            1 -> {
                print("Digite o valor: ")
                val valor = readLine()!!.toInt()
                arvore.inserir(valor)
            }
            2 -> {
                print("Digite o valor: ")
                val valor = readLine()!!.toInt()
                arvore.apagar(valor)
            }
            3 -> {
                print("Digite o valor: ")
                val valor = readLine()!!.toInt()
                println(arvore.existe(valor))
            }
            4 -> {
                exibirMenuImprimir()
                val opcaoImprimir = readLine()!!.toInt()
                when (opcaoImprimir) {
                    1 -> {
                        println("")
                        println("Pre-Ordem: ${arvore.imprimirPreOrdem()}")
                        println("")
                    }
                    2 -> {
                        println("")
                        println("Em-Ordem: ${arvore.imprimirEmOrdem()}")
                        println("")
                    }
                    3 -> {
                        println("")
                        println("Pos-Ordem: ${arvore.imprimirPosOrdem()}")
                        println("")
                    }
                    else -> println("Opção inválida.")
                }
            }
            5 -> {
                arvore.limpar()
                println("Árvore Limpa!")
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 0)
}

private fun exibirMenu() {
    println("=== Árvore Binária AVL ===")
    println("0. SAIR")
    println("1. Inserir")
    println("2. Apagar")
    println("3. Existe?")
    println("4. Imprimir")
    println("5. Limpar")
    print("Escolha uma opção (0-5): ")
}

private fun exibirMenuImprimir() {
    println("1. Imprimir Pre-Ordem")
    println("2. Imprimir Em-Ordem")
    println("3. Imprimir Pos-Ordem")
    print("Escolha uma opção (1-3): ")
}
