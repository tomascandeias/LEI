def allMatches(lst):
	games = []
	for i in range(len(lst)):
		for j in range(len(lst)):
			if i==j:
				continue
			games.append((lst[i], lst[j]))
		
	return games


games = allMatches(["SCP", "SLB", "FCP"])
print(games)
