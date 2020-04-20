# Complete o programa!

# a)
def loadFile(fname):
	lst = []
	with open(fname, "r", encoding="utf-8") as f:
		i = 0
		for line in f:
			if i>=1:
				l = line.split("\t")
				lst.append((int(l[0]), str(l[1]), float(l[5]), float(l[6]), float(l[7])))
			i += 1

	return lst

# b)
def notaFinal(reg):
	n1 = reg[-1]
	n2 = reg[-2]
	n3 = reg[-3]
	return (n1+n2+n3)/3

# c)
def printPauta(lst, fname):
	fout = open(fname, "w")
	fout.write("Numero{:^100}Nota".format("Nome"))
	for reg in lst:
		fout.write("{:>6}{:^100}{:4.1f}".format(reg[0], reg[1], notaFinal(reg)))
	
	

# d)
def main():
    # ler o ficheiro
    lst = loadFile("school.csv")
    # ordenar a lista
    lst.sort()
    # mostrar a pauta
    printPauta(lst, "new.txt")

# Call main function
main()
