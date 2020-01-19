def tax(r):
	if r<=1000:
		return (r*0.1)
	elif 1000<r and r<=2000:
		return ((r*0.3)-100)
	else:
		return ((r*0.3)-300)
	
	
	
	
def main():
	n = [0]*3
	n[0] = tax(1000) #1k
	n[1] = tax(2000) #2k
	n[2] = tax(2001) #2001
	for x in n:
		print(x)
	
main()
