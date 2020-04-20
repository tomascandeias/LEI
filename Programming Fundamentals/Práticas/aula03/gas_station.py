x = int(input("How many liters? "))

if x<=40:
	x *= 1.4
	print("Receipt: €"+str(round(x,3)))
else:
	x *= 1.4 * 0.9
	print("Receipt: €"+str(round(x,3)))
