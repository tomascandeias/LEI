	.include "syscalls.h"
	.data
lista:		.space 24
prompt1:	.asciiz "\nInsira 6 números:\n"
prompt2:	.asciiz "\nOrdenação crescente:\n"
sep:		.asciiz " , "
	.text
	.globl main
	
main:
	#Print prompt1
	la $a0, prompt1
	li $v0, print_str
	syscall
	
	la $s0, lista
	li $t0, 0		# $t0 = i = 0
for:
	bge	$t0, 6, do
	
	li	$v0, read_int
	syscall
	
	sll	$t1, $t0, 2	#i*4
	addu	$t2, $s0, $t1	#lista[i]
	sw	$v0, 0($t2)
	
	addi	$t0, $t0, 1	# i++
	j	for

		
do:
	li $t0, 0		# i = 0
	li $t5, 0		# $t5 = houveTroca = TRUE

for2:
	bge $t0, 5, while	# for(i = 0; i < SIZE-1; i++ )
	
	sll $t1, $t0, 2		# $t1 = i*2^2
	addu $t2, $s0, $t1	# $t2 = &lista[i]
	
	lw $t3, 0($t2)		# $t3 = lista[i]
	lw $t4, 4($t2)		# $t4 = lista[i+1]
	
	ble $t3, $t4, skip	# if(lista[i]<=lista[i+1]) goto label skip
	
	#Troca de valores
	sw $t4, 0($t2)
	sw $t3, 4($t2)
	
	li $t5, 1		# houveTroca = TRUE
	
skip:
	addi $t0, $t0, 1	# i++
	j for2
	
while:
	beq $t5, 1, do

printSorted:
	#Print prompt2
	la $a0, prompt2
	li $v0, print_str
	syscall
	
	li $t0, 0	# i = 0
for3:
	bgt $t0, 5, done
	
	sll $t1, $t0, 2
	addu $t2, $s0, $t1
	lw $a0, 0($t2)
	li $v0, print_int10
	syscall
	
	#Print sep
	la $a0, sep
	li $v0, print_str
	syscall
	
	addi $t0, $t0, 1	# i++
	
	j for3
	
done:
	#Exit program
	li $v0, exit
	syscall
	
	
	