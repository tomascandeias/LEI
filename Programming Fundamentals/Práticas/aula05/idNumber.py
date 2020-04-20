def allDivisors(n):
	divisors = [] #criar lista
	for i in range(1, n):
		if(n%i==0):
			divisors.append(i)
	return divisors

def sum(n):
	soma=0
	for i in range(0, len(n)):
		soma += n[i]
	return soma

def main():
	n = int(input("Introduza um n inteiro positivo:"))
	divisors = allDivisors(n)
	print("Número deficiente: ", sum(divisors)<n)
	print("Número perfeito: ", sum(divisors)==n)
	print("Número abundante: ", sum(divisors)>n)
	
main()
