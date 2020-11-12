	.include "syscalls.h"
	.data
lista:	.word 4, 3, -2, 1, 27, 45
prompt:	.asciiz "O conteúdo do array é: \n"
sep:	.asciiz " , "
	.text
	.globl main
	
main:
	#Print prompt
	la $a0, prompt
	li $v0, print_str
	syscall
	
	li $t0, 0	# t0 = i = 0
	
	for:
		bge $t0, 6, efor
		
		sll $t1, $t0, 2		# i * 2^2
		
		lw $t2, lista($t1)	# t1 = lista[i]
		
		la $a0, ($t2)
		li $v0, print_int10
		syscall
		
		#Print sep
		la $a0, sep
		li $v0, print_str
		syscall
		
		add $t0, $t0, 1		# i++
		
		j for
		
	efor:
		#Exit program
		li $v0, exit
		syscall