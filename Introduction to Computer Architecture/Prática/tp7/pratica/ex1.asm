	.include "syscalls.h"
	.data
prompt1:	.asciiz "Introduza um número\n"
strpar:		.asciiz "O número é par\n"
strimp:		.asciiz "O número é ímpar\n"
	.text
	.globl main
	
main:
	#Print prompt1
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $s0, $v0 	# t0 = a
	
	and $s1, $s0, 1	# (t0 & 1)
	
	beqz $s1, par
	
	la $a0, strimp
	li $v0, print_str
	syscall
	
	j done
	
par:	
	la $a0, strpar
	li $v0, print_str
	syscall
	
done:
	li $v0, exit
	syscall
	
	
	