package hello.service;

import hello.common.PalindromeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PalindromeServiceImpl implements PalindromeService {


    @Override
    public PalindromeResponse performPalindrome(String word) {
      log.info("Straring performPalindrome {}", word);
      boolean isPalindrome = isPalindrome(word);
      boolean canFormPalindrome = canFormPalindrome(word);
      PalindromeResponse palindromeResponse = PalindromeResponse.builder().word(word)
              .palindrome(isPalindrome).anagramOfPalindrome(canFormPalindrome).build();

      log.info("Ending performPalindrome {}", palindromeResponse);
      return palindromeResponse;
    }

    /**
     * Check recursively whether the string is a palindrome or not
     * @param word
     * @return
     */
    private static boolean isPalindrome(String word) {
        boolean isEven = word.length() % 2 == 0;
        return isPalindrome(word, isEven, isEven ? 0 : 1);
    }

    private static boolean isPalindrome(String word, boolean isEven, int offset) {
        int midpoint = word.length() / 2;
        if (offset > midpoint + (isEven ? -1 : 0)) {
            return true;
        }
        char xchar = word.charAt(midpoint - offset + (isEven ? -1 : 0));
        char ychar = word.charAt(midpoint + offset);
        if (xchar != ychar) {
            return false;
        }

        return isPalindrome(word, isEven, offset + 1);
    }

    /**
     * This method to check whether characters of a string can form a palindrome
     * @param str
     * @return
     */
    private boolean canFormPalindrome(String str)
    {
        int NO_OF_CHARS = 256;
        int[] count = new int[NO_OF_CHARS];
        for (int i = 0; i < str.length(); i++) count[str.charAt(i)]++;
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) != 0)
                odd++;
            if (odd > 1)

                return false;
        }

        return true;
    }
}
