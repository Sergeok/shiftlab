package org.sergeok.api;

import org.sergeok.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface ProductController<E extends Product> {
    @GetMapping("/all")
    @ResponseBody
    List<E> getAllProducts();

    @PostMapping("/all")
    @ResponseBody
    List<E> getProductsByProperty(@RequestBody E requestedProduct);

    @PostMapping("/add")
    @ResponseBody
    boolean addProduct(@RequestBody E requestedProduct);

    @PostMapping("/find")
    @ResponseBody
    E getProductBySerialNumberOrId(@RequestBody E requestedProduct);

    @PostMapping("/update")
    @ResponseBody
    boolean setProduct(@RequestBody E requestedProduct);
}
