package LinkedList;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>
{
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                final T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    private class Node<T>
    {
        T data;
        Node<T> next, prev;

        public Node() { }

        public Node(
            final T data, Node<T> prev, Node<T> next )
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public String toString()
        {
            return data.toString();
        }
    }

    public void clear()
    {
        Node<T> trav = head;
        while ( trav != null ) {
            Node<T> next = trav.next;
            trav.next = null;
            trav.prev = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return  size() == 0;
    }

    public void add(T elem) { addLast( elem ); }

    public void addFirst(
            T elem )
    {
        if ( isEmpty() ) {
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(
            T elem )
    {
        if ( isEmpty() ) {
            head = tail = new Node<>(elem, null, null);
        } else {
            Node<T> aux = tail;
            tail = new Node<>(elem, tail, null);
            aux.next = tail;
        }
        size++;
    }

    public T peekFirst()
    {
        if (isEmpty())
            throw new RuntimeException("Empty List...");
        return head.data;
    }

    public T peekLast()
    {
        if ( isEmpty() )
            throw new RuntimeException();
        return tail.data;
    }

    public T removeFirst()
    {
        checkList();
        Node<T> oldFirstNode = head;
        head = head.next;
        head.prev = null;
        oldFirstNode.next = null;
        size--;
        if ( isEmpty() )
                tail = null;
        return oldFirstNode.data;
    }

    public T removeLast()
    {
        checkList();
        Node<T> oldLastNode = tail;
        tail = tail.prev;
        oldLastNode.prev = null;
        tail.next = null;

        size--;
        if ( isEmpty() )
            head = null;
        return oldLastNode.data;
    }

    private T remove(
            Node<T> node )
    {
        if ( node.prev == null )
            return removeFirst();
        if ( node.next == null )
            return removeLast();
        node.prev.next = node.next;
        node.next.prev = node.prev;
        final T data = node.data;
        node.data = null;
        node.next = node.prev = null;
        size--;
        return data;
    }

    public T removeAt(
            int index )
    {
        checkIndex( index );
        Node<T> trav;
        int i;

        if ( index < size/2 ) {
            for ( i = 0, trav = head; i != index; i++ ) {
                trav = trav.next;
            }
        } else {
            for ( i = size - 1, trav = tail; i != index; i-- ) {
                trav = trav.prev;
            }
        }
        return remove( trav );
    }

    public boolean remove(
            Object obj )
    {
        Node<T> trav = head;
        if ( obj == null ) {
            for ( ; trav != null; trav = trav.next ) {
                if ( trav.data == null ) {
                    remove( trav );
                    return true;
                }
            }
        }
        for ( ; trav != null; trav = trav.next ) {
            if ( obj.equals( trav.data) ) {
                remove( trav );
                return true;
            }
        }
        return false;
    }

    public int indexOf(
            Object obj )
    {
        Node<T> trav = head;
        int index = 0;
        if ( obj == null ) {
            for ( ; trav != null; trav = trav.next, index++ ) {
                if ( trav.data == null ) {
                    return index;
                }
            }
        } else {
            for ( ; trav != null; trav = trav.next, index++ ) {
                if ( obj.equals( trav.data ) ) {
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(
            Object obj )
    {
        return indexOf(obj) != -1;
    }

    private void checkIndex(
            int index )
    {
        if ( index < 0 || index >= size )
            throw new IllegalArgumentException( "Invalid index..." );
    }

    private void checkList()
    {
        if ( isEmpty() )
            throw new RuntimeException( "Empty List.." );
    }

}

