package com.smr.market.persistence;

import com.smr.market.domain.Category;
import com.smr.market.domain.repository.CategoryRepository;
import com.smr.market.persistence.crud.CategoriaCrudRepository;
import com.smr.market.persistence.entity.Categoria;
import com.smr.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {
    @Autowired
    private CategoriaCrudRepository crudRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) crudRepository.findAll();
        return mapper.toCategorys(categorias);
    }

    @Override
    public Optional<Category> getByCategory(int categoryId) {
        return crudRepository.findById(categoryId).map(ct -> mapper.toCategory(ct));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(crudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        crudRepository.deleteById(categoryId);
    }
}
