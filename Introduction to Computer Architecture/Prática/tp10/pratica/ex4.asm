	.include "syscalls.h"
	.data
str1:		.space 20
str2:		.space 20
str3:		.space 40
prompt1:	.asciiz "\nInsira a frase1:"
prompt2:	.asciiz "\nInsira a frase2:"
length:		.asciiz "\nO numero de caracteres da frase1 é: "
concat:		.asciiz "\nA frase concatenada é: "
	.text
	.globl main

#Variável | Registo(s)
#   src   |    a1
#   dst   |    a2
#    i    |    t0
main:	
	#  PEDIR FRASES #
	la	$a0, prompt1
	li	$v0, print_str
	syscall
	
	la	$a0, str1
	li	$a1, 20
	li	$v0, read_str
	syscall
	move	$s1, $a0	# $s1 = str1 = read_str()
	
	la	$a0, prompt2
	li	$v0, print_str
	syscall
	
	la	$a0, str2
	li	$a1, 20
	li	$v0, read_str
	syscall
	move	$s2, $a0	# $s2 = str2 = read_str()

	# FIM #
	
	# FRASE 1 LENGTH #
	move $a0, $s1
	
	jal strlen
	move $t0, $v0
	
	la $a0, length
	li $v0, print_str
	syscall
	
	la $a0, ($t0)		# print length
	li $v0, print_int10
	syscall
	
	la $a0, '\n'
	li $v0, print_char
	syscall
	
	# FIM #
	
	# COPY & CONCATENATE#
	la $a0, str3	# a0 = dst = str3
	la $a1, ($s1)	# a1 = src = str1
	
	jal strcpy
	move $a0, $v0	# a0 = dst = str3
	
	la $a1, ($s2)	# a1 = src = str2	FRASE A JUNTAR
	
	jal strcat
	move $s0, $v0
	
	la $a0, ($s0)
	li $v0, print_str
	syscall
	
	# FIM #
	
	#Exit program
	li $v0, exit
	syscall

# char * strcat(char *dst, char *src)
# dst -> a0
# src -> a1
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
	la $v0, ($a1)
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
	
# int strlen(char * str)
# str -> a0
strlen:
	li $v0, 0	# i = n = 0
wh:	
	addu $t0, $a0, $v0	# &a0[v0]
	lb $t0, 0($t0)
	
	beq $t0, '\0', ewh
	
	addi $v0, $v0, 1	#n++ i++
	
	j wh
	
ewh:
	addi $v0, $v0, -1
	jr $ra
	