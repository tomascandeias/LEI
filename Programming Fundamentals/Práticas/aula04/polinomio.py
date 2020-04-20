def p(x):
	p = (x**2) + (x*2) + 3
	return p

def main():
	x = float(input("Qual o valor de x?"))
	print("p(x) = {:.2f}".format(p(x)))
	print("p(0) = {:.2f}".format(p(0)))
	print("p(1) = {:.2f}".format(p(1)))
	print("p(2) = {:.2f}".format(p(2)))
	print("p(p(1)) = {:.2f}".format(p(p(1))))

main() #chamar função
