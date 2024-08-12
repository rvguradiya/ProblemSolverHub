#include <stdio.h>

int checkPalindrome(int);

int main()
{
    int n;
    printf("enter the number:");
    scanf("%d", &n);

    if (checkPalindrome(n))
    {
        printf("Number is Palindrome\n");
    }
    else
    {
        printf("Number is not Palindrome\n");
    }
}

int checkPalindrome(int number)
{
    int x = 0;
    while (number > x)
    {
        x = x * 10 + number % 10;
        number /= 10;
    }
    return number == x || (x > number && x / 10 == number);
}