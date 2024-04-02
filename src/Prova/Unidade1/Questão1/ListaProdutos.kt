// Questão 1 - 05 - Controle de Itens em um Catalogo de Produtos

interface ListaProdutos {

    //Recebe a Posição Desejada e o Produto como Parâmetro e Insere esse Produto na Lista na Determinada Posição
    fun inserirProduto(posicao: Int, produto: Produto)

    // Recebe a Posição e o Produto como Parâmetro e Atualiza o Produto Específico na Lista
    fun atualizarProduto(posicao: Int, produto: Produto) 

    // Recebe o Produto como Parâmetro e Anexa um Produto ao Fim da Lista
    fun anexarProduto(produto: Produto)

    // Remove um Produto de Determinada Posição e Retorna o Mesmo
    fun removerProduto(posicao: Int): Produto?

    // Seleciona Produto de Posição Informada no Parâmetro e Retorna o Mesmo
    fun selecionarProduto(posicao: Int): Produto?

    // Exibe um Array com Todos os Produtos do Catálogo
    fun selecionarTodosProdutos(): Array<Produto?>

    // Retorna um Boolean que Verifica se Todas as Posições da Lista Estão Ocupadas
    fun catalagoEstaCheio(): Boolean

    // Retorna um Boolean que Verifica se a Lista está Vazia
    fun catalogoEstaVazio(): Boolean 

    // Retorna uma String com Todos os Produtos da Lista
    fun imprimirCatalogo(): String?

}