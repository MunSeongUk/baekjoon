a = int(input())
b = int(input())

origin = b
digitHundred = b // 100
b = b % 100
digitTen = b // 10
b = b % 10
print(a * b)
print(a * digitTen)
print(a * digitHundred)
print(a * origin)