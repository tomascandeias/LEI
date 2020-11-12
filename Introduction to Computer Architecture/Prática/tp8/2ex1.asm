	.include "syscalls.h"
	.data
maius:	.space 20
minus:	.asciiz "texto em minusculas"	
	.text
	.globl main
	
main:	la	$a0, minus
	la	$a1, maius
	li	$t0, 0	#i=0
	
wh:	addu 	$t1, $a0, $t0	# &minus[i]
	lb	$t2, 0($t1)
	beq	$t2, '\0', ewh	#'\0'=0
	beq 	$t2, ' ', skp
	addi 	$t2, $t2, -32	#$t2 = minus[i] + 'A'-'a' 
	
skp:	addu	$t1, $a1, $t0	#&maius[i]
	sb	$t2, 0($t1)	#maius[i] = $t2 = minus[i]-32
	addi	$t0, $t0, 1	#i++
	j 	wh
	
ewh:	move	$a0, $a1
	li	$v0, print_str
	syscall
	
	li	$v0, exit
	syscall