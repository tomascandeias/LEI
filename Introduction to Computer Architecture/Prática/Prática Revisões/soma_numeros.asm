	.include "syscalls.h"
	.data
numbers:	.word 2, 1, 2, 14
prompt:		.asciiz "Soma dos números: "
	.text
	.globl main
	
main:
	la $a0, numbers
	jal soma_num
	move $s0, $v0
	
	#Print prompt
	la $a0, prompt
	li $v0, print_str
	syscall
	
	#Print sum
	la $a0, ($s0)
	li $v0, print_int10
	syscall
	
	#Exit program
	li $v0, exit
	syscall
	
soma_num:
	li $t0, 0 	# (i)ndex = 0
	li $t5, 0	# soma = 0
for:
	addu $t1, $a0, $t0	# t2 = &numbers[i]
	lw $t2, ($t1)		# t3 = numbers[i]
	
	blt $t0, 5, doneSoma
	
	addi $t5, $t5, 1	# soma += numbers[i]
	
	addi $t0, $t0, 1	# i++
	j for
	
doneSoma:
	move $v0, $t5
	jr $ra