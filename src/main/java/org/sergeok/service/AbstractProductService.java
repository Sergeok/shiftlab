package org.sergeok.service;

import org.sergeok.entity.Product;
import org.sergeok.repository.ProductDAO;

import java.util.List;

public abstract class AbstractProductService <E extends Product,
        R extends ProductDAO<E>> implements ProductService<E> {

    private final R DAO;

    public AbstractProductService(R DAO) {
        this.DAO = DAO;
    }

    public List<E> allProducts() {
        return DAO.findAll();
    }

    public boolean createProduct(E product) {
        E pcFromDB = DAO.findBySerialNumber(product.getSerialNumber());
        if (pcFromDB != null) {
            return false;
        }

        product.setId(null);
        DAO.save(product);
        return true;
    }

    public E readById(Long id) {
        return DAO.findProductById(id);
    }

    public E readBySerialNumber(Long serialNumber) {
        return DAO.findBySerialNumber(serialNumber);
    }

    public List<E> readByManufacturer(String manufacture) {
        return DAO.findByManufacturer(manufacture);
    }

    public List<E> readByPrice(Long price) {
        return DAO.findByPrice(price);
    }

    public List<E> readByUnitsInStock(Long unitsInStock) {
        return DAO.findByUnitsInStock(unitsInStock);
    }

    public E defaultUpdateBySerialNumber(E product) {
        E productFromDB = DAO.findBySerialNumber(product.getSerialNumber());
        if (productFromDB == null) {
            return null;
        }

        if (product.getManufacturer() != null) {
            productFromDB.setManufacturer(product.getManufacturer());
        }
        if (product.getPrice() != null) {
            productFromDB.setPrice(product.getPrice());
        }
        if (product.getUnitsInStock() != null) {
            productFromDB.setUnitsInStock(product.getUnitsInStock());
        }

        return productFromDB;
    }
}