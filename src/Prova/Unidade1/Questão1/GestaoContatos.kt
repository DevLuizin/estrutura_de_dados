// Q1 - 00 - Lista de Contatos
interface GestaoContatos {
    
    // Inseri um novo contato na lista passando nome e o número como parâmetro.
    fun inserirContato(nome: String, numero: String): Contato

    // Remove contato da lista recebendo o nome como parâmetro.
    fun removerContato(nome: String): Contato 

    // Verifica contato existente na lista recebendo o nome como parâmetro e retornando um boolean.
    fun verificarContato(nome: String): Boolean

    // Obtém o número de contato atráves do recebimento do nome como parâmetro e retornando o mesmo.
    fun obterNumeroContato(nome: String): String?

    // Retorna um array listando todos os contatos da lista.
    fun listarContatos(): Array<Contato?>

    // Atualiza o número de contato já presente na lista.
    fun atualizarNumeroContato(novoNumero: Contato)

    // Retorna a quantidade de contatos da lista
    fun quantidadeContatos(): Int

    // Limpa a lista, apagando todos os contatos.
    fun limparTodosContatos(): Array<Contato?>

    // Verifica se lista de contatos está vazia.
    fun estaVazia(): Boolean

}