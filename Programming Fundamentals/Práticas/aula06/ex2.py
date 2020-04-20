def countLower(lst, v):
	lstLower=[]
	for n in lst:
		if n<v: lstLower.append(n)
	return len(lstLower), lstLower

def minmax(lst):
	lst = sorted(lst)
	return lst[len(lst)-1], lst[0]

def readNumbers():
	lst = [] #criação da lista
	while True:
		x = input("Introduza um número:")
		if x=="": break
		lst.append(float(x))
	return lst

lst = readNumbers()
maximo, minimo = minmax(lst)
medio = (maximo+minimo)/2
print("Máximo:{}\tMínimo:{}\tMédio:{}".format(maximo, minimo, medio))
count, lstInf = countLower(lst, medio)
print("Valor inferiores a médio: ", count)
