package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mirroring implements Cypher {

    @Override
    public String encode(String s) {

        String res="";
        for(int i=s.length()-1;i>=0;i--)
        {
           res+=s.toCharArray()[i];
        }
        return res;
    }

    @Override
    public String decode(String s)
    {
        String res="";
        for(int i=0;i<s.length();i++)
        {
            res+=s.toCharArray()[i];
        }
        return res;
    }
}
