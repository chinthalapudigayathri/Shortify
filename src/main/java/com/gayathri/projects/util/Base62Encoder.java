package com.gayathri.projects.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/* We will annotate the class with @component to tell Spring that it should consider this class as a bean
by defining this as component we can perform @Autoired and other operations, hence this is important
util is not an actual folder like repo/model but most programmers use util to store static variables
 */
@Component
public class Base62Encoder {
    /* We will declare few private static final constants here
     * 1. Private means only this class can use that object
     * 2.Static means this object belongs to the class not any method so to use this we need not create new object everytime even though it is private
     * 3. Final means we cannot change the declared value, if we try to reassign it later the compiler will throw an error
     */

    //Base 62 means there are total 62 characters from 0-9, a-z,A-Z
    private static final String Base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //Base meaning length of Base62 which is 62
    private static final int Base = Base62.length();
    //defining captcha's length to be 6
    private static final int Captcha = 6;
    //Random() is a built in java util class which for generating random  pesudonumbers which means we can use random() to generate different captcha
    private static final Random random= new Random();

    /* Declare public method so that we can use this method for shortening of the url
    * return is String which means it gives us captcha as return
     */
    public String encode()
    {
        //We use a built-in java StringBuilder Class which is mutable which means modification is allowed on the same object directly instead of creating a new object everytime while we do with String
        StringBuilder encoded = new StringBuilder();
        for(int i=0;i<=Captcha;i++)
        {
        //nextInt is a method in Random() class which gives random number/alphabets from 0 to given Z
        //here by passing Base we are asking random.nextInt to choose from the given length 62 because random.nextInt will assign from 0 to whatever we give as it is unbounded
            int index= random.nextInt(Base);
            encoded.append(Base62.charAt(index));
        }
        return encoded.toString();
    }
}