# NMEC: 89123
# NOME: Tomás Candeias

# Complete...
def A(n, k):
	assert k >= 0, "K tem de ser maior ou igual a 0"
	if k == 0: return 1
	return n*A(n-1, k-1)


print("Asserts:")
assert A(2, 1) == 2
assert A(5, 2) == 20
assert A(5, 3) == 60
assert A(10, 3) == 720