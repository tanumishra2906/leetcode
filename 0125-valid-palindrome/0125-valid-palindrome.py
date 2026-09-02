class Solution:
    def isPalindrome(self, s: str) -> bool:
        sr = ""
        for ch in s:
            if ch.isalnum():
                sr+=ch.lower()
        print(sr)
        return sr == sr[::-1]