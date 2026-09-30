import java.util.Objects;

public class User<T> implements Comparable<User<?>> {

    private String firstname;
    private String surname;
    private T contact;

    public User(String firstname, String surname, T contact) {
        if (firstname == null || firstname.isEmpty() ||
                surname == null || surname.isEmpty()) {
            throw new RuntimeException("Firstname or surname invalid");
        }
        this.firstname = firstname;
        this.surname = surname;
        this.contact = contact;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public T getContact() {
        return contact;
    }

    @Override
    public int compareTo(User<?> o) {
        int first = this.firstname.compareTo(o.firstname);
        if (first != 0) return first;
        return this.surname.compareTo(o.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User<?>)) return false;
        User<?> user = (User<?>) o;
        return firstname.equals(user.firstname) &&
                surname.equals(user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, surname);
    }

    @Override
    public String toString() {
        return firstname + " " + surname + " : " + contact;
    }
}
// This class represents a User with firstname, surname and a generic contact.
// It allows comparing, checking equality, and printing user info.
