// Assignment Question:
// Problem Statement:
// Author: Ansh Pandey

# Problem: Find the largest palindrome made from the product of two 3-digit numbers

def is_palindrome(num):
    return str(num) == str(num)[::-1]

def find_largest_palindrome():
    max_palindrome = 0
    for i in range(999, 99, -1):
        for j in range(999, 99, -1):
            product = i * j
            if is_palindrome(product) and product > max_palindrome:
                max_palindrome = product
    return max_palindrome

print(find_largest_palindrome())

// Problem: Find the largest palindrome made from the product of two 3-digit numbers

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_palindrome(int num) {
    char str[10];
    itoa(num, str, 10);
    int left = 0, right = strlen(str) - 1;
    while (left < right) {
        if (str[left] != str[right]) {
            return 0;
        }
        left++;
        right--;
    }
    return 1;
}

int find_largest_palindrome() {
    int max_palindrome = 0;
    for (int i = 999; i >= 99; i--) {
        for (int j = 999; j >= 99; j--) {
            int product = i * j;
            if (is_palindrome(product) && product > max_palindrome) {
                max_palindrome = product;
            }
        }
    }
    return max_palindrome;
}

int main() {
    printf("%d\n", find_largest_palindrome());
    return 0;
}

// Problem: Find the largest palindrome made from the product of two 3-digit numbers

public class Main {
    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int findLargestPalindrome() {
        int maxPalindrome = 0;
        for (int i = 999; i >= 99; i--) {
            for (int j = 999; j >= 99; j--) {
                int product = i * j;
                if (isPalindrome(product) && product > maxPalindrome) {
                    maxPalindrome = product;
                }
            }
        }
        return maxPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(findLargestPalindrome());
    }
}