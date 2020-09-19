package com.smr.market.persistence;

import com.smr.market.domain.Product;
import com.smr.market.domain.repository.ProductRepository;
import com.smr.market.persistence.crud.ProductoCrudRepository;
import com.smr.market.persistence.entity.Producto;
import com.smr.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository crudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) crudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = crudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = crudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prs -> mapper.toProducts(prs));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return crudRepository.findById(productId).map(pr -> mapper.toProduct(pr));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(crudRepository.save(producto));
    }

    @Override
    public void delete (int productId){
        crudRepository.deleteById(productId);
    }
}
