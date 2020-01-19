import math
def floatInput(prompt, minimo = -math.inf, maximo= math.inf):
	while True:
		try:
			n = float(input(prompt))
			if minimo<=n<=maximo:
				break
			else:
				print("Value isn't in [{};{}]".format(minimo, maximo))
		except ValueError:
			print("Not a float!")
	
	return n

print(floatInput("val? ", 1, 2))
