package stackAndQueue;


public class CircularArrayQueue {

    private Object[] contents;
    private int front,rear;//front为队头下标，rear为队尾的下一个元素的下标
    private int count;//标记队列元素个数
    private static int SIZE = 10;
    
    

    public static void main(String[] args) {
        
        CircularArrayQueue circlequeue = new CircularArrayQueue();
        
        System.out.println("将0到7依次入队，然后连续4次出队");
        
        for(int i = 0;i < 8;i++)
            circlequeue.enqueue(i);
        for(int i = 0;i < 4;i++)
            circlequeue.dequeue();
        System.out.println("队首元素为： " + circlequeue.first());
        System.out.println("队首元素下标为： " + circlequeue.front);
        System.out.println("队尾元素下标为： " + circlequeue.rear);
        System.out.println("队列大小为： " + circlequeue.count + "\n");
        
        System.out.println("再向队列中加入从8到11");
        for(int i = 8;i < 12;i++)
            circlequeue.enqueue(i);
        System.out.println("队首元素为： " + circlequeue.first());
        System.out.println("队首元素下标为： " + circlequeue.front);
        System.out.println("队尾元素下标为： " + circlequeue.rear);
        System.out.println("队列大小为： " + circlequeue.count);
    }

    
    public CircularArrayQueue()
    {
        contents = new Object[SIZE];
        front = -1;
        rear = 0;
        count = 0;
    }
    
    public int size(){
        return count;
    }
    
    public boolean isEmpty(){
        return (size() == 0);
    }
    
    public void enqueue(Object element){
        
        if(size() == 0)//默认如果数组中没有元素，则从0开始进队，这样简化问题的考虑
        {
            contents[0] = element;
            front = 0;
            rear = 1;
            //rear++   错误，经过一些进队出队操作后rear可能在别的位置了
            count++;
        }
        else
        {
            contents[rear] = element;
            rear = (rear + 1) % contents.length;
            //rear = (rear + 1) % size(); 错误
            count++;
        }
    }
    
    public Object dequeue(){
        if(isEmpty())
        {
            System.out.println("队列为空！！！");
            System.exit(1);
        }
        
        Object result = contents[front];
        
        contents[front] = null;//可要可不要，下次覆盖也可
        front = (front + 1) % contents.length;
        //front = (front + 1) % size(); 错误
        count--;
        
        return result;    
    }
    
    public Object first(){
        return contents[front];
    }
    
}