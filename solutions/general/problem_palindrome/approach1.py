# check palindrome 
def checkPalindrome(num):
    # check number negative
    if num<0:
        return False
    elif num==0:
        return True
    
    # reverse the half of number
    x = 0
    while num>x:
        x = x*10 + num%10
        num //=10
        print(x,num)
    
    #  compare first half and reverse number
    if x==num or (x > num and x // 10 == num):
        return True
    else:
        return False
    
# Prompt the user for input
input_str = input('Enter a number: ')

# Convert the input to an integer
try:
    num = int(input_str)
except ValueError:
    print('Please enter a valid number.')
else:
    # Call the palindrome function and print the result
    is_palindrome = checkPalindrome(num)
    print(f'Is {num} a palindrome? {is_palindrome}')
