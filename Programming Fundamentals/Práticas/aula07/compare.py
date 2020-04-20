def compareFiles(file1, file2):
	with open(file1, 'rb') as f1, open(file2, 'rb') as f2:
		while True:
			p1 = f1.read(1024)
			p2 = f2.read(1024)
			if p1!=p2:
				return "Not Equal!"
			if not p1 or not p2:
				return "Equal :)"
	
	
print(compareFiles("nums.txt", "nums_copy.txt"))
print(compareFiles("nums.txt", "mystery.txt"))
