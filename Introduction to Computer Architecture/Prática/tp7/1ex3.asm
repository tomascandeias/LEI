	.include "syscalls.h"
	.data
prompt:	.asciiz "Introduza um número: "
result:	.asciiz "O fatorial do número inserido é: "
	.text
	.globl main

main:	la $a0, prompt
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $t0, $v0
	
	move $t1, $1	# t1 = 1
	
for:	beqz $t0, done
	
	mul $t1, $t1, $t0
	
	subi $t1, $t1, 1
	
	j for

done:	la $a0, result
	li $v0, print_str
	syscall
	
	move $t1, $t1
	li $v0, print_int10
	syscall
	
	li $v0, exit
	syscall
	