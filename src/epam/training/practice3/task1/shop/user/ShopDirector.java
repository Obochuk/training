package shop.user;

import shop.etc.Service;
import shop.Shop;
import shop.user.authentication.AuthenticationToken;

import java.util.Arrays;
import java.util.List;

public class ShopDirector {
    private Shop shop;
    private AuthenticationToken token;

    public ShopDirector(String password) {
        token = new AuthenticationToken(password);
    }

    public void createShop(String name) {
        synchronized (this) {
            if (shop == null)
                shop = new Shop(name, token);
        }
    }

    public Shop getShop() {
        return shop;
    }

    public Manager addDepartment(String name, Service... services) {
        String password = "password";       // TODO password generator
        AuthenticationToken managerToken = new AuthenticationToken(password);
        List<Service> serviceList = Arrays.asList(services);
        Shop.Department department = shop.addDepartment(name, serviceList, token, managerToken);
        return new Manager(department, managerToken);
    }

    public boolean removeDepartment(String name) {
        return shop.removeDepartment(name, token);
    }

}
