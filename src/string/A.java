package string;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class A{

    static int count = 1;

    static int totalAfterYear(int year) {
        for (int i = 0; i <= year; i++) {
            if (i == 2 || i == 4) {
                count++;
                totalAfterYear(year - i);
            }
            if (i == 5) {
                count--;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) throws ScriptException {
        System.out.println(totalAfterYear(15));

    }
}
