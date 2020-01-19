def max3(x,y,z):
	n = max2(x,y)
	return max2(n,z)
	
def max2(x,y):
	if x>y:
		return x
	else:
		return y

def main():
	x = float(input("x?"))
	y = float(input("y?"))
	z = float(input("z?"))
	maior = max3(x,y,z)
	print("Maior: {:f}".format(maior))

main()
