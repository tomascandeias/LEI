def ispalindrome(s):
	s = s.lower()
	if s[::-1] == s:
		return True
	else:
		return False

def main():
	print(ispalindrome("ana"))
	print(ispalindrome("anA"))
	print(ispalindrome("Ana"))

main()
