// Questão 1 - 02 - Registro de Pacientes
interface RegistroPacientes {

    //Adiciona um novo registro de paciente, recebendo nome, idade, sexo, e endereço como parâmetro. 
    fun adicionarPaciente(nome: String, idade: Int, sexo: String, endereco: String): Paciente 

    // Remove o registro de um paciente do sistema, recebendo o nome como parâmetro. 
    fun removerPaciente(nome: String): Paciente?

    // Verifica se há registro do paciente no sistema, recebendo o nome como parâmetro, retornando um boolean. 
    fun verificarRegistro(nome: String): Boolean 

    // Retorna idade do paciente, recebendo o nome como parâmetro.
    fun obterIdadePaciente(nome: String): Int?

    // Retorna sexo do paciente, recebendo o nome como parâmetro.
    fun obterSexoPaciente(nome: String): String?

    // Retorna endereço do paciente, recebendo o nome como parâmetro.
    fun obterEnderecoPaciente(nome: String): String?

    // Lista todos os registros de paciente através de um array. 
    fun listarRegistros(): Array<Paciente?>

    // Retorna o numero total de registros no sistema. 
    fun numeroTotalRegistros(): Int

    // Limpa todos os registros do sistema. 
    fun limparRegistros(): Array<Paciente?>

    // Verifica se o sistema está vazio, ou seja, sem registros de pacientes. 
    fun sistemaVazio(): Boolean

}