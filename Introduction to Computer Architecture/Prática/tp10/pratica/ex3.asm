	.include "syscalls.h"
	.data
str1:	.asciiz "Tomás "
str2:	.asciiz "Candeias"
str3:	.space 50
	.text
	.globl main
	
main:
	la $a0, str3	# a0 = dst = str3
	la $a1, str1	# a1 = src = str1
	
	jal strcpy
	
	move $a0, $v0	# a0 = dst = str3
	la $a1, str2	# a1 = src = str2
	
	jal strcat
	move $a0, $v0
	li $v0, print_str
	syscall
	
	#Exit program
	li $v0, exit
	syscall

	
strcat:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)		# save $ra
	
	move $a2, $a0		# save dst in $a2

# $a0 = p
loop:
	lb $t0, 0($a0)
	
	beq $t0, '\0', copy
	
	addiu $a0, $a0, 1	# p++
	
	j loop
	
copy:
	jal strcpy
	move $v0, $a2	# return dst
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra

# char * strcpy(char *dst, char *src)
# dst -> return no $v0
# src -> a1
strcpy:
	li $t0, 0 	# i = 0
	la $v0, ($a0)
	while:
		addu $t1, $a1, $t0	# &src[i]
		lb $t2, 0($t1)		# t2 = src[i]
		
		beq $t2, '\0', endWhile
		
		addu $t3, $v0, $t0	# &dst[i]
		sb $t2, 0($t3)		# dst[i] = src[i]
		
		addi $t0, $t0, 1	# i++
		
		j while
		
	endWhile:
		jr $ra