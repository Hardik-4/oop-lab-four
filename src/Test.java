//Hardik Rathee
//3173940

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        HashMap<User<?>, Contacts> group = new HashMap<>();

        try {
            User<Integer> u1 = new User<>("Ethan", "Hall", 55555);
            User<String> u2 = new User<>("Sophia", "Clark", "sophia@mail.com");
            User<Integer> u3 = new User<>("Mason", "Lee", 88888);

            Contacts c1 = new Contacts();
            Contacts c2 = new Contacts();

            group.put(u1, c1);
            group.put(u2, c2);
            group.put(u3, c1);

            c1.addUser(u1);
            c1.addUser(u2);
            c1.addUser(u3);
            c1.addUser(u1); // duplicate

            c2.addUser(u1);
            c2.addUser(u2);

            System.out.println("Contains Ethan? " + c1.containsUser(u1));
            c1.removeUser(u1);
            System.out.println("After removal: " + c1.containsUser(u1));

            c2.resetIterator();
            int phoneCount = 0;
            while (c2.hasNext()) {
                User<?> u = c2.next();
                if (u.getContact() instanceof Integer) {
                    phoneCount++;
                }
            }
            System.out.println("Phone users: " + phoneCount);

            User<Integer> u4 = new User<>("Sophia", "Clark", 99999);
            assert u2.equals(u4);
            assert u2.hashCode() == u4.hashCode();

            new User<String>("", "Fail", "x");

        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
// This class tests the User and Contacts classes.
// It adds users, removes them, checks equality, iterates, and handles exceptions.
