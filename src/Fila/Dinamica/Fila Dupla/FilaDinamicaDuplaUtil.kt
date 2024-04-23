fun main() {
    var fila: EnfileiravelDupla = FilaDinamicaDupla()
	fila.enfileirarInicio("A")
	println(fila.imprimirFrenteParaTras()) //[A]
	println(fila.tras()) //A
	println(fila.frente()) //A	
	fila.enfileirarInicio("B")
	fila.desenfileirarFim()
    fila.enfileirarFim("c")
	fila.atualizarFim("C")
	fila.desenfileirarInicio()
	fila.enfileirarInicio("D") 
	println(fila.imprimirFrenteParaTras()) //[D,C]
	fila.frente()
	fila.desenfileirarFim()
	println(fila.imprimirFrenteParaTras())
	println(fila.tras()) //D    
	fila.enfileirarInicio("e")
	fila.atualizarInicio("E")    
	println(fila.imprimirFrenteParaTras())//[E,D]
	fila.enfileirarFim("F")
	fila.desenfileirarInicio()
	fila.enfileirarFim("G")
	println(fila.tras()) //G
	fila.enfileirarInicio("H")
	fila.desenfileirarFim()
	fila.enfileirarFim("I")
	println(fila.imprimirTrasParaFrente()) //[I,F,D,H]
	fila.enfileirarInicio("J")
	fila.enfileirarFim("K")
	fila.enfileirarFim("L")
	println(fila.frente()) //J
	fila.desenfileirarInicio()
	println(fila.imprimirTrasParaFrente()) //[H,D,F,I,K,L]
}