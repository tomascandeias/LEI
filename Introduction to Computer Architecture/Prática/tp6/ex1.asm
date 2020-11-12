	.data
andPrint:	.asciiz "AND: "
orPrint:	.asciiz "OR: "
norPrint:	.asciiz "NOR: "
xorPrint:	.asciiz "XOR: "
negPrint:	.asciiz "NEG: "
enter:		.asciiz "\n"
	.text
	
main:	la $a0, andPrint	#AND
	li $v0, 4
	syscall
	
	and $t2, $t0, $t1
	li $v0, 1
	syscall
	
	la $a0, enter
	li $v0, 4
	syscall
	
	la $a0, orPrint		#OR
	li $v0, 4
	syscall
	
	or $t3, $t0, $t1
	li $v0, 1
	syscall
	
	la $a0, enter
	li $v0, 4
	syscall
	
	la $a0, norPrint	#NOR
	li $v0, 4
	syscall
	
	nor $t4, $t0, $t1
	li $v0, 1
	syscall
	
	la $a0, enter
	li $v0, 4
	syscall
	
	la $a0, xorPrint	#XOR
	li $v0, 4
	syscall
	
	xor $t5, $t0, $t1
	li $v0, 1
	syscall
	
	la $a0, enter
	li $v0, 4
	syscall
	
	la $a0, negPrint	#NEG
	li $v0, 4
	syscall
	
	neg $t6, $t0
	li $v0, 1
	syscall
	
	
	
	li $v0, 10
	syscall