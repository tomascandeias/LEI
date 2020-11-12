.data
intro:	.asciiz "Introduza dois números :\n"
result:	.asciiz "A soma dos números é: "

.text
.globl main
main:	la $a0, intro
	li $v0, 4
	syscall
	
	li $v0, 5
	syscall
	move $t0, $v0	# t0 = read_int()
	
	li $v0, 5
	syscall
	move $t1, $v0	# t0 = v0 = read_int()
	
	la $a0, result
	li $v0, 4
	syscall
	
	add $a0, $t1, $t0
	li $v0, 1
	syscall
	
	li $v0, 10
	syscall