public class Main {
    public static void main(String[] args) {
        VigenereCipher vc = new VigenereCipher("bestkey", "The helicopter is ascending vertically");
        System.out.println(vc.encrypt());
    }
}