package org.sergeok.service;

import org.sergeok.entity.Product;

import java.util.List;

public interface ProductService<E extends Product> {
    List<E> allProducts();

    boolean createProduct(E pc);

    E readById(Long id);

    E readBySerialNumber(Long serialNumber);

    List<E> readByManufacturer(String manufacture);
    List<E> readByPrice(Long price);
    List<E> readByUnitsInStock(Long unitsInStock);

    boolean updateBySerialNumber(E laptop);
}
