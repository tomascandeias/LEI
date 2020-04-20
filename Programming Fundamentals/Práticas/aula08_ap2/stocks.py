import collections

def new_level():
	return collections.defaultdict(new_level)

def readFile(fname):
	companies = new_level()
	with open(fname, "r") as f:
		for line in f:
			line = line.split(",")
			companies[line[0]][line[1]] = [float(line[2]), float(line[3]), float(line[4]), float(line[5]), int(line[6])]
	print(companies["CSCO"]["2015-11-25"].values())
	return companies

def higherVolume(companies):
	max_company = ""
	max_volume = 0
	for company, values in zip(companies.keys(), companies.values()):
		if max_volume < values[5]:
			max_company = company
			max_volume = values[5]
	print("The most higher total volume company is {} with {}".format(max_company, max_volume))
	
def highestShareByCompany(companies):
	name = []
	for company in companies:
		name.append(company)
	
	date = ""
	highest_price = 0
	for i in range(0, len(name)):
		for values in companies[name[i]].values():
			if highest_price < values[2]:
				highest_price = values[2]
				date = values[0]
		print("{} in {} -> {}".format(name[i], date, highest_price))

def main():
	companies = readFile("stocks.csv")
	
	higherVolume(companies)
	highestShareByCompany(companies)
	
	
	
	
main()