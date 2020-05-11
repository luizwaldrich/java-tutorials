package challenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ChallengesTest {

    @Test
    public void shouldReverseTheString() {
        String original = "original";
        String reversed = "lanigiro";
        Assert.assertEquals(reversed, Challenges.reverseString(original));
    }

    @Test
    public void shouldMapAndCountTheString() {
        Map<Character, Integer> expected = new HashMap<Character, Integer>();
        expected.put('a', 2);
        expected.put('v', 1);
        expected.put('o', 2);
        expected.put('c', 1);
        expected.put('d', 1);
        Assert.assertEquals(expected, Challenges.countCharacters("avocado"));
    }
}
