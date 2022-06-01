import json
import pytest

from main import gcd, isMultipleOf10, selection_sort

data = []


def read_file(string):
    f = open(string + '.json')
    my_data = json.load(f)
    testing_data = my_data['data']
    f.close()
    return testing_data


class TestGcdFunction:
    @classmethod
    def setup(cls):
        global data
        data = read_file('gcd')

    @classmethod
    def teardown(cls):
        global data
        data.clear()

    @pytest.mark.parametrize("a,b", [(42, 28)])
    def test_shouldGiveCorrectValue(self, a, b):
        assert gcd(a, b) == 14

    @pytest.mark.parametrize("a,b", [(-8, -2)])
    def test_shouldGiveCorrectValueWithNumbersNegative(self, a, b):
        assert gcd(a, b) == -2

    @pytest.mark.parametrize("a,b", [("o", "/")])
    def test_shouldThrowAnError(self, a, b):
        with pytest.raises(TypeError):
            assert gcd(a, b)

    @pytest.mark.parametrize("a, b ,expected", data)
    def test_user(self, a, b, expected):
        assert gcd(a, b) == expected


class TestIsFibonacciNthElementMultipliedBy10:
    @classmethod
    def setup(cls):
        global data
        data = read_file('fib')

    @classmethod
    def teardown(cls):
        global data
        data.clear()

    @pytest.mark.parametrize("a", [17])
    def testShouldGiveFalse(self, a):
        assert isMultipleOf10(a) == False

    @pytest.mark.parametrize("a", [15])
    def testShouldGiveFalse(self, a):
        assert isMultipleOf10(a) == True

    @pytest.mark.parametrize("a", ["o"])
    def test_shouldThrowAnError(self, a):
        with pytest.raises(TypeError):
            assert isMultipleOf10(a)

    @pytest.mark.parametrize("a, expected", data)
    def test_user(self, a, expected):
        assert isMultipleOf10(a) == expected


class TestSelectionSort:
    @classmethod
    def setup(cls):
        global data
        data = read_file('selection')

    @classmethod
    def teardown(cls):
        global data
        data.clear()

    @pytest.mark.parametrize("a,b,c,e,f,g", [(17, 5, 6, 7, 2, 1)])
    def test_shouldGiveCorrectOutput(self, a, b, c, e, f, g):
        arr = [a, b, c, e, f, g]
        correctArr = [1, 2, 5, 6, 7, 17]
        assert selection_sort(arr) == correctArr

    @pytest.mark.parametrize("a,b,c,e,f", [(-17, -5, 6, 7, 2)])
    def test_shouldGiveIncorrectOutput(self, a, b, c, e, f):
        arr = [a, b, c, e, f]
        correctArr = [7, -5, 2, 6, -17]
        assert selection_sort(arr) != correctArr

    @pytest.mark.parametrize("a,b,c,e,f", [("o/", -5, 6, 7, 2)])
    def test_shouldGivTypeError(self, a, b, c, e, f):
        arr = [a, b, c, e, f]
        with pytest.raises(TypeError):
            assert selection_sort(arr)

    @pytest.mark.parametrize("a,expected", data)
    def test_shouldGivTypeError(self, a, expected):
        assert selection_sort(data) == expected
