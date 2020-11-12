	.include "syscalls.h"
	.data
frase:	.space 40
msg:	.asciiz "Escreva uma frase: "
	.text
	.globl main
	
main:
	#Print msg
	la $a0, msg
	li $v0, print_str
	syscall
	
	la $a0, frase	#read_str(str, 40)
	li $a1, 40
	li $v0, read_str
	syscall
	
	la $a0, frase
	jal toUpperP
	
	#Print toUpperP(*frase)
	la $a0, frase
	li $v0, print_str
	syscall
	
	#Exit program
	li $v0, exit
	syscall

# $a0 -> *str -> *frase
# void toUpperP( char* str )
toUpperP:
	lb $t0, 0($a0)	# *p
	beq $t0, '\0', done
	
	blt $t0, 'a', skip
	bgt $t0, 'z', skip
	
	addi $t0, $t0, -32	# *p = *p - 32
	sb $t0, 0($a0)
	
skip:
	addiu $a0, $a0, 1	# p++
	j toUpperP
	
done:
	jr $ra 	
	
	
