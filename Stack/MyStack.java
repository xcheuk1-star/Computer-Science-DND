import java.util.LinkedList;

public class MyStack<E> {
    private boolean empty;
    private LinkedList<E> list;

    public MyStack() {
        list = new LinkedList<E>();
        this.empty = true;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean push(E obj) {
        list.addLast(obj);
        this.empty = false;
        return true;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E toReturn = list.getLast();
        list.removeLast();
        if (list.size() == 0) {
            this.empty = true;
        }
        return toReturn;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return list.getLast();
    }

}
