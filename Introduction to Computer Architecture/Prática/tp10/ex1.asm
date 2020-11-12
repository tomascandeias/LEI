	.include "syscalls.h"
	.data
prompt1:	.asciiz "Introduza um número: "
result:		.asciiz "O fatorial do número inserido é: "
	.text
	.globl main
#a->$t1; i->$t0
main:	la	$a0, prompt1
	li	$v0, print_str
	syscall
	
	li	$v0, read_int
	syscall
	move	$a0, $v0	#i=n
	
	jal	fact		#x=fact(n)
	move	$t1, $v0
	
	la	$a0, result
	li	$v0, print_str
	syscall
	
	move	$a0, $t1
	li	$v0, print_int10
	syscall
	
	li	$v0, exit	# exit()
	syscall

#
#$a0 = n
#$v0 = fact(n)
#	
fact:	li	$v0, 1	#f=1

	for:	beqz	$a0, efor	#if(n==0) goto efor
		mul	$v0, $v0, $a0	#f=f*n
		addi	$a0, $a0, -1	#a--
		j	for
		
	efor:	jr	$ra
	
