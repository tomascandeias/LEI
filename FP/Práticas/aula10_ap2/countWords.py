import bisect

with open("words.txt", "r") as f:
	words = []
	for word in f:
		words.append(word.strip())
	print(words)
	
def countWords(lst, start):
	lst = [x[:len(start)] for x in lst]
	
	first = bisect.bisect_left(lst, start)
	last = bisect.bisect_right(lst, start)
	
	if first == last:
		return lst[last][-1]
	
	return len(lst[first:last])


print(countWords(words, 'Ae'))   #should be 18
print(countWords(words, 'ae'))   #should be 49 - É case-sensitive!
print(countWords(words, 'Abb'))  #should be 6
print(countWords(words, 'ea'))   #should be 80€ DLC
print(countWords(words, 'tb'))   #should be e