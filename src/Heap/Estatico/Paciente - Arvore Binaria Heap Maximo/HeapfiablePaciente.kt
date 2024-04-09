interface HeapfiablePaciente {
    fun inserir(dado: Paciente) // Insert - C 
    fun extrair(): Paciente? // Extract - D 
    fun obter(): Paciente? // Get - R 
    fun atualizar(dado: Paciente) // Update  - U 

    fun imprimir(): String 
    fun estaVazia(): Boolean 
    fun estaCheia(): Boolean
}