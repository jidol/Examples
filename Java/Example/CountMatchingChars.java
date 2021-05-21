/**
 * Copyright Jeff Idol 2013 - 2014
 * <p>
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 * <p>
 * All Source Available https://github.com/jidol/Examples
 */

package Example;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Count the number of matching chars in the input
 */
public class CountMatchingChars {
    /**
     * List all characters and how many times they appear
     */
    public static void main(String[] args) {
        for (String element : args) {
            System.out.println("Processing:  " + element);
            CountMatchingChars.count(element);
        }
    }

    /**
     * Count how many times a character appears in the input
     * then print out the characters and their count
     * @param input String to parse
     */
    public static void count(String input) {
        try {
            HashMap<Character, BigInteger> map = new
                    HashMap<Character, BigInteger>(input.length());
            StringReader read = new StringReader(input);
            int in = 0;
            while (true == read.ready() && in != -1) {
                in = read.read();
                if (-1 != in) {
                    Character val = Character.valueOf((char) in);
                    if (null != val) {
                        if (false == map.containsKey(val))
                            map.put(val, BigInteger.ONE);
                        else {
                            BigInteger update = map.remove(val).add(BigInteger.ONE);
                            map.put(val, update);
                        }
                    }
                }
            }
            read.close();
            read = null;

            for (Character v : map.keySet())
                System.out.println(v + ":" + map.get(v));
            map = null;
        } catch (IOException e) {
            System.out.println("Unable to parse input");
        }
    }
}
