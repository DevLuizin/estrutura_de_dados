// Questão 1 - 04 - Controle de Encomendas

interface ControleEncomendas {

    // Insere uma nova encomenda, recebendo numero, descrição e peso como parâmetro. 
    fun adicionarEncomenda(numero: Int, descricao: String, peso: Double): Encomenda

    // Remove encomenda recebendo o numero como parâmetro. 
    fun removerEncomenda(numero: Int): Encomenda?

    // Verifca se encomenda está no sistema, rebecendo o número como parâmetro. 
    fun verificarEncomenda(numero: Int): Boolean

    // Retorna descrição de encomenda, recebendo o número como parâmetro. 
    fun obterDescricaoEncomenda(numero: Int): Encomenda?

    // Lista todas as encomendas no sistema através de um array. 
    fun listarEncomendas(): Array<Encomenda?>

    // Conta o número total de encomendas no sistema. 
    fun numeroTotalEncomendas(): Int

    // Limpa o sistema, apagando todas as encomendas. 
    fun limparEncomendas(): Array<Encomenda?>

    // Verifica se o sistema está vazio, retornando um boolean. 
    fun sistemaVazio(): Boolean
}