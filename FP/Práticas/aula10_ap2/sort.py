def mediana(lst):
	if len(lst) % 2 == 0: #par
		med = lst[int(len(lst)/2) - 1] + lst[int(len(lst)/2)]
		print(med)
		print(med/2)
		return float(med/2)
	else: #impar
		return lst[int(len(lst)/2)]





lst_par = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
lst_impar = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print("Par -> ", mediana(lst_par))
print("Impar -> ", mediana(lst_impar))
