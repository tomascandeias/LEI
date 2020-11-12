	.include "syscalls.h"
	.data
lista:		.space 24	# 6 numeros inteiros cada um ocupa 4 bytes
prompt1:	.asciiz "Insira 6 numeros:\n"
sep:		.asciiz " , "
	.text
	.globl main
	
main:
	#Print prompt
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	li $t0, 0 	# t0 = i = 0
	
	for:
		bge $t0, 6, efor
		
		li $v0, read_int
		syscall
		
		sll $t1, $t0, 2		# i * 2^2
		sw $v0, lista($t1)	# lista[i] = read_int()
		
		
		add $t0, $t0, 1		# i++
		
		j for
		
	efor:
		li $t0, 0	#reset i (=0)
		
		for2:
			bge $t0, 6, efor2
			
			sll $t1, $t0, 2		# i * 2^2
			lw $t2, lista($t1)	# t2 = lista[i]
			
			#Print lista[i]
			la $a0, ($t2)
			li $v0, print_int10
			syscall
			
			#Print sep
			la $a0, sep
			li $v0, print_str
			syscall
			
			add $t0, $t0, 1		# i++
			
			j for2
		
		efor2:
			#Exit program
			li $v0, exit
			syscall