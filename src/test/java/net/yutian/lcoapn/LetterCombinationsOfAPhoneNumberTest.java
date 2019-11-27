package net.yutian.lcoapn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LetterCombinationsOfAPhoneNumberTest {
  @Test
  public void test() {
    LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
    System.out.println(Arrays.toString(test.letterCombinations("2345").toArray()));

    Assert.assertEquals(81, test.letterCombinations("2345").size());
  }
}
