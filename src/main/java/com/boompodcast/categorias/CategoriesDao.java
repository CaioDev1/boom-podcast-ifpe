package com.boompodcast.categorias;

import org.springframework.data.jpa.repository.JpaRepository;

//Data Access Object 
public interface CategoriesDao extends JpaRepository<Categories, Integer>{
	/* public Categories findById(Integer id); */
}
