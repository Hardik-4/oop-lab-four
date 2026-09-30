import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Contacts implements Iterator<User<?>>, ContactsInterface {

    private Set<User<?>> users = new HashSet<>();
    private Iterator<User<?>> iterator;

    public Contacts() {
        iterator = users.iterator();
    }

    @Override
    public boolean addUser(User<?> user) {
        boolean added = users.add(user);
        resetIterator();
        return added;
    }

    @Override
    public boolean removeUser(User<?> user) {
        boolean removed = users.remove(user);
        resetIterator();
        return removed;
    }

    @Override
    public boolean containsUser(User<?> user) {
        return users.contains(user);
    }

    @Override
    public int size() {
        return users.size();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public User<?> next() {
        return iterator.next();
    }

    public void resetIterator() {
        iterator = users.iterator();
    }
}
// This class stores Users in a HashSet and allows adding, removing, checking, and iterating over users.
