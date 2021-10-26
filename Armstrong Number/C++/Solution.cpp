// An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits.
// An Armstrong number need not be 3 digits only. 1634 is also an Armstrong number.

#include <iostream>
using namespace std;

//Calculates the number of digits in number
int numOfDigits(int num)
{
    int digits;
    for (digits = 0; num > 0; digits++)
    {
        num /= 10;
    }
    return digits;
}

int power(int num, int order)
{
    int result = num;
    while (order > 1)
    {
        result = result * num;
        order--;
    }

    return result;
}

int armstrongSum(int num)
{
    int digits = numOfDigits(num);
    int sum = 0;

    while (num > 0)
    {
        int digit = num % 10;
        num /= 10;

        sum += power(digit, digits);
    }
    return sum;
}

int main()
{

    int num;

    cout << "Enter the number: ";
    cin >> num;

    if (num == armstrongSum(num))
        cout << "Armstrong";
    else
        cout << "Not an armstrong number";
    return 0;
}