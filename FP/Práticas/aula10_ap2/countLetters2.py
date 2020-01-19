with open("pg3333.txt", "r", encoding="utf-8") as f:
	d = dict()
	for line in f:
		line = line.lower()
		for c in line:
			if c.isalpha():
				d[c] = d.get(c, 0) + 1
				
	
	for letter in sorted(d, key=lambda letter: d[letter], reverse=True):
		print(letter, d[letter])