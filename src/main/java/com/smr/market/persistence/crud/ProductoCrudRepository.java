package com.smr.market.persistence.crud;

import com.smr.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findBtIdCategoriaOrderByNombreAsc (int idCategoria);
    Optional<List<Producto>> findBycantidadStokLessThenAndEstado(int cantidadStok, boolean estado);
}
