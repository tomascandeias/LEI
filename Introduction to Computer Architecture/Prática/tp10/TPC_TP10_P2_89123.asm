	.include "syscalls.h"
	.data
nlen:	.asciiz "Numero de termos? "
sfibo:	.asciiz "Serie de Fibonacci: "
sep:	.asciiz ", "
	.text
	.globl main
	
#void main(void){...}
#Variável | Registo(s)
#    n    |    s0
#    f    |    a0
#    i    |    t0, s1 -> t0 para o loop e s1 para i = n em fibo(int n)
main:
	la $a0, nlen
	li $v0, print_str
	syscall
	
	li $v0, read_int
	syscall
	move $s0, $v0		#s0 = n
	
	#Print sfibo
	la $a0, sfibo
	li $v0, print_str
	syscall
	
	addi $t0, $0, 0 # t0 = i =0
	
	for:	bge $t0, $s0, done
		
		move $s1, $t0	# s0 = t0 = i
		jal fibo
		
		#Print fibo n
		move $a0, $v0
		li $v0, print_int10
		syscall
		
		#Print ", "
		la $a0, sep
		li $v0, print_str
		syscall
		
		add $t0, $t0, 1		#i++
		
		j for
	

# int fibo(int n ){..}
#Variável | Registo(s)
#    n    |    s1
#   aux   |    t1
fibo:	
	bgt $s1, 1, fiboRecursive
	move $v0, $s1
	jr $ra

	
fiboRecursive:
	addi $sp, $sp, -12	#reserva 3 espaços no stack
	
	#guardar $s1 (n) e $ra no stack
	sw $s1, 0($sp)		
	sw $ra, 4($sp)
	
	add $s1, $s1, -1	#n-1
	jal fibo
	
	lw $s1, 0($sp)		#restore n
	sw $v0, 8($sp)		#guarda fibo(n-1)
	
	add $s1, $s1, -2	#n-2
	jal fibo
	
	lw $t1, 8($sp)		# restore fibo(n-1) = aux = t1
	add $v0, $t1, $v0	# aux + fibo(n-2) --> valor a retornar
	
	lw $ra, 4($sp)
	add $sp, $sp, 12	
	jr $ra


#Exit program
done:	
	li $v0, exit
	syscall
