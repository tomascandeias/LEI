	.include "syscalls.h"
	.data
str:		.space 40
prompt1:	.asciiz "Introduza uma string\n"
result:		.asciiz "O número de caracteres numéricos: "
	.text
	.globl main
	
main:	
	#Print prompt1
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	la $a0, str	#read_str(str, 40)
	li $a1, 40
	li $v0, read_str
	syscall
	
	li $t0, 0	# t0 = i = 0
	li $t1, 0	# t1 = n = 0
	
	for:
		lb $t2, str($t0)

		beq $t2, '\0', efor
		blt $t2, '0', noIf
		bgt $t2, '9', noIf
		
		add $t1, $t1, 1	# n++
		
	noIf:
		add $t0, $t0, 1	# i++	
		j for
		
	efor:
		#Print result
		la $a0, result
		li $v0, print_str
		syscall
		
		#Print n
		la $a0, ($t1)
		li $v0, print_int10
		syscall
		
		#Exit program
		li $v0, exit
		syscall
	
