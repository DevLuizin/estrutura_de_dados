// Questão 1 - 05 (Versão 2) - Controle de Itens em um Catalogo de Produtos

interface ListaProdutos2 {

    // Adiciona um novo produto ao catálogo de produtos recebendo nome, preço e quantidade de produtos como parâmetro.
    fun adicionarProduto(nome: String, preco: Double, qtdEstoque: Int): Produto

    // Remove produto recebendo o nome como parâmetro e retornando o mesmo.
    fun removerProduto(nome: String): Produto?

    // Verifica se o produto está no catálogo.
    fun verificaProduto(nome: String): Boolean

    // Obtém o preço de um produto com base no nome. 
    fun obterPrecoProduto(nome: String): Double?

    // Retorna quantidade de um produto no estoque, recebendo o mesmo como parâmetro. 
    fun obterQtdEstoqueProduto(produto: Produto): Int?

    // Listar todos os produtos do catálogo. 
    fun listaProdutos(): Array<Produto?>

    // Contagem de todos os produtos do catálogo
    fun QtdTotalProdutos(): Int

    // Limpa o catálogo, excluindo todos os produtos. 
    fun limparCatalogo(): Array<Produto?>

    // Verifica se o catálogo está vazio. 
    fun catalogoVazio(): Boolean
}