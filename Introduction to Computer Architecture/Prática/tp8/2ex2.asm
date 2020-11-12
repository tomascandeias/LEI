	.include "syscalls.h"
	.data
prompt1:	.asciiz "Introduza uma String: "
result:		.asciiz "O número de caracteres numéricos: "
str:		.space 40
	.text
	.globl main

main:	la	$a0, prompt1		# print_str(prompt1)
	li	$v0, print_str
	syscall
	#
	la	$a0, str		# read_str(str, 40)
	li	$a1, 40
	li	$v0, read_str
	syscall
	#
	li	$t0, 0		# i=0
	li	$t1, 0		# n=0
	#
for:	addu	$t3, $a0, $t0	# for (i=0; str[i]!='\0'; i++)
	lb	$t2, 0($t3)
	beq	$t2, '\0', efor	# str[i]!='\0'
	blt	$t2, '0', next
	bgt	$t2, '9', next
	addi	$t1, $t1, 1	#n++
	#
next:	addi	$t0, $t0, 1	#i++
	j	for
	#
efor:	la	$a0, result
	li	$v0, print_str
	syscall
	#
	move	$a0, $t1
	li	$v0, print_int10
	syscall
	#
	li	$v0, exit
	syscall	
	 