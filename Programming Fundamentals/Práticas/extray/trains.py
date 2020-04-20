# NMEC: 89123
# NOME: Tomás Candeias

import random

"""
Um vagão é uma lista [mercadoria, quant] com 0<quant<=60 toneladas.
Um comboio é uma lista de vagões.
"""

# Capacidade máxima dos vagões:
Qmax = 60

# Constantes para indexar os vagões.
# Se w==['coal', 45], então w[M]=='coal' e w[Q]==45.
M,Q = 0,1

# Esta função cria um comboio aleatório (NÃO PRECISA PERCEBER).
def randomTrain(a, b=0):
	types = ["coal", "iron", "sand", "salt", "sugar", "rice"]
	n = a if a>b else random.randint(a, b)
	train = []
	for i in range(n):
		wagon = [random.choice(types), random.randint(1, Qmax)]
		train.append(wagon)
	return train


#a)
def quantityOf(t, m):
	"""Quantidade total de mercadoria de tipo m no comboio t."""
	total = 0
	for vagao in t:
		if vagao[0] == m:
			total += vagao[1]
	return total

#b)
def unload(t, m, q):
	"""Descarrega quantidade q de mercadoria de tipo m."""
	total = quantityOf(t, m)
	for vagao in reversed(t):
		if vagao[0] == m:
			if vagao[1] < q:
				q -= vagao[1]
				t.remove(vagao)
			elif vagao[1] == q:
				q = 0
				t.remove(vagao)
				break
			else:
				vagao[1] -= q
				q = 0
				break
	return q

#c)
def merchandise(t):
	"""Devolve tabela com a quantidade de cada mercadoria no comboio t."""
	d = {}
	for vagao in t:
		if vagao[0] in d:
			d[vagao[0]] += vagao[1]
		else:
			d[vagao[0]] = vagao[1]
	
	return {m:q for value in sorted(d.values(), reverse=True) for m,q in d.items() if q==value}
#d)
def trainsPerMerchandise(trains):
	d = {}
	for name, lst_vagoes in trains.items():
		for vagao in lst_vagoes:
			if vagao[0] in d:
				d[vagao[0]].add(name)
			else:
				d[vagao[0]] = {name}
	
	return d


def main():
	random.seed("abc") # Pode alterar o argumento para obter comboios distintos
	
	t = [['coal', 30], ['rice', 50], ['iron', 5], ['rice', 42], ['coal', 45]]
	#t = randomTrain(5)  # descomente se quiser gerar outro comboio
	print("t:", t)
	
	print("\na)")
	print(quantityOf(t, 'rice'),    # 92
			quantityOf(t, 'iron'),    # 5
			quantityOf(t, 'coal'),    # 75
			quantityOf(t, 'salt'))    # 0
	
	print("\nb)")
	q = unload(t, 'rice', 40)
	print("unload(t, 'rice', 40) ->", q)
	print("t:", t)
	q =unload(t, 'coal', 50)
	print("unload(t, 'coal', 50) ->", q)
	print("t:", t)
	q =unload(t, 'iron', 20)
	print("unload(t, 'iron', 20) ->", q)
	print("t:", t)
	
	print("\nc)")
	print(merchandise(t))
	print("t:", t)
	
	print("\nd)")
	trains = { tid: randomTrain(1,5) for tid in ['T1', 'T2', 'T3', 'T4'] }
	print("trains:", trains)
	trainsPerM = trainsPerMerchandise(trains)
	print(trainsPerM)

####
main()



