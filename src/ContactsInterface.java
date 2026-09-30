public interface ContactsInterface {
    boolean addUser(User<?> user);
    boolean removeUser(User<?> user);
    boolean containsUser(User<?> user);
    int size();
}
