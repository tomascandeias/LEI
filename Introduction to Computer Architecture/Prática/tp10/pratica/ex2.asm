	.include "syscalls.h"
	.data
str:		.asciiz "Olá exercício 2"
result:		.asciiz "\nString length: "
	.text
	.globl main
	
main:
	#Print prompt1
	la $a0, str
	li $v0, print_str
	syscall
	
	jal strlen
	move $s0, $v0
	
	#Print result
	la $a0, result
	li $v0, print_str
	syscall
	
	#Print length
	la $a0, ($s0)
	li $v0, print_int10
	syscall
	
	#Exit program
	li $v0, exit
	syscall
	
strlen:
	la $a1, str
	li $v0, 0	# v0 = n = 0
	
	while:
		addu $t0, $a1, $v0	# a1 = &str[i]
		lb $t1, 0($t0)		# read char
		
		beq $t1, '\0', ewhile
		
		addi $v0, $v0, 1	# n++
		
		j while
	
	ewhile:
		jr $ra