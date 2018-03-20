package shop.user;

import shop.etc.Product;
import shop.etc.Service;
import shop.Shop;
import shop.user.authentication.AuthenticationToken;

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
