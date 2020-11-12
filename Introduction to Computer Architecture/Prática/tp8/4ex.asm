	.include "syscalls.h"
	.data
lista:	.space 24	
prompt:	.asciiz "Introduza 6 números:\n"
str:	.asciiz "O conteúdo do array: "
sep:	.asciiz " ; "
	.text
	.globl main
	
main:	la	$a0, prompt
	li	$v0, print_str
	syscall
	
	li	$t0, 0		#i=0
	la	$s0, lista	#a0 = lista[]
	
for:	bge	$t0, 6, reset1
	
	li	$v0, read_int
	syscall
	
	sll	$t1, $t0, 2	#i*4
	addu	$t2, $s0, $t1	#lista[i]
	sw	$v0, 0($t2)
	
	addi	$t0, $t0, 1	# i++
	j	for

reset1:	li	$t0, 0	#i=0
	j	loop


loop:	li	$t1, 0	#houveTroca=false
	
	for2:	bge	$t0, 5, cond
	
		sll	$t2, $t0, 2	#i*4
		addu	$t3, $s0, $t2	#lista[i] = lista[t2]
		
		lw	$t4, 0($t3)	#$t4 = lista[i]
		lw	$t5, 4($t3)	#$t5 = lista[i+1]
		
		addi	$t0, $t0, 1	# i++
		bgt	$t4, $t5, if	#lista[i] > lista[i+1]
		
		j	for2

	if:	sw	$t5, 0($t3)
		sw	$t4, 4($t3)
		li	$t1, 1		#houveTroca = true
		j	for2
	
	cond:	beqz	$t1, reset2	#houveTroca=false
	li	$t0, 0		#i=0
	j 	loop


reset2:	li	$t0, 0	#i=0
	j	print

print:	bge	$t0, 6, done
	sll	$t1, $t0, 2	# i*4
	addu	$t2, $s0, $t1	# $t2 = &lista[i]
	
	lw	$a0, 0($t2)
	li	$v0, print_int10
	syscall
	
	la	$a0, sep
	li	$v0, print_str
	syscall
	
	addi	$t0, $t0, 1	# i++	
	j	print

done:	li	$v0, exit
	syscall
