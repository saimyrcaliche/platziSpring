package com.smr.market.domain.repository;

import com.smr.market.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getAll();
    Optional<Category> getByCategory(int categoryId);
    Category save (Category category);
    void delete (int categoryId);
}
