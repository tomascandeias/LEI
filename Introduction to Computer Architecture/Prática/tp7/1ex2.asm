	.include "syscalls.h"
	.data
prompt:	.asciiz "Introduza um numero: "
	.text
	.globl main
	
main:	la $a0, prompt
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $t0, $v0
	
for:	beqz $t0, done
	
	la $a0, '-'
	li $v0, print_char
	syscall
	
	addi $t0, $t0, -1
	j for
	
done:	li $v0, exit
	syscall
	
