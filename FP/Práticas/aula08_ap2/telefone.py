# Complete este programa como pedido no guião da aula.

def listContacts(dic):
	"""Print the contents of the dictionary as a table, one item per row."""
	print("{:>12s} : {}".format("Numero", "Nome"))
	for num in dic:
		print("{:>12s} : {}".format(num, dic[num]))

def filterPartName(contacts, partName):
	"""Returns a new dict with the contacts whose names contain partName."""
	d = {}
	for number, name in zip(contacts.keys(), contacts.values()):
		if partName in name:
			d[number] = name
	return d
	

def addContact(d):
	name = str(input("Nome? "))
	number = str(input("Numero? "))
	if not (name in d or number in d):
		d[number] = name
		return d

def removeContact(d):
	number = str(input("Numero? "))
	if number in d:
		d.pop(number)
	else:
		print("Contacto não encontrado!")
	return d

def searchByNumber(d):
	number = str(input("Numero? "))
	if number in d:
		print("{} : {}".format(number, d.get(number)))
	else:
		print(number)



def menu():
	"""Shows the menu and gets user option."""
	print()
	print("(L)istar contactos")
	print("(A)dicionar contacto")
	print("(R)emover contacto")
	print("Procurar (N)úmero")
	print("Procurar (P)arte do nome")
	print("(T)erminar")
	op = input("opção? ").upper()   # converts to uppercase...
	return op


def main():
	"""This is the main function containing the main loop."""
	
	# The list of contacts (it's actually a dictionary!):
	contactos = {"234370200": "Universidade de Aveiro",
				"727392822": "Cristiano Aveiro",
				"387719992": "Maria Matos",
				"887555987": "Marta Maia",
				"876111333": "Carlos Martins",
				"433162999": "Ana Bacalhau"
				}
	
	op = ""
	while op != "T":
		op = menu()
		if op == "T":
			print("Fim")
		elif op == "L":
			print("Contactos:")
			listContacts(contactos)
		elif op == "A":
			print("Adicione o contacto desejado")
			contactos = addContact(contactos)
		elif op == "R":
			print("Remova o contacto desejado")
			contactos = removeContact(contactos)
		elif op == "N":
			print("Procure o número que deseja")
			searchByNumber(contactos)
		elif op == "P":
			print("Procure a parte do nome desejada")
			d = filterPartName(contactos, "a")
			print(d)
		else:
			print("Não implementado!")
	
	
	
# O programa começa aqui
main()

