def allMatches(lst):
	matches = []
	for team1 in lst:
		for team2 in lst:
			if team1 != team2:
				matches.append((team1, team2))
	return matches

def printTable(table):
	print("\n{:<10}{:>10}{:>10}{:>10}{:>20}{:>20}{:>10}".format("Equipa", "Vitórias", "Empates", "Derrotas", "Golos Marcados", "Golos Sofridos", "Pontos"))
	for team, values in zip(table.keys(), table.values()):
		print("{:<10}{:>10}{:>10}{:>10}{:>20}{:>20}{:>10}".format(team.upper(), values[0], values[1], values[2], values[3], values[4], values[5]))

def setChampion(table):
	champ = list(table)[0]
	for team in table:
		if table[team][5] > table[champ][5]:
			champ = team
		elif table[team][5] == table[champ][5] and table[team][3]-table[team][4] > table[champ][3]-table[team][4]:
			champ = team
	return champ
	
	

def main():
	teams = []
	results = {}
	table = {}
	
	print("Escreva o nomes das equipas ou uma linha em branco para terminar")
	while True:
		team = str(input("->"))
		if team != "" and team not in teams:
			teams.append(team)
			table[team] = [0, 0, 0, 0, 0, 0] #Vitórias / Empates / Derrotas / Golos Marcados / Golos Sofridos / Pontos
		elif team in teams:
			print("Equipa já registada!")
		else:
			break
	
	matches = allMatches(teams)
	
	while True:
		for match in matches:
			print("{} vs. {}".format(match[0], match[1]))
			score_x = int(input("{}: ".format(match[0])))
			score_y = int(input("{}: ".format(match[1])))
			results[match] = (score_x, score_y)
			
			#Equipa X
			table[match[0]][3] += score_x
			table[match[0]][4] += score_y
			
			#Equipa Y
			table[match[1]][3] += score_y
			table[match[1]][4] += score_x
			
			if score_x > score_y:
				table[match[0]][5] += 3
				
				table[match[0]][0] += 1
				table[match[1]][2] += 1
			
			elif score_y > score_x:
				table[match[1]][5] += 3
			
				table[match[0]][2] += 1
				table[match[1]][0] += 1
			
			else:
				table[match[0]][5] += 1
				table[match[1]][5] += 1
				
				table[match[0]][1] += 1
				table[match[1]][1] += 1
				
		break
	
	printTable(table)
	
	print("Equipa vecendora: ", setChampion(table))
	
	
main()