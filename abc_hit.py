import math

def isPrime(num):
    for i in range(2,num):
        if num % i == 0:
            return False
    return True

def rad(number):
    sq = int(number ** 0.5)
    product = 1
    for i in range(2,sq + 1):
        if number % i == 0 and isPrime(i):
            product *= i
    return product

def gcd(num1,num2,num3):
    g1 = math.gcd(num1,num2)
    g2 = math.gcd(num1,num3)
    g3 = math.gcd(num2,num3)
    if g1 == g2 == g3 == 1:
        return True
    return False


def sum_check(arr):
    arr.sort()
    if arr[0] + arr[1] == arr[2]:
        return True
    return False

def check_all(a,b,c):
    if not(a < b and b < c):
        return False
    if not(sum_check([a,b,c])):
        return False
    if not(gcd(a,b,c)):
        return False
    rad_num = rad(a*b*c)
    if not(rad_num < max([a,b,c])):
        return False
    return True


def main():
    hit_counter = 31
    for c in range(1001,110000):
        for b in range(c):
            for a in range(b):
                if check_all(a,b,c):
                    hit_counter +=1
                    print(hit_counter,c)
    print(hit_counter)



main()
