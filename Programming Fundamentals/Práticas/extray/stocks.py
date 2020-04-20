# NMEC: 8913
# NOME: Tomás Candeias

def printStocks(stocks):
	def valor(stock):
		return float((stock[3]*100)/stock[2]) - 100
	
	for stock in stocks:
		print("{:<10}{:<10}{:>10.2f}{:>10.2f}{:>10}{:>10.1f}%".format(stock[0], stock[1], stock[2], stock[3], stock[4], valor(stock)))



# Cada tuplo = (empresa, cidade, abertura, fecho, volume)
stocks = [
	('INTC', 'London', 34.249, 34.451, 1792860),
	('TSLA', 'London', 221.33, 229.63, 398520),
	('EA', 'Paris', 72.63, 68.98, 1189510),
	('INTC', 'Tokyo', 33.22001, 34.28999, 4509110),
	('TSLA', 'Paris', 217.35, 217.75, 252500),
	('ATML', 'Frankfurt', 8.23, 8.36, 810440),
]

print("\na)")
printStocks(stocks)

print("\nb)")
stocks2 = sorted(stocks, key=lambda stock: (stock[0], -1*stock[4]))
printStocks(stocks2)

print("\nc)")
stocks3 = [stock for stock in stocks if stock[1] == "Paris"]
printStocks(stocks3)

print("\nd)")
stocks4 = []
with open("stocks.txt", "r") as f:
	for line in f:
		line = line.strip().split("\t")
		stocks4.append((line[0], line[1], float(line[2]), float(line[3]), int(line[4])))
	

printStocks(stocks4)
# As condições seguintes devem ser verdadeiras
assert type(stocks4)==list
assert type(stocks4[0])==tuple
assert len(stocks4[0])==5
assert type(stocks4[0][2])==float
assert type(stocks4[0][4])==int
print("FIM")

