import alert.AlertManager;
import alert.BasketAlert;
import alert.ContentAlert;
import customer.Guest;
import customer.Member;
import customer.Staff;
import customer.User;
import discount.*;
import product.Basket;
import product.Category;
import product.Product;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        AlertManager alertManager = AlertManager.getInstance();
        SaleManager saleManager = SaleManager.getInstance();

        Category catLivre = new Category("Livre");
        Category catDVD = new Category("DVD");
        Category catCD = new Category("CD");

        Product livreA = new Product(6.99f, "Recettes de grand-mère", 70);
        Product livreB = new Product(12.99f, "Catastrophes", 110);
        Product livreC = new Product(9.99f, "Apprendre le Java", 100);
        Product livreD = new Product(24.99f, "Star wars : l'histoire intégrale", 250);
        catLivre.addProductToCategory(livreA);
        catLivre.addProductToCategory(livreB);
        catLivre.addProductToCategory(livreC);
        catLivre.addProductToCategory(livreD);

        Product DVDA = new Product(15.99f, "Star wars", 200);
        Product DVDB = new Product(20, "Interstellar", 200);
        catDVD.addProductToCategory(DVDA);
        catDVD.addProductToCategory(DVDB);

        Product CDA = new Product(8.99f, "La marche impériale", 100);
        Product CDB = new Product(12.99f, "Imagine dragons intégrale", 130);
        catCD.addProductToCategory(CDA);
        catCD.addProductToCategory(CDB);

        User userGuest = new User(Guest.getInstance());
        User userStaff = new User(Staff.getInstance());
        User userLogin = new User(Guest.getInstance());

        CategoryDiscount DVDDiscount = new CategoryDiscount(DiscountLevel.MEMBER, catDVD, 0.15f);
        ProductDiscount CDADiscount = new ProductDiscount(DiscountLevel.STAFF, CDA, 0.4f);
        ArrayList<Product> discountable = new ArrayList<>();
        discountable.add(livreD);
        discountable.add(DVDA);
        BasketDiscount basketDiscount = new BasketDiscount(DiscountLevel.ALLUSERS, discountable, 5);
        saleManager.addItemSale(DVDDiscount);
        saleManager.addItemSale(CDADiscount);
        saleManager.addBasketSale(basketDiscount);

        ContentAlert<Product> alertA = new ContentAlert<>();
        alertA.addContentRequirement(DVDB, 4);
        BasketAlert alertB = new BasketAlert(100);
        alertManager.addAlertHandler(alertA);
        alertManager.addAlertHandler(alertB);

        userGuest.addToBasket(livreA, 1);
        userGuest.addToBasket(DVDB, 3);
        userGuest.addToBasket(CDA, 2);

        userStaff.addToBasket(CDA, 4);
        userStaff.addToBasket(CDB, 2);

        userLogin.addToBasket(DVDB, 4);
        userLogin.addToBasket(livreD, 1);
        userLogin.addToBasket(DVDA, 1);

        System.out.println("Prix de base de l'invité :"+userGuest.basket.calculateBasePrice()+"\n Prix avec réduction :"+userGuest.basket.calculateFinalPrice());
        System.out.println("Prix de base du staff :"+userStaff.basket.calculateBasePrice()+"\nPrix avec réduction :"+userStaff.basket.calculateFinalPrice());
        System.out.println("Prix sans être loggé de base :"+userLogin.basket.calculateBasePrice()+"\navec promotions :"+userLogin.basket.calculateFinalPrice());
        userLogin.login(Member.getInstance());
        System.out.println("Prix en étant membre :"+userLogin.basket.calculateFinalPrice());
        userLogin.basket.pay();
        userLogin.printLoyaltyPoints();

    }
}
