x1 = float(input("number? "))
x2 = float(input("number? "))
x3 = float(input("number? "))

# Use conditional statements instead of max function!
if (x1>x2 and x2>x3) or (x1>x3 and x3>x2): #x1 max
	print("Maximum: "+ str(x1))
elif (x2>x1 and x1>x3) or (x2>x3 and x3>x1): #x2 max
	print("Maximum: "+ str(x2))
else:
	print("Maximum: "+ str(x3)) #x3 max

