def countdown(n):
	if n>=0:
		print(n)
		countdown(n-1)

def main():
	n = int(input("Valor de n?"))
	countdown(n)
	
main()
