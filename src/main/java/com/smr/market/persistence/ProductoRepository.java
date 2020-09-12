package com.smr.market.persistence;

import com.smr.market.persistence.crud.ProductoCrudRepository;
import com.smr.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository crudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) crudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return crudRepository.findBtIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos (int cantidad){
        return crudRepository.findBycantidadStokLessThenAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto (int id_producto){
        return crudRepository.findById(id_producto);
    }

    public Producto save(Producto producto){
        return crudRepository.save(producto);
    }

    public void delete (int idProducto){
        crudRepository.deleteById(idProducto);
    }
}
