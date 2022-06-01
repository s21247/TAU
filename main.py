
def selection_sort(array):
    for i in range(len(array)):
        first_idx = i
        for j in range(i + 1, len(array)):
            if array[first_idx] > array[j]:
                first_idx = j
        array[i], array[first_idx] = array[first_idx], array[i]
    return array


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def fibonacci(n):
    a = 0
    b = 1
    if n <= 1:
        return n
    for i in range(2, n + 1):
        c = a + b
        a = b
        b = c

    return c


def isMultipleOf10(n):
    f = fibonacci(n)
    return f % 10 == 0


if __name__ == '__main__':
    print(gcd(0, 8))
    print(isMultipleOf10(17))
