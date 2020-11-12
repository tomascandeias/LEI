	.include "syscalls.h"
	.data
askNumber:	.asciiz "N? "
result:		.asciiz "Série de Fibonacci:\n"	
	.text
	.globl main
	
main:
	#Print askNumber
	la $a0, askNumber
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $a0, $v0		# $a0 = n
	jal fibo
	
	la $a0, ($v0)
	li $v0, print_int10
	syscall
	
	#Exit program
	li $v0, exit
	syscall
	
#
#a0 -> n
#int fibo(int n)
fibo:
	bgt $a0, 1, fiboRecursive
	move $v0, $a0
	jr $ra
	
fiboRecursive:
	addiu $sp, $sp, -12
	sw $ra, 0($sp)
	sw $a0, 4($sp)
	
	addi $a0, $a0, -1	# n-1
	jal fibo		# fibo(n-1)
	
	
	lw $a0, 4($sp)		# restore n
	sw $v0, 8($sp)		# save aux = fibo(n-1)
	
	addi $a0, $a0, -2	# n-2
	jal fibo		# fibo(n-2)
	
	lw $t0, 8($sp)
	add $v0, $t0, $v0	# aux + fibo(n-2) = fibo(n-1) + fibo(n-2)
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 12
	jr $ra
	
