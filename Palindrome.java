//package palindrome;
import java.util.Scanner;

class Node
{


    //attributes
    private Object data;
    private Node next;


    //constructor
    public Node(Object dat0)
    {
        this.setData(dat0);
        this.setNext(null);
    }

    /*public Node()
    {
        this(null);
    }*/


    //destructor
    @Override
    protected void finalize()
    {
        //System.out.println("  "+this + " is marked for deletion by the Garbage Collector <done destroyed> \n");
        this.setNext(null);
        this.setData(null);
    }


    //seter and geter

    /**
     * @return the data
     */
    public Object getData() {
        return this.data;
    }


    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }


    /**
     * @return the next
     */
    public Node getNext() {
        return this.next;
    }


    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }


    // toString method
    @Override
    public String toString()
    {
        return ( "Node data : " + this.getData() );
        //return ( "" + this.getData() );
    }


    // class level methods
    public static Node getNode(Object dat0)
    {
        return new Node(dat0);
    }

    /*public static Node getNode()
    {
        return  Node.getNode(null);
    }*/


}


class Stack
{


    //attributes
    private Node top;
    private int size=0;


    //constructor
    public Stack()
    {
      this.setTop(null);
    }


    //destructor
    @Override
    protected void finalize()
    {
        System.out.println("  "+this + " is marked for deletion by the Garbage Collector <done destroyed> \n");
        while(!this.isEmpty())this.pop();
    }


    //methods for user

    public void push(Object data)
    {
        size++;
        Node temp=Node.getNode(data);
        if(!this.isEmpty())
        {
            temp.setNext(this.getTop());
        }

        this.setTop(temp);
    }


    public Object pop()
    {
        Object err=null;
        if(!this.isEmpty())
        {
            Node temp=this.getTop();
            this.setTop(this.getTop().getNext());
            err=temp.getData();
            temp=null;
            size--;
        }
        return err;
    }


    public Object getTopData()
    {
       if(!this.isEmpty()) return this.getTop().getData();
       return null;
    }


    //seter and geter

    /**
     * @return the top
     */
    public Node getTop() {
        return this.top;
    }


    /**
     * @param top the top to set
     */
    public void setTop(Node top) {
        this.top = top;
    }


    /**
     * @return the size
     */
    public int getSize() {
        return this.size;
    }


    // toString method
    @Override
    public String toString()
    {
     return  "< Stack >";
    }


    //boolean methods

    boolean isEmpty()
    {
        return (this.getTop() == null);
    }


    boolean isFull()
    {
       return false;
    }


    // class level methods
    public static Stack getStack()
    {
        return new Stack();
    }


}


class Queue
{


    //attributes
    private Node front;
    private Node rear;
    private int size=0;


    //constructor
    public Queue()
    {
        this.setFront(null);
        this.setRear(null);
    }


    //destructor
    @Override
    protected void finalize()
    {
        System.out.println("  "+this + " is marked for deletion by the Garbage Collector <done destroyed> \n");
        while(!this.isEmpty())this.qRemove();
    }


    //methods for user

    public void qAdd(Object data)
    {
        size++;
        Node temp=Node.getNode(data);
        if(!this.isEmpty())
        {
            this.getRear().setNext(temp);
        }
        else
        {
            this.setFront(temp);
        }
        this.setRear(temp);
    }


    public Object qRemove()
    {
        Object err=null;
        if(!this.isEmpty())
        {
            Node temp=this.getFront();
            this.setFront(this.getFront().getNext());
            err=temp.getData();
            temp=null;
            size--;
        }
        return err;
    }


    public Object getFrontData()
    {
        if(!this.isEmpty()) return this.getFront().getData();
        return null;
    }


    public Object getRearData()
    {
        if(!this.isEmpty()) return this.getRear().getData();
        return null;
    }


    //seter and geter

    /**
     * @return the front
     */
    public Node getFront() {
        return this.front;
    }


    /**
     * @param front the front to set
     */
    public void setFront(Node front) {
        this.front = front;
    }


    /**
     * @return the rear
     */
    public Node getRear() {
        return this.rear;
    }


    /**
     * @param rear the rear to set
     */
    public void setRear(Node rear) {
        this.rear = rear;
    }


    /**
     * @return the size
     */
    public int getSize() {
        return this.size;
    }


    // toString method
    @Override
    public String toString()
    {
     return  "< Queue >";
    }


    //boolean methods

    boolean isEmpty()
    {
        return (this.getFront() == null);
    }


    boolean isFull()
    {
       return false;
    }


    // class level methods
    public static Queue getQueue()
    {
        return new Queue();
    }


 }


 public class Palindrome
{


    private static Stack s=Stack.getStack();
    private static Queue q=Queue.getQueue();


    static boolean isPalindrome(Long data)
    {
        while(!s.isEmpty())s.pop();
        while(!q.isEmpty())q.qRemove();

       while( data != 0)
       {
           s.push(data%10);
           q.qAdd(data%10);
           data=data/10;
       }

       boolean b=true;

       while((!s.isEmpty()) && (!q.isEmpty()) && (b == true))
       {
           if(s.pop() != q.qRemove()){ b=false; }
       }

       while(!s.isEmpty())s.pop();
       while(!q.isEmpty())q.qRemove();

       return b;
    }


    static boolean isPalindrome(String data)
    {
        while(!s.isEmpty())s.pop();
        while(!q.isEmpty())q.qRemove();

        for(int i=0;i<data.length();i++)
        {
           s.push(data.charAt(i));
           q.qAdd(data.charAt(i));
        }

       boolean b=true;

       while((!s.isEmpty()) && (!q.isEmpty()) && (b == true))
       {
           if(s.pop() != q.qRemove()){ b=false; }
       }

       while(!s.isEmpty())s.pop();
       while(!q.isEmpty())q.qRemove();

       return b;
    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        try
        {

        System.out.println("\n  index of program : ");
        System.out.println("\n  1- check if the number is palindrome");
        System.out.println("  2- check if the string is palindrome");
        System.out.println("  3- exit from program");

        int select=0;

        while(select != 3)
        {

        System.out.println("\n  .........................................................");
        System.out.print("\n  please enter option : ");
        select=input.nextInt();

        switch(select)
        {

            case 1:
            {

                Scanner inputI = new Scanner(System.in);
                System.out.print("\n  please enter a positive integer number : ");
                long num=inputI.nextLong();

                if(Palindrome.isPalindrome(num))
                {
                    System.out.println("\n  the number is palindrome");
                }
                else
                {
                    System.out.println("\n  the number is not palindrome");
                }

                inputI=null;

               break ;
            }

            case 2:
            {

                Scanner inputI = new Scanner(System.in);
                System.out.print("\n  please enter a string : ");
                String str =inputI.nextLine();

                if(Palindrome.isPalindrome(str))
                {
                    System.out.println("\n  the string is palindrome");
                }
                else
                {
                    System.out.println("\n  the string is not palindrome");
                }

                str=null;
                inputI=null;

               break ;
            }

            case 3:
            {
                System.out.println("\n  thank you for use my program :) ");
                System.out.println("\n  .........................................................");
               break ;
            }

            default :
            {
                System.out.println("\n  invalid selection");
            }


        }


        }



        }

        catch(Exception err)
        {
            System.out.println("\n\n  .........................................................");
            System.out.println("\n  user input error (go out) ");
            System.out.println("\n  .........................................................");
        }

        finally
        {
        input=null;
        s=null;
        q=null;

        System.out.println("\n");

        System.gc();
        //Runtime.getRuntime().gc();
        System.exit(0);
        }
    }


}