[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]


<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/CaioDev1/boom-podcast-ifpe">
    <img src="src/main/resources/static/boom_podcast_icon.png" alt="Logo">
  </a>

  <h3 align="center">Boom Podcasts</h3>

  <p align="center">
    Uma plataforma de podcasts e conteúdos de áudio desenvolvido com Java e Spring Boot em seu coração.
    <br />
    <a href="http://boompodcasts.herokuapp.com"><strong>Abrir app »</strong></a>
    <br />
    <br />
    <a href="https://github.com/CaioDev1/boom-podcast-ifpe/issues">Reportar Bug</a>
    .
    <a href="https://github.com/CaioDev1/boom-podcast-ifpe/issues">Requisitar funcionalidades</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Sumário</summary>
  <ol>
    <li>
      <a href="#sobre-o-projeto">Sobre o projeto</a>
      <ul>
        <li><a href="#feito-utilizando">Feito utilizando</a></li>
      </ul>
    </li>
    <li>
      <a href="#iniciando">Iniciando</a>
      <ul>
        <li><a href="#instalação">Instalação</a></li>
      </ul>
    </li>
    <li><a href="#mais-informações">Mais Informações</a></li>
    <li><a href="#licença">Licença</a></li>
    <li><a href="#contato">Contato</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
<h2 id="sobre-o-projeto">💡 Sobre o projeto</h2>

[![Product Name Screen Shot][product-screenshot]](https://mindzone.herokuapp.com/)

O Boom Podcasts é uma plataforma de áudio onde usuários podem se sentir livres para consumir seus conteúdos de interesse e sinta-se incentivado a postar seus projetos e compartilha-los com outros usuários, podendo esses usuários também filtrar seus podcasts desejados, dar feedbacks dos episódios publicados e usufuir de um sistema "gameficado" e ranqueado por níveis, baseado no seu desempenho na plataforma como produtor e consumidor.

[![Product Name Screen Shot2][product-screenshot2]](https://mindzone.herokuapp.com/)

* Plataforma gameficada
* Poste e consuma conteúdos
* Navegue entre os conteúdos em alta
* Filtre podcasts por categorias
* Compare seu desempenho com outros usuários

[![Product Name Screen Shot3][product-screenshot3]](https://mindzone.herokuapp.com/)

<h3 id="feito-utilizando">🔧 Feito Utilizando</h3>

Para o funcionamento da aplicação, foi utilizado a linguagem Java acompanhado do Spring Boot para implementação do servidor, JPA com Hibernate para manipulação do banco de dados relacional MySQL somado ao AWS RDS na nuvem. Como template engine, Thymeleaf, já na segurança, foi utilizando o BCrypt para hashing de dados sensíveis e interceptadores do Spring Boot para uso de sessões.

Firebase Storage para a manipulação de arquivos brutos da aplicação através de um bucket na nuvem.

Segue a lista de ferramentas:
* [Spring Boot](https://spring.io/)
* [Thymeleaf](https://www.thymeleaf.org/)
* [Hibernate](https://hibernate.org/)
* [AWS RDS](https://aws.amazon.com/pt/rds/)
* [Firebase](https://www.firebase.com/)
* [BCrypt](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
* [Bootstrap](https://getbootstrap.com/)
* [JQuery](https://jquery.com/)


<!-- GETTING STARTED -->
<h2 id="Iniciando">📖 Iniciando</h2>

Para inicialização correta da aplicação, primeiro é necessário que o todos os software necessários para execução do Java como JVM, JRE e uma IDE Java estejam devidamente instalados e atualizados.

Para isso, siga os seguintes passos:

<h3 id="instalação">⚙ Instalação</h3>

1. Clone o repositório
   ```sh
   git clone https://github.com/CaioDev1/boom-podcast-ifpe.git
   ```
2. Crie um arquivo `application.properties` na pasta `resources/` do projeto, e preencha com todos os dados e chaves necessárias para a inicialização da aplicação.
   ```
    spring.datasource.url =${AWS_HOST}
    spring.datasource.username =${AWS_USER}
    spring.datasource.password = ${AWS_PASSWORD}

    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.hibernate.ddl-auto = update

    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true

    spring.servlet.multipart.max-file-size=200MB
    spring.servlet.multipart.max-request-size=200MB

    firebase.adminsdk=${FIREBASE_ADMIN_SDK}  /* JSON com os dados e chaves necessárias para conexão com o bucket storage do firebase */
   ```
3. Certifique-se que o banco de dados MySQL está executando na sua máquina e inicie a aplicação Spring Boot na IDE desejada.


<!-- USAGE EXAMPLES -->
<h2 id="mais-informações">ℹ Mais Informações</h2>

Segue abaixo links de outros documentos relacionados a aplicação:

_[Diagrama Entidade/Relacionamento](https://lucid.app/documents/view/f397d79a-0486-4df0-8df3-5623fae9ec6e)_
_[Fluxograma básico](https://lucid.app/lucidchart/e2bc8b9e-474e-4e62-8cd1-a6a5283570b6/view)_


<!-- LICENSE -->
<h2 id="licença">📜 Licença</h2>

Distribuído sobre a licença MIT. Veja `LICENSE` para mais informações.


<!-- CONTACT -->
<h2 id="contato">📩 Contato</h2>

Caio Cardoso - [@itsme_caio](https://instagram.com/itsme_caio) - imcaiofelipe@outlook.com

Link do projeto: [https://github.com/CaioDev1/boom-podcast-ifpe](https://github.com/CaioDev1/boom-podcast-ifpe)





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/CaioDev1/boom-podcast-ifpe.svg?style=for-the-badge
[contributors-url]: https://github.com/CaioDev1/boom-podcast-ifpe/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/CaioDev1/boom-podcast-ifpe.svg?style=for-the-badge
[forks-url]: https://github.com/CaioDev1/boom-podcast-ifpe/network/members
[stars-shield]: https://img.shields.io/github/stars/CaioDev1/boom-podcast-ifpe.svg?style=for-the-badge
[stars-url]: https://github.com/CaioDev1/boom-podcast-ifpe/stargazers
[issues-shield]: https://img.shields.io/github/issues/CaioDev1/boom-podcast-ifpe.svg?style=for-the-badge
[issues-url]: https://github.com/CaioDev1/boom-podcast-ifpe/issues
[license-shield]: https://img.shields.io/github/license/CaioDev1/boom-podcast-ifpe.svg?style=for-the-badge
[license-url]: https://github.com/CaioDev1/boom-podcast-ifpe/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/FALTA-COLOCAR
[product-screenshot]: public/mindzone-gif1.gif
[product-screenshot2]: public/mindzone-gif2.gif
[product-screenshot3]: public/mindzone-gif3.gif
