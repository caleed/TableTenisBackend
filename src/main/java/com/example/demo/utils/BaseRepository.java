package com.example.demo.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

    default T findByIdRequired(ID id) {
        Optional<T> entity = this.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Not Found");
        }
    }
}
