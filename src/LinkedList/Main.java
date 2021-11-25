package LinkedList;

public class Main
{
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add( 45 );
        list.addLast( 12 );
        list.addLast( 12 );
        list.addLast( 6 );
        list.addFirst( 37 );
        list.addLast( 52 );
        list.addLast( 99 );

        System.out.println("First element "+list.peekFirst().toString() );
        System.out.println("Last element "+list.peekLast().toString() );

        list.forEach( System.out::println );

        System.out.println( "Removing first element "+list.removeFirst() );
        System.out.println( "Removing last element "+list.removeLast() );

        list.forEach( System.out::println );

        System.out.println( "Index of element 6 is "+list.indexOf( Integer.valueOf(6) ) );
        System.out.println( "Contains element 12 "+list.contains(Integer.valueOf(12))  );
        System.out.println( "Contains element 13 "+list.contains(Integer.valueOf(13))  );
        System.out.println( "Remove element of index 3 that is "+list.removeAt(3));
    }
}
