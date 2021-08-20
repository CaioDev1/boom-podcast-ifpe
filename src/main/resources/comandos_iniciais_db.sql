use boom;

/* INSERE AS CATEGORIAS E LEVELS INICIAIS PARA O FUNCIONAMENTO DA APLICAÇÃO */
insert into levels (color, description, requirements) values 
	('blue', 'level iniciante', "Esse é o nível inicial do usuário quando entra na plataforma, o nível dos iniciantes dessa nova jornada!"), 
    ('orange', 'level intermediário', "Pelo menos um podcast lançado, um episódio publicado e um like em algum episódio dentro da plataforma"),
    ('red', 'level avançado', "Pelo menos DOIS podcasts lançados, DOIS episódios publicados e DOIS likes em alguns episódios dentro da plataforma");

insert into categories (name, number_podcasts, total_views) values 
	('comédia', 0, 0), ('política', 0, 0), ('esportes', 0, 0), ('bate-papo', 0, 0);