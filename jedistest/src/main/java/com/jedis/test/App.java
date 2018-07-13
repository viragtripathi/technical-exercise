package com.jedis.test;

import java.util.*;
import redis.clients.jedis.*;
/**
 * Redis Technical Exercise
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Jedis jedis = new Jedis("54.87.128.166", 6379);
        Jedis jedis = new Jedis(args[0],Integer.parseInt(args[1]));
        if(args.length == 4) {
            jedis.auth(args[3]);
        }
        //Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connected to the server successfully");

        // LPUSH key value [value ...]
        // Insert all the specified values at the head of the list stored at key.
        // If key does not exist, it is created as empty list before performing the push operations.
        // When key holds a value that is not a list, an error is returned.
        // It is possible to push multiple elements using a single command call just specifying multiple arguments
        // at the end of the command. Elements are inserted one after the other to the head of the list,
        // from the leftmost element to the rightmost element. So for instance the command
        // LPUSH mylist a b c will result into a list containing c as first element, b as second element and a as third element.

        //store data in redis list
        if(args[2].equals("load")) {
            String counterValue;
            for (int count = 1; count <= 100; count++) {
                counterValue = String.valueOf(count);
                jedis.lpush("number-list", counterValue);
                System.out.println("Pushed : "+count);
            }
        }
        // LRANGE key start stop
        //O(S+N) where S is the distance of start offset from HEAD for small lists,
        // from nearest end (HEAD or TAIL) for large lists; and N is the number of elements in the specified range.
        //
        //Returns the specified elements of the list stored at key.
        // The offsets start and stop are zero-based indexes,
        // with 0 being the first element of the list (the head of the list), 1 being the next element and so on.
        // Get the stored data and print it
        // -1 is the last element of the list so, it will print everything. Lets restrict it to 1-100
        if(args[2].equals("read")) {
            List<String> list = jedis.lrange("number-list", 0, 99);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Stored string in redis:: " + list.get(i));
            }
        }
    }
}