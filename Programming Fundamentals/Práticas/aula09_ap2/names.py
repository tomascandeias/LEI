with open("names.txt", "r", encoding="utf-8") as f:
	names = {}
	f.readline()
	
	for line in f:
		line = line.split(" ")
		line[-1] = line[-1].strip()
		if line[-1] not in names:
			names[line[-1]] = set()
		
		names[line[-1]].add(line[0])
	

for e in names:
	print(e, ": ", names[e])
	