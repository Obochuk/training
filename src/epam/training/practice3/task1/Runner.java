import shop.Shop;
import shop.etc.Product;
import shop.etc.Service;
import shop.user.Manager;
import shop.user.ShopDirector;
import warehouse.Warehouse;

public class Runner {
    public static void run() {
        ShopDirector director = new ShopDirector("directorPassword");
        director.createShop("Marmelad");
        Manager restaurantManager = director.addDepartment("Restoraunts", Service.RESTAURANTS);
        Manager entertainmentManager = director.addDepartment("Entertainment", Service.ENTERTAINMENTS);
        Manager poolManager = director.addDepartment("Pool", Service.POOL);
        Product apple = new Product("Apple");
        Product salt = new Product("Salt");
        restaurantManager.demandProduct(apple, 2_000_000);
        restaurantManager.demandProduct(salt, 5);
        Shop shop = director.getShop();
        Warehouse<Product> warehouse = shop.getProductDemand();
        System.out.println("Shop product demand before supply!");
        System.out.println(warehouse);
        System.out.println("\n\n\n\n");
        shop.supplyProducts(warehouse);
        System.out.println("Shop product demand after supply!");
        System.out.println(shop.getProductDemand());
    }
}
