package domain;

public class CaesarL6 implements CypherL6 {

    private int number;

    public CaesarL6(int n) {
        setNumber(n);
    }

    public CaesarL6() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > 26 || number < 0) {
            throw new IllegalArgumentException("azert");
        }
        this.number = number;
    }

    @Override
    public String encode(String text) {
        String s = "";
        int len = text.length();
        for(int x = 0; x < len; x++){
            char c = (char)(text.charAt(x) + number);
            if (c > 'z') {
                s += (char) (text.charAt(x) - (26 - number));
            } else if (c > 96 && c < 123) {
                s += (char)(text.charAt(x) + number);
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
            char c = (char)(text.charAt(x) - number);
            if (c > 'z') {
                s += (char) (text.charAt(x) + (26 - number));
            } else if (c > 96 && c < 123) {
                s += (char)(text.charAt(x) - number);
            } else {
                s += (char)(text.charAt(x));
            }
        }
        return s;
    }
}
