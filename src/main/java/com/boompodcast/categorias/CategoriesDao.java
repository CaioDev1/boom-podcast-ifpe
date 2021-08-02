package com.boompodcast.categorias;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDao extends JpaRepository<Categories, Integer>{
	@Transactional
	@Modifying
	@Query("UPDATE Categories t SET t.totalViews = t.totalViews + 1 WHERE t.id = :categoriesId")
	public void incrementTotalViews(@Param("categoriesId") Integer categoriesId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Categories t SET t.numberPodcasts = t.numberPodcasts + 1 WHERE t.id = :categoriesId")
	public void incrementNumberPodcasts(@Param("categoriesId") Integer categoriesId);
}
