// Questão 1 - 03 - Controle de Tarefas
import java.time.LocalDateTime

interface ControleTarefas {

    // Insere uma nova tarefa, recebendo indice, nome e horário como parâmetro. 
    fun adicionarTarefa(indice: Int, nome: String, horario: LocalDateTime): Tarefa

    // Remove tarefa recebendo o índice como parâmetro. 
    fun removerTarefa(indice: Int): Tarefa?

    // Marca tarefa como concluída, rebecendo o índice como parâmetro. 
    fun marcarTarefaConcluida(indice: Int): Boolean

    // Retorna tarefa da lista, recebendo o indice como parâmetro. 
    fun obterTarefa(indice: Int): Tarefa?

    // Lista todas as tarefa na lista através de um array. 
    fun listarTarefas(): Array<Tarefa?>

    // Conta o número total de tarefas na lista. 
    fun numeroTotalTarefas(): Int

    // Limpa a lista, apagando todas as tarefas. 
    fun limparTarefas(): Array<Tarefa?>

    // Verifica se a lista de tarefas está vazia, retornando um boolean. 
    fun listaVazia(): Boolean
}