package toy.utils;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * CollectionsShuffleTest
 *
 * @author chi.chen
 * @date 16-3-2
 * @time 上午11:18
 */
public class CollectionsShuffleTest {

    public static void main(String[] args) {
        String alphaNumericStr = "abcdefghijklmnopqrstuvwxyz0123456789";
        // charactersOf返回的是不可变的List，不能用于shuffle
        // List<Character> characters = Lists.charactersOf(alphaNumericStr);
        List<Character> characters = Lists.newArrayListWithCapacity(alphaNumericStr.length());
        for (int i = 0; i < alphaNumericStr.length(); i++) {
            characters.add(alphaNumericStr.charAt(i));
        }

        Collections.shuffle(characters);

        System.out.println(characters);
    }
}
