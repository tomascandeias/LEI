.data
.text
.globl main

main:	li $t0, 0x12345678
	
	sll $t1, $t0, 1	# t1 = desloca-se t0  4 casas para a esquerda e preenche com 0s os bits à direita (t0*2^4)
	
	srl $t2, $t0, 1	# t2 = desloca-se t0 3 casas para a direita e preenche com 0s os bits à esquerda (t0*2^-3)
	
	sra $t3, $t0, 1	# t3 = igual ao SRL mas mantêm o sinal
	
