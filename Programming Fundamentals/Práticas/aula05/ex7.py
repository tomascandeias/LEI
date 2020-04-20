def leibnizPi4(n):
	total=1
	for i in range(1, n+1):
		a = (-1)**i
		b = 2*i +1
		total += a/b
	return total
	
def main():
	i = int(input("i? "))
	print("{:.3f}".format(leibnizPi4(i)))
	
main()
