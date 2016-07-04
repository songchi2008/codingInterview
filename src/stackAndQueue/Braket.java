package stackAndQueue;

import java.util.Stack;

/**
 * 括号匹配问题的求解
 * <p>
 * 1.如果遇到正括号,则压栈操作
 * 2.如果遇到的是反括号,则将栈顶元素弹出看是不是匹配
 * 3.全部匹配的话,最后栈一定是空栈
 */
public class Braket {

    public static void main(String[] args) {
        String str = "{[()]}";
        System.out.println("括号是否匹配  " + isMatch(str));

    }

    public static boolean isMatch(String str) {
        char[] charAry = str.toCharArray();
        Stack<Character> sk = new Stack<>();
        for (int i = 0; i < charAry.length; i++) {
            if (charAry[i] == '(') {
                sk.push('(');
            }
            if (charAry[i] == ')') {
                if (!sk.isEmpty() && sk.pop() == '(') {
                    continue;
                } else {
                    return false;
                }
            }

            if (charAry[i] == '[') {
                sk.push('[');
            }
            if (charAry[i] == ']') {
                if (!sk.isEmpty() && sk.pop() == '[') {
                    continue;
                } else {
                    return false;
                }
            }

            if (charAry[i] == '{') {
                sk.push('{');
            }
            if (charAry[i] == '}') {
                if (!sk.isEmpty() && sk.pop() == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (sk.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
