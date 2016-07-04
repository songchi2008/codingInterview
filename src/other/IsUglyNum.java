package other;

/**
 * 判断一个数是否为丑数,丑数是只能被2,3,5整除的数,1也是丑数
 */
public class IsUglyNum {
    public static boolean isUglyNum(int num){
        int n= num;
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        //  1.不断的除以2,直到除不尽,然后除以3直到除不尽,最后除以5
        while (n%2==0){
            n=n/2;
        }
        while (n%3==0){
            n=n/3;
        }
        while (n%5==0){
            n=n/5;
        }
        if(n==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUglyNum(180));
        System.out.println(isUglyNum(42));
        System.out.println(isUglyNum(12));
        System.out.println(isUglyNum(125));
    }
}
