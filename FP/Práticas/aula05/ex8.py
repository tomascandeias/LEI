list=[] #criação da lista
x=0.0
while True:
	x = input("X?")
	if x=="": break
	list.append(float(x))

print("Maximo:", max(list)) #maximo

print("Minimo:", min(list)) #minimo

total=0.0
for i in range(0, len(list)):
	total+=list[i]
print("Media:", total/len(list))
