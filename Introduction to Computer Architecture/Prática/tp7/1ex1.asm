	.include "syscalls.h"
	.data
prompt1:	.asciiz "Introduza um n�mero\n"
strpar:		.asciiz "O n�mero � par\n"
strimp:		.asciiz "O n�mero � �mpar"	
	.text
	.globl main

main:	la $a0, prompt1
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall 
	
	andi $t0, $v0, 1
	bne $t0, $0, impar
	
	
	la $a0, strpar
	li $v0, print_str
	syscall
	
	li $v0, exit
	syscall
	
impar:	la $a0, strimp
	li $v0, print_str
	syscall
	
	li $v0, exit
	syscall