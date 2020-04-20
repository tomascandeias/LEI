def mdc(a, b):
	r = a%b
	if r==0:
		return b
	else: #r>0, o resto da divisão é sempre positivo
		return mdc(b,r)
		

def main():
	print("---MÁXIMO DIVISOR COMUM---")
	a = int(input("Valor de a>0?"))
	b = int(input("Valor de b>0?"))	
	n = mdc(a,b)
	print("m.d.c. {:d}".format(n))
main()
