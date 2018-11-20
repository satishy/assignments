package hello.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PalindromeResponse {

    private String word;

    private boolean palindrome;

    private boolean anagramOfPalindrome;
}
