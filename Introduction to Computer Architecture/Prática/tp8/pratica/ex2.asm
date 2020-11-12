	.include "syscalls.h"
	.data
maius:	.space 20	
minus:	.asciiz "tomas lima candeias"
	.text
	.globl main
	
main:
	li $t0, 0	# t0 = i = 0
	
	while:
		lb $t1, minus($t0)	#t1 = minus[i]
		
		beq $t1, '\0', ewhile
		beq $t1, ' ', skip
		
		addi $t2, $t1, -32	#t2 = minus[i] + 'A' - 'a'
		
		sb $t2, maius($t0)	# miaus[i] = t2
		
		add $t0, $t0, 1		# i++
		
		j while
	
	skip:
		sb $t1, maius($t0)	#maius[i] = t1 = ' '
		add $t0, $t0, 1		#i++
		j while
		
	ewhile:
		li $t0, 0	# reset t0 = i
		while2:
			lb $t1, maius($t0)
			
			beq $t1, '\0', ewhile2
			
			la $a0, ($t1)
			li $v0, print_char
			syscall
			
			add $t0, $t0, 1		# i++
			
			j while2
			
		ewhile2:
			li $v0, exit
			syscall
			