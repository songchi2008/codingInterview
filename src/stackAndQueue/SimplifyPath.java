package stackAndQueue;

import java.util.Collections;
import java.util.Stack;

/**
 * 简化路径
 */
public class SimplifyPath {
    public static String simplifyPath(String path){
        // 1.先将路径用"/"分割,让后依次压栈
        // 2.遍历数组,如果元素为""或者. 直接跳过
        //       如果为文件名,将文件名压栈
        //       如果为..并且栈不为空,弹栈
        // 将栈倒序,然后依次弹栈,弹一个加一个"/"
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (String str : arr) {
            if("".equals(str)||".".equals(str)){
                continue;
            }else if("..".equals(str)&&!stack.isEmpty()){
                stack.pop();
            }else{
                stack.push(str);
            }
        }
        Collections.reverse(stack);
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pop()).append("/");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../../"));
        System.out.println(simplifyPath("/home//foo//"));
        System.out.println(simplifyPath("a/./b/../../../c/d/"));
    }

}
