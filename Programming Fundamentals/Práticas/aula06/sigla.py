def shorten(name):
	s = ""
	for c in name:
		if c.isupper():
			s += c
	return s

def main():
	print(shorten("Universidade de Aveiro"))
	print(shorten("United Nations Organization"))
	
main()
