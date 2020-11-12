	.include "syscalls.h"
	.data
msg1:	.asciiz "Insira uma base:"
msg2:	.asciiz "Insira um expoente: "
result:	.asciiz "base^expoente = "	
	.text
	.globl main
	
main:
	#Print msg1
	la $a0, msg1
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $t0, $v0		# base = $t0
	
	#Print msg2
	la $a0, msg2
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $t1, $v0		# expoente = $t1
	
	move $a0, $t0		# $a0 = base
	move $a1, $t1		# $a1 = expoente
	jal x_to_y
	move $t2, $v0		# $t2 = final number
	
	#Print msg3
	la $a0, result
	li $v0, print_str
	syscall
	
	#Print final number
	la $a0, ($t2)
	li $v0, print_int10
	syscall
	
	#Exit program
	li $v0, exit
	syscall
	
	
# $a0 -> base
# $a1 -> expoente
# int x_to_y(int base, int exp)
x_to_y:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	li $v0, 1
	beq $a1, 0, done	# if (exp == 0)return 1
	
	addi $a1, $a1, -1	# exp - 1
	jal x_to_y
	
	mul $v0, $v0, $a0
	
done:
	lw $ra, 0($sp)
	
	addi $sp, $sp, 4
	
	jr $ra
	