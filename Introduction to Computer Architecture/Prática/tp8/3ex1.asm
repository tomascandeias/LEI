	.include "syscalls.h"
	.data
lista:	.word 4,3,-2,1,27,45
str:	.asciiz "O conteúdo do array: "
sep:	.asciiz "; "
	.text
	.globl main
	
main:	la	$a0, str
	li	$v0, print_str
	syscall
	
	li	$t0, 0		# for(i=0; i<6; i++)
	la	$a1, lista
	
for:	bge	$t0, 6, efor
	sll	$t1, $t0, 2	# i*4
	addu	$t2, $a1, $t1	# $t2 = &lista[i]
	
	lw	$a0, 0($t2)
	li	$v0, print_int10
	syscall
	
	la	$a0, sep
	li	$v0, print_str
	syscall
	
	addi	$t0, $t0, 1	# i++	
	j	for
	
efor:	li	$v0, exit
	syscall