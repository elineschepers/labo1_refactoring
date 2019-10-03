package domain;

public class AddSum implements Cypher {



    public AddSum() {

    }

    @Override
    public String encode(String text) {
        String s = "";
        int len = text.length();
        for(int x = 0; x < len; x++){
            char c = (char)(text.charAt(x) + len);
            if (c > 'z') {
                s += (char) (text.charAt(x) - (26 - len));
            } else if (c > 96 && c < 123) {
                s += (char)(text.charAt(x) + len);
            } else {
                s += (char)(text.charAt(x));
            }
        }
        return s;
    }

    @Override
    public String decode(String text) {
        String s = "";
        int len = text.length();
        for(int x = 0; x < len; x++){
            char c = (char)(text.charAt(x) - len);
            if (c > 'z') {
                s += (char) (text.charAt(x) + (26 - len));
            } else if (c > 96 && c < 123) {
                s += (char)(text.charAt(x) - len);
            } else {
                s += (char)(text.charAt(x));
            }
        }
        return s;
    }
}