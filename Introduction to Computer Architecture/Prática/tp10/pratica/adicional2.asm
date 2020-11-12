	.include "syscalls.h"
	.data
lst:	.space 24	
prompt:	.asciiz "Introduza 6 números:\n"
str:	.asciiz "O conteúdo do array: "
sep:	.asciiz " ; "
	.text
	.globl main
	
main:
	#Print prompt
	la $a0, prompt
	li $v0, print_str
	syscall
	
	li $t0, 0	# t0 = i = 0
	jal fillLst
	
	la $a0, lst	# a0 = &lst
	la $a1, 6	# a1 = 6 = n
	jal bubble_sort
	move $s0, $a2
	
	
	#Print sorted lst
	li $t0, 0	# i = 0
	printLst:
		bge $t0, 6, done
		sll $t1, $t0, 2
		addu $t2, $s0, $t1
		lw $t3, 0($t2)
		
		la $a0, ($t3)
		li $v0, print_int10
		syscall
		
		la $a0, sep
		li $v0, print_str
		syscall
		
		addi $t0, $t0, 1	# i++
		
		j printLst
		
done:
	#Exit program
	li $v0, exit
	syscall

bubble_sort:
do:
	li $t9, 0		# houveTroca = FALSE
	move $a2, $a0		# paux = p
	addi $t8, $a1, -1 	# t8 = n-1
	li $t0, 0		# i = 0
	
for:
	bge $t0, $t8, check
	
	sll $t1, $t0, 2		# i
	addi $t2, $t1, 4	# i+1
	addu $t3, $a2, $t1	# &paux[i]
	addu $t4, $a2, $t2	# &paux[i+1]
	lw $t5, 0($t3)		# t5 = paux[i]
	lw $t6, 0($t4)		# t6 = paux[i+1]
	
	ble $t5, $t6, noSwap	# paux[i]<=paux[i+1] goto noSwap
	
	sw $t6, 0($t3)		# &paux[i] = paux[i+1]
	sw $t5, 0($t4)		# &paux[i+1] = paux[i]
	li $t9, 1		# houveTroca = TRUE
	addi $t0, $t0, 1	# i++

	
noSwap:
	addi $t0, $t0, 1	# i++
	j for
check:
	beqz $t9, endSort
	j do

endSort:
	jr $ra

# PREENCHER A LISTA COM OS 6 NÚMEROS DADOS #	
fillLst:
	bge $t0, 6, endFill
	
	li $v0, read_int
	syscall
	
	sll $t1, $t0, 2		# i * 2^2
	sw $v0, lst($t1)	#lst[i] = read_int()
	
	addi $t0, $t0, 1	# i++
	
	j fillLst
	
endFill:
	jr $ra
