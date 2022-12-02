package chrvk.javaelementary.hw6.task1;

public class Main {
    public static void main(String[] args) {
        String a = "aaa", b = "fga";
        System.out.println("result: " + checkString(a, b));
    }

    public static int checkString(String a, String b) {
        int result = 0;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.indexOf(b.charAt(i)) == -1) {
                    result++;
                }
            }
        } else {
            result = -1;
        }
        return result;
    }
}
