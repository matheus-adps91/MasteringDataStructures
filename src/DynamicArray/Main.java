package DynamicArray;


import java.util.Iterator;

public class Main
{
    public static void main(String[] args) {

        DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>(5);

        dynamicArray.add( 1 );
        dynamicArray.add( 2 );
        dynamicArray.add( 3 );
        dynamicArray.add( 4 );
        dynamicArray.add( 5 );

        for (Integer next : dynamicArray) {
            System.out.print(next + ", ");
        }

        System.out.println( "Is empty ? "+ dynamicArray.isEmpty() );
        System.out.println( "Has integer 5 ? "+ dynamicArray.contains(5) );

    }
}
