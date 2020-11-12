	.include "syscalls.h"
	.data
prompt1:	.asciiz "Introduza um número\n"
result1:	.asciiz "O fatorial do número "
result2:	.asciiz " é: "
	.text
	.globl main
	
main:
	#Print prompt1
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $t9, $v0	# s0 = v0 <=> n = read_int()
	
	add $t0, $0, $t9	# i = n
	li $t1, 1	# t1 = res = 1
	
	for:
		ble $t0, 0, efor
		
		mul $t1, $t1, $t0	# res = res * i
		
		addi $t0, $t0, -1	# i--
		
		j for
		
	efor:
		#Print result1
		la $a0, result1
		li $v0, print_str
		syscall
		
		#Print n
		la $a0, ($t9)
		li $v0, print_int10
		syscall
		
		#Print result2
		la $a0, result2
		li $v0, print_str
		syscall
		
		#Print factorial
		la $a0, ($t1)
		li $v0, print_int10
		syscall
		
		#Exit Program
		li $v0, exit
		syscall