	.include "syscalls.h"
	.data
lista:	.space 24
prompt:	.asciiz "Insira 6 números: "	
	.text
	.globl main
	
main:	la	$a0, prompt
	li	$v0, print_str
	syscall
	
	li	$t0, 0	# i=0
	la	$a0, lista
	
for:	bge	$t0, 6, efor
	
	li	$v0, read_int
	syscall
	
	sll	$t1, $t0, 2	#i*4
	addu	$t2, $a0, $t1	#lista[i]
	sw	$v0, 0($t2)
	
	addi	$t0, $t0, 1	# i++
	j	for
	
efor:	li $v0, exit
	syscall	