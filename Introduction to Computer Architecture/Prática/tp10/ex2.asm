	.include "syscalls.h"
	.data
str:	.asciiz "Olá Assembly"	
	.text
	.globl main

main:	la	$a0, str
	li	$v0, print_str
	syscall
	
	jal	strlen
	
	move	$a0, $v0
	li	$v0, print_int10
	syscall
	
	li	$v0, exit
	syscall
	
strlen:	li	$v0, 0		#i=n=0
	wh:	addu	$t1, $a0, $v0
		lb	$t0, 0($t1)	#while(str[i]!='\0')
		beqz	$t0, ewh
		addi	$v0, $v0, 1	#n++ i++
		j	wh
		
	ewh:	jr	$ra