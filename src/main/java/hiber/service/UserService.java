package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.net.CacheRequest;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> getUserOnCar(String model, int series);
}
