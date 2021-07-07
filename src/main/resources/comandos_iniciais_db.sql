use boom;

/* INSERE AS CATEGORIAS E LEVELS INICIAIS PARA O FUNCIONAMENTO DA APLICAÇÃO */
insert into levels (color, description) values 
	('blue', 'level iniciante'), ('orange', 'level intermediário'), ('red', 'level avançado');
insert into categories (name, number_podcasts, total_views) values 
	('comédia', 0, 0), ('política', 0, 0), ('esportes', 0, 0), ('bate-papo', 0, 0);