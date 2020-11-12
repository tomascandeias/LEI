	.data
breakline:	.asciiz "\n"
	.text
	.globl main

main:	li $t1, 0xF000000
	li $t0, 28
	
while:	beq $t0, $0 , done	# if t0 = 0 -> done()
	srl $t1, $t1, 4		# t1 = desloca o t1 4 casas para a direita e 0s à esquerda (t1*2^4)
	subi $t0, $t0, 4	# t0 = desloca o t0 4 casas para a direita e 0s à esquerda (t0*2^4)
	move $a0, $t1		# a0 = t1
	
	li $v0, 1
	syscall
	
	la $a0, breakline
	li $v0, 4
	syscall

	j while		#jump para while() -> loop

done:	li $v0, 10
	syscall