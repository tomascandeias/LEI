def isPrime(n):
	if n==2 or n==3 or n==5 or n==7:
		return True
	if n<2 or n%2==0 or n%3==0 or n%5==0:
		return False
	else:
		return True

for i in range(1,101):
	print("{} -> {}".format(i, isPrime(i)))
