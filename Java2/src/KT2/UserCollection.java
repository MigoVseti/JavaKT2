package KT2;

import java.util.*;
import java.util.stream.Collectors;

public class UserCollection {
    private List<User> users;

    public UserCollection() {
        users = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean editUser(int id, String newName, int newAge) {
        Optional<User> userOptional = getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.name = newName;
            user.age = newAge;
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        Optional<User> userOptional = getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            users.remove(user);
            return true;
        }
        return false;
    }

    public List<String> getNamesAndAges() {
        return users.stream()
                .map(user -> user.getName() + " - " + user.getAge())
                .collect(Collectors.toList());
    }


    public int getMinimumAge() {
        return users.stream()
                .mapToInt(User::getAge)
                .min()
                .orElse(0);
    }

    public int getMaximumAge() {
        return users.stream()
                .mapToInt(User::getAge)
                .max()
                .orElse(0);
    }


    public boolean hasNameStartingWithJ() {
        return users.stream()
                .anyMatch(user -> user.getName().startsWith("J"));
    }

//    Пару методова не получилось реализовать поэтому я решил от себя добавить эти два
    public Optional<User> getUserWithLongestName() {
        return users.stream()
                .max(Comparator.comparingInt(user -> user.getName().length()));
    }
    public Optional<User> getUserWithSmallestName() {
        return users.stream()
                .min(Comparator.comparingInt(user -> user.getName().length()));
    }
}

