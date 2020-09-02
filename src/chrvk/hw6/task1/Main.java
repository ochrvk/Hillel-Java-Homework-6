package chrvk.hw6.task1;
/*
Написать метод который принимает 2 строки - a, b.
Метод должен вернуть количество символов которые у них различаются.
Если строки разной длины то вернуть -1.
Примеры:
a="asdf", b="qwerty" => -1
a="abb", b="bba" => 0
a="abc", b="dca" => 1
a="aaa", b="fga" => 2
a="abc", b="dfg" => 3
*/

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
