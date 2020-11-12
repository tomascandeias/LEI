	.include "syscalls.h"
	.data
prompt1:	.asciiz "Introduza um número\n"
result:		.asciiz "O fatorial do número inserido é: "
	.text
	.globl main
	
main:	
	#Print prompt1
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $s0, $v0	#s0 = n
	
	add $t0, $0, $s0	# t0 = i = n
	add $t1, $0, 1		# t1 = f = 1
	
	for:	beqz $t0, efor	#i==0 goto efor
		
		mul $t1, $t1, $t0	# f = f*i
		
		add $t0, $t0, -1
		
		j for
	
	efor:	
		#Print result
		la $a0, result
		li $v0, print_str
		syscall
		
		la $a0, ($t1)
		li $v0, print_int10
		syscall
		
		#Exit program
		li $v0, exit
		syscall