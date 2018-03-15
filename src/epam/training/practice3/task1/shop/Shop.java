package epam.training.practice3.task1.shop;

import epam.training.practice3.task1.shop.etc.Product;
import epam.training.practice3.task1.shop.etc.Service;
import epam.training.practice3.task1.warehouse.Warehouse;
import epam.training.practice3.task1.shop.user.authentication.AuthenticationToken;
import epam.training.practice3.task1.shop.user.authentication.IllegalAuthenticationTokenException;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private List<Department> departments = new ArrayList<>();
    private Warehouse<Product> warehouse = new Warehouse<>();
    private AuthenticationToken token;

    public Shop(String name, AuthenticationToken token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void supplyProducts(Warehouse<Product> products) {
        warehouse.refillWith(products);
        distributeProducts();
    }

    public Warehouse<Product> getProductDemand() {
        Warehouse<Product> productDemand = new Warehouse<>();
        for (Department department : departments) {
            productDemand.refillWith(department.productsDemand);
        }
        return productDemand;
    }

    private void checkAuthentication(AuthenticationToken token) {
        if (!this.token.equals(token))
            throw new IllegalAuthenticationTokenException("Wrong authentication token!");
    }

    public void setName(String name, AuthenticationToken token) {
        checkAuthentication(token);
        this.name = name;
    }

    public Department addDepartment(String name, List<Service> services,
                                    AuthenticationToken directorToken, AuthenticationToken managerToken) {
        checkAuthentication(directorToken);
        if (services == null)
            return null;
        if (indexOfDepartment(name) >= 0)
            return null;
        Department newDepartment = new Department(name, services, managerToken);
        departments.add(newDepartment);
        return newDepartment;
    }

    public boolean removeDepartment(String name, AuthenticationToken token) {
        checkAuthentication(token);
        int index = indexOfDepartment(name);
        if (index < 0) {
            return false;
        }

        Department removed = departments.get(index);
        warehouse.refillWith(removed.departmentProducts);
        departments.remove(index);
        distributeProducts();
        return true;
    }

    private int indexOfDepartment(String name) {
        for (int i = 0; i < departments.size(); i++) {
            Department department = departments.get(i);
            if (department.name.equals(name)) {
                return i;
            }
        }

        return -1;
    }

    private void distributeProducts() {
        for (Department department : departments) {
            department.supplyProducts();
        }
    }

    public class Department {
        private String name;
        private List<Service> services = new ArrayList<>();
        private Warehouse<Product> departmentProducts = new Warehouse<Product>();
        private Warehouse<Product> productsDemand = new Warehouse<Product>();
        AuthenticationToken token;

        private Department(String name, List<Service> services, AuthenticationToken token) {
            this.token = token;
            this.name = name;
            this.services = services;
        }

        public String getName() {
            return name;
        }

        public void demandProduct(Product product, double amount, AuthenticationToken token) {
            checkAuthentication(token);
            productsDemand.refillWith(product, amount);
        }

        public void addService(Service service, AuthenticationToken token) {
            checkAuthentication(token);
            services.add(service);
        }

        public void removeService(Service service, AuthenticationToken token) {
            checkAuthentication(token);
            services.remove(service);
        }

        private void checkAuthentication(AuthenticationToken token) {
            if (!this.token.equals(token))
                throw new IllegalAuthenticationTokenException("Wrong authentication token!");
        }

        private void supplyProducts() {
            productsDemand = warehouse.moveTo(departmentProducts, productsDemand);
        }
    }
}