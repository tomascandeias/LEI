def notaFinal(tp,p):
	tp *= 0.3
	p *= 0.7
	return (tp+p)

def printDados():
	print("\n-------------\n")
	if  atpr==0.0 or atpr==None: #atpr e apr têm nota, logo o aluno reprovou à EN
		print("Nome: {} \nNúmero mecanográfico: {:d}\n".format(str(nome), int(numero)))
		print("\nCTP: {:.1f}  CP:{:.1f}\nNota Final na EN = {:.1f}".format(ctp, cp, nf_normal))
	else:
		print("Nome: {} \nNúmero mecanográfico: {:d}\n".format(str(nome), int(numero)))
		print("CTP: {:.1f}  CP:{:.1f}\nNota Final na EN = {:.1f}\n".format(ctp, cp, nf_normal))
		print("\nATPR: {:.1f}  APR:{:.1f}\nNota Final na ER = {:.1f}".format(atpr, apr, nf_recurso))


nome = input("Nome? ")
numero = input("Número mecanográfico? ")
ctp = float(input("CTP? "))
cp = float(input("CP? "))

nota_minima = 6.5

nf_normal = notaFinal(ctp, cp)
if nf_normal>9.5:
	printDados()
else:
	print("Reprovado por nota mínima, insira os resultados da época de recurso:")
	atpr = float(input("ATPR? "))
	apr = float(input("APR? "))
	nf_recurso = notaFinal(atpr, apr)
	printDados()

