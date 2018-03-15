package epam.training.practice3.task1.shop.user;

import epam.training.practice3.task1.shop.etc.Product;
import epam.training.practice3.task1.shop.etc.Service;
import epam.training.practice3.task1.shop.Shop;
import epam.training.practice3.task1.shop.user.authentication.AuthenticationToken;

public class Manager {
    private Shop.Department department;
    private AuthenticationToken token;

    public Manager(Shop.Department department, AuthenticationToken token) {
        this.department = department;
        this.token = token;
    }

    public void demandProduct(Product product, double amount) {
        department.demandProduct(product, amount, token);
    }

    public void addService(Service service) {
        department.addService(service, token);
    }

    public void removeService(Service service) {
        department.removeService(service, token);
    }
}
