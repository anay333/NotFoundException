package domain;

import manager.ProductManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ProductManagerTest {
    private ProductRepository productRepository = new ProductRepository();
    private ProductManager productManager = new ProductManager(productRepository);
    private Product first = new Book(1, "Lion", 50, "King");
    private Product second = new Book(2, "Window", 33, "Lee");
    private Product third = new Smartphone(3, "Huawei", 300, "China");
    private Product fourth = new Smartphone(4, "Lion", 500, "UK");

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(fourth);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] actual = productManager.searchBy("King");
        Product[] expected = {first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameBook() {

        Product[] actual = productManager.searchBy("Window");
        Product[] expected = {second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {

        Product[] actual = productManager.searchBy("Huawei");
        Product[] expected = {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWhenNotOneResult() {

        Product[] actual = productManager.searchBy("Lion");
        Product[] expected = {first, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {

        Product[] actual = productManager.searchBy("China");
        Product[] expected = {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNothing() {

        Product[] actual = productManager.searchBy("Road");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

}