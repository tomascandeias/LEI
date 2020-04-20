def factorial(n):
	if n==1:
		return 1
	else:
		return n*factorial(n-1)
def main():
	a = int(input("N?"))
	print(factorial(a))
main()
