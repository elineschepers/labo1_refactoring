package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MirroringL6 implements CypherL6 {

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
        return encode(s);
    }
}
