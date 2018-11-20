package hello.controller;

import hello.common.ContractEndpoint;
import hello.common.PalindromeResponse;
import hello.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ContractEndpoint.ROOT)
public class WordController {
    // TODO Implement the /words/{word} endpoint

    @Autowired
    PalindromeService palindromeService;

    /**
     *
     * @param word
     * @return
     */
    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public PalindromeResponse mainMethod(@PathVariable("word") String word) {

        PalindromeResponse palindromeResponse = palindromeService.performPalindrome(word);

        return palindromeResponse;

    }



}
