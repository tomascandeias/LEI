	.include "syscalls.h"
	.data
str1:	.space 20
str2:	.space 20
str3:	.space 40

ask1:	.asciiz "Insira a 1º frase: "
ask2:	.asciiz	"Insira a 2º frase: "
cat:	.asciiz "\nFrases concatenadas: "
	.text
	.globl main

main:	#PEDIR FRASES
	la	$a0, ask1
	li	$v0, print_str
	syscall
	
	la	$a0, str1
	li	$a1, 20
	li	$v0, read_str
	syscall
	move	$s0, $a0	#$s0 = str1	FRASE 1
	
	la	$a0, ask2
	li	$v0, print_str
	syscall
	
	la	$a0, str2
	li	$a1, 20
	li	$v0, read_str
	syscall
	move	$s1, $a0	#$s1 = str2	FRASE 2
	#FIM DE PEDIR FRASES
	
	la	$a0, str3
	lw	$a1, 0($s0)
	
	jal	strcpy
	
	
	
	
	
strcpy:
	wh:
	
	
	ewh:
	
