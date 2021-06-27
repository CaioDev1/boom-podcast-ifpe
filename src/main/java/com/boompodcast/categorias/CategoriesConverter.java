package com.boompodcast.categorias;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CategoriesConverter implements AttributeConverter<Categories, Integer> {
	@Override
	 public Integer convertToDatabaseColumn(Categories categories) {
		return categories.getId();
	 }
	
	 @Override
	 public Categories convertToEntityAttribute(Integer categories) {
		Categories c = new Categories();
		c.setId(categories);
		
		return c;
	 }
}
