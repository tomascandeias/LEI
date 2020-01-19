
# Add functions here
def printTable(lst):
    print("{:<30}{:>10}{:>10}{:>10}".format("Nome", "Peso", "Altura", "IMC"))
    for person in lst:
        print("{:<30}{:>10.0f}{:>10.2f}{:>10.1f}".format(person[0], person[1], person[2], person[1]/(person[2]**2)))

def inputBetween(question, min, max):
    while True:
        try:
            n = float(input(question))
            if min<=n<=max:
                return n
            else:
                print("Value must be in [{:.2f}, {:.2f}]".format(min, max))
        except ValueError:
            print("Please enter a valid value!")

def selectTaller(lst, limit):
    lst_tall = []
    for person in lst:
        if person[2] >= limit:
            lst_tall.append(person)
    return lst_tall

def main():
    # Lista de pessoas com nome, peso em kg, altura em metro.
    people = [("John", 64.5, 1.757),
        ("Berta", 64.0, 1.612),
        ("Maria", 45.1, 1.715),
        ("Andy", 98.3, 1.81),
        ("Lisa", 46.8, 1.622),
        ("Kelly", 83.2, 1.78)]

    # Imprime os dados numa tabela com 4 colunas: nome, peso, altura e IMC.
    printTable(people)
    
    # Pede e devolve um valor, mas só aceita se estiver no intervalo certo.
    limit = inputBetween("altura minima? ", 1.1, 2.5)

    # Extrai uma lista de pessoas com altura superior a limit.
    tallpeople = selectTaller(people, limit)
    
    # Mostra uma tabela só com as pessoas altas.
    printTable(tallpeople)


# O programa começa aqui
main()

