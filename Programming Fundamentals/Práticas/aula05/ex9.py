def Fibonacci(n):
	x, y = 0, 1
	for i in range(0,n):
		x, y = y, x+y
	return x

n = int(input("N?"))
print("Fibonacci number:", Fibonacci(n))
