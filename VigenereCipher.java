public class VigenereCipher {
    private String key;
    private String text;

    // precondition: key contains no spaces
    public VigenereCipher(String key, String text) {
        this.key = key.toUpperCase();
        this.text = text.toUpperCase();

        int i = 0;
        while(this.key.length() < text.length()) {
            this.key += "" + this.key.charAt(i++ % key.length());
        }
    }

    public String encrypt() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char textLetter = text.charAt(i);
            char keyLetter = key.charAt(i);

            textLetter = textLetter == ' ' ? textLetter : (char) normalize(textLetter + (keyLetter - 'A'), 'A', 'Z');
            sb.append(textLetter);
        }

        return sb.toString();
    }

    public int normalize(int value, int min, int max) {
        if (value <= min) {
            return min;
        }

        if (value <= max) {
            return value;
        }

        return normalize(min + value - max - 1, min, max);
    }
}
