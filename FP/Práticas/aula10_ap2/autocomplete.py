import bisect

words = []
with open("words.txt", "r") as f:
	for line in f:
		words.append(line.strip())
	
	
def complete(lst, start):
	lst2 = [x[:len(start)] for x in lst]
	first = bisect.bisect_left(lst2, start)
	last = bisect.bisect_right(lst2, start)
	return [x[len(start):] for x in lst[first:last]]



print('Suggestions for "Ab":')
print(complete(words, 'Ab'))
print()

print('Suggestions for "Abb":')
print(complete(words, 'Abb'))
print()