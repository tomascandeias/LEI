	.include "syscalls.h"
	.data
lista:		.space 24
prompt1:	.asciiz "Insira 6 números:\n"
prompt2:	.asciiz "Array ordenado:\n"
sep:		.asciiz " , "
		.text
		.globl main
	
main:
	#Print prompt1
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	li $t0, 0	# t0 = i = 0
	
	fillLista:
		bge $t0, 6, do
		
		sll $t1, $t0, 2		# i * 2^2
		
		li $v0, read_int
		syscall
		sw $v0, lista($t1)	#lista[i] = read_int()
		
		addi $t0, $t0, 1	# i++
		
		j fillLista
	
	do:
		li $t5, 0	# t5 = 0 = houveTroca = FALSE
		li $t0, 0	# i = 0
		
		for:
			bge $t0, 5, efor
			
			sll $t1, $t0, 2		# i * 2^2
			addi $t2, $t1, 4
			
			lw $s0, lista($t1)	# s0 = lista[i]
			lw $s1, lista($t2)	# s1 = lista[i+1]
			
			bgt $s0, $s1, if
			
			addi $t0, $t0, 1	# i++
			
			j for
			
		if:
			sw $s1, lista($t1)
			sw $s0, lista($t2)
			li $t5, 1
			
			addi $t0, $t0, 1	# i++
			
			j for
		efor:
			beqz $t5, printArray
			j do
		
	printArray:
		#Print prompt2
		la $a0, prompt2
		li $v0, print_str
		syscall
		
		li $t0, 0	# i = 0
		for2:
			bge $t0, 6, efor2
			
			sll $t1, $t0, 2		# i * 2^2
			
			lw $a0, lista($t1)
			li $v0, print_int10
			syscall
			
			#Print sep
			la $a0, sep
			li $v0, print_str
			syscall
			
			addi $t0, $t0, 1	# i++
			
			j for2
			
		efor2:
			#Exit Program
			li $v0, exit
			syscall