package recursive;

/**
 * 猴子吃桃递归解法
 *
 * 开始调用哪个函数，该函数就压栈；
 调用完毕，该函数就弹栈。

 */

// 当f(1)弹栈后,f(2)紧接着弹栈,f(2)弹完f(3)弹.....
public class MonkeyEatFruit {
    public static int eat02(int n){
        System.out.println("f("+n+")压栈");
        if(n==1){
            System.out.println("此时函数栈到达最大深度");
            System.out.println("f("+n+")弹栈");
            return 1;
        }else{
            int a = eat02(n-1)*2+2;
            System.out.println("f("+n+")弹栈");
            return a;
        }
    }

    public static void main(String[] args) {
        int a=eat02(10);
        System.out.println("总桃树为: "+a);
    }

}
