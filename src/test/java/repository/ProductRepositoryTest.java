package repository;

import domain.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import domain.Book;
import domain.Product;
import domain.Smartphone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository productRepository = new ProductRepository();
    private Product first = new Book(1, "Lion", 50, "King");
    private Product second = new Book(2, "Window", 33, "Lee");
    private Product third = new Smartphone(3, "Huawei", 300, "China");
    private Product fourth = new Smartphone(4, "Lion", 500, "UK");

    @BeforeEach
    public void setUp() {
        productRepository.save(first);
        productRepository.save(second);
        productRepository.save(third);
        productRepository.save(fourth);
    }


    @Test
    void shouldRemoveById() {
        productRepository.removeById(1);
        Product[] expected = {second, third, fourth};
        Product[] actual = productRepository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldNotFoundException() {
        assertThrows(NotFoundException.class, () -> {
            productRepository.removeById(6);
        });

    }

}