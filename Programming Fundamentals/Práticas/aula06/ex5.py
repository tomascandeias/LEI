def countDigits(s):
	count=0
	for c in s:
            if c.isdigit():
    		count += 1
	return count

def main():
	n = countDigits("23 mil 456")
	print(n)

main()
