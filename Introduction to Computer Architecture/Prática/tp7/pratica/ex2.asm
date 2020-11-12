	.include "syscalls.h"
	.data
prompt1:	.asciiz "Introduza um número\n"
char:		.asci
	.text
	.globl main

main:
	#Print prompt1
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $s0, $v0	# s0 = a
	
	add $t1, $0, 0	# t1 = i = 0
	
	for:	
		bge $t1, $s0, efor
		
		la $a0, '-'
		li $v0, print_char
		syscall
		
		add $t1, $t1, 1	#i++
		
		j for
		
	efor:
		li $v0, exit
		syscall