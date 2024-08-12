#include <iostream>

using namespace std;

bool checkPalindrome(int);

int main()
{
    int n;
    cout << "Enter the number:";
    cin >> n;

    if (checkPalindrome(n))
    {
        cout << "Number is Palindrome" << endl;
    }
    else
    {
        cout << "Number is not Palindrome" << endl;
    }
}

bool checkPalindrome(int number)
{
    int x = 0;
    while (number > x)
    {
        x = x * 10 + number % 10;
        number /= 10;
    }
    return number == x || (x > number && x / 10 == number);
}