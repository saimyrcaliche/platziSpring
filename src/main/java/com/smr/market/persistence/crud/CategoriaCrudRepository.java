package com.smr.market.persistence.crud;

import com.smr.market.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {
}
