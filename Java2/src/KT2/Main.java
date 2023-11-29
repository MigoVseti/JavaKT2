package KT2;

import java.util.List;

public class Main {
    public static void main(String[] args){

        UserCollection userCollection = new UserCollection();
        List<User>allUsers = userCollection.getAllUsers();
        userCollection.addUser(new User(1, "David", 25));
        userCollection.addUser(new User(2, "Antonio", 30));
        userCollection.addUser(new User(3, "Horhe", 22));
        System.out.println(allUsers);
        userCollection.editUser(2, "Migran", 18);
        System.out.println(allUsers);
        userCollection.deleteUser(1);
        System.out.println(allUsers);
        System.out.println(userCollection.getNamesAndAges());
        System.out.println(userCollection.getUserWithLongestName());
        System.out.println(userCollection.getUserWithSmallestName());
        System.out.println(userCollection.getMinimumAge());
        System.out.println(userCollection.getMaximumAge());
        userCollection.addUser(new User(4, "Jamshyt", 13));
        System.out.println(userCollection.hasNameStartingWithJ());
    }
}
