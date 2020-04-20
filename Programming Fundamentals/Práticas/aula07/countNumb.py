def count(f_name):
    n = []
    with open(f_name) as f:
        for line in f:
            line = line.strip()
            if line != '':
                n.append(float(line))
    return len(n)

def main():
    while True:
        f_name = str(input("Qual é o nome do ficheiro? "))
        if f_name[len(f_name)-4:] == '.txt':
            break
    print("Total: {:d}".format(count(f_name)))

main()