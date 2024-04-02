// Questão 1 - 01 - Lista de um Carrinho de Compras
interface CarrinhoCompras {

    // Adiciona produto ao carrinho de compras recebendo nome, quantidade e preço unitário como parâmetro. 
    fun adicionarProduto(nome: String, quantidade: Int, precoUnitário: Double): Produto

    // Remove produto da lista recebendo o nome como parâmetro. 
    fun removerProduto(nome: String): Produto?

    // Verifica se o produto está lista e retorna um boolean como resposta. 
    fun verificarProduto(nome: String): Boolean

    // Verifica a quantidade de um produto no carrinho de compras recebendo o nome como parâmetro. 
    fun obterQtdProduto(nome: String): Int

    // Lista todos os produtos do carrinho de compras. 
    fun listarProdutos(): Array<Produto?>

    // Calcula valor total do carrinho. 
    fun calcularPrecoTotal(): Double

    // Limpa o carrinho, removendo todos os produtos
    fun limparCarrinho(): Array<Produto?>

    // Verfica se o carrinho de compras está vazio, retornando um boolean. 
    fun carrinhoVazio(): Boolean
}