def intersect(a1, b1, a2, b2):
	assert a1<=b1
	assert a2<=b2
	if (a1>=a2 and b1<b2) or (b1>a2 and a1<b2) or (a1>=b2 and b1<a2):
      return True
    else:
      return False
#tested in http://codecheck.it/files/19100608548l2grj9xah4j6cvgkxbhvzke6
