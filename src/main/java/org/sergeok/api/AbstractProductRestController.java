package org.sergeok.api;

import org.sergeok.entity.Product;
import org.sergeok.service.ProductService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class AbstractProductRestController <E extends Product,
        S extends ProductService<E>> implements ProductController<E> {

    private final S service;

//    @Autowired
    protected AbstractProductRestController(S service) {
        this.service = service;
    }

    @Override
    public List<E> getAllProducts() {
        return service.allProducts();
    }

    @Override
    public boolean addProduct(@RequestBody E requestedProduct) {
        if (requestedProduct.getSerialNumber() != null) {
            return service.createProduct(requestedProduct);
        }

        return false;
    }

    @Override
    public E getProductBySerialNumberOrId(@RequestBody E requestedProduct) {
        if (requestedProduct.getId() != null) {
            return service.readById(requestedProduct.getId());
        }

        if (requestedProduct.getSerialNumber() != null) {
            return service.readBySerialNumber(requestedProduct.getSerialNumber());
        }

        return null;
    }

    public List<E> getProductsByDefaultProperty(E requestedProduct) {
        if (requestedProduct.getManufacturer() != null) {
            return service.readByManufacturer(requestedProduct.getManufacturer());
        }
        if (requestedProduct.getPrice() != null) {
            return service.readByPrice(requestedProduct.getPrice());
        }
        if (requestedProduct.getUnitsInStock() != null) {
            return service.readByUnitsInStock(requestedProduct.getUnitsInStock());
        }

        return null;
    }
}
