package org.sergeok.repository;

import org.sergeok.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.util.List;

@NoRepositoryBean
public interface ProductDAO<E extends Product>
        extends CrudRepository<E, Long> {

    @NonNull
    List<E> findAll();

    E findProductById(Long id);

    E findBySerialNumber(Long serialNumber);
    List<E> findByManufacturer(String manufacturer);
    List<E> findByPrice(Long price);
    List<E> findByUnitsInStock(Long unitsInStock);
}