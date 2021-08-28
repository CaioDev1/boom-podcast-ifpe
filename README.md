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
    Compartilhe suas ideias, acompanhe pensamentos de outros usuários, converse com seus amigos, curta, comente e socialize entre a comunidade de Mindzoners! 
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
    <li><a href="#mais-informações">API</a></li>
    <li><a href="#licença">Licença</a></li>
    <li><a href="#contato">Contato</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
<h2 id="sobre-o-projeto">💡 Sobre o projeto</h2>

[![Product Name Screen Shot][product-screenshot]](https://mindzone.herokuapp.com/)

O Mindzone é uma rede social focada na interação e troca de ideias entre os usuários, fomentando a criatividade, diferentes pontos de vista e complementos, na plataforma, você é capaz de adicionar outros usuários como amigos, acompanhar as principais postagens, conversar com outros usuários em chat e muito mais. Opine, contribua e agregue conosco!

[![Product Name Screen Shot2][product-screenshot2]](https://mindzone.herokuapp.com/)

* Acompanhe as publicações de outros usuários
* Curta e comente as postagens
* Adicione amigos
* Crie chat's exclusivos com outros usuários
* Veja as postagens em alta na plataforma
* Filtre usuários

[![Product Name Screen Shot3][product-screenshot3]](https://mindzone.herokuapp.com/)

<h3 id="feito-utilizando">🔧 Feito Utilizando</h3>

Para uma maior fluídez da aplicação na parte do frontend, foi utilizado ReactJS. No lado da API da aplicação, onde fica toda a regra de negócio e autenticação,
foi utilizado NodeJS com Express. No banco de dados, modelo não relacional com MongoDB.

Firebase Storage para a manipulação de arquivos na nuvem e Web Socket's para funcionalidades da aplicação em tempo real.

Segue a lista de ferramentas:
* [ReactJS](https://pt-br.reactjs.org/)
* [NodeJS](https://nodejs.org/en/)
* [Express](https://expressjs.com/pt-br/)
* [MongoDB](https://www.mongodb.com/)
* [Firebase](https://www.firebase.com/)
* [Socket.IO](https://socket.io/)


<!-- GETTING STARTED -->
<h2 id="Iniciando">📖 Iniciando</h2>

Para inicialização correta da aplicação, primeiro é necessário que o NodeJS e o gerenciador de pacotes NPM esteja instalado e atualizado.

Para isso, siga os seguintes passos:

<h3 id="instalação">⚙ Instalação</h3>

1. Clone o repositório
   ```sh
   git clone https://github.com/CaioDev1/boom-podcast-ifpe.git
   ```
2. Instale os pacotes e dependências via NPM
   ```sh
   npm install
   ```
3. Crie um arquivo `.env` na raiz do projeto com todos os dados sensíveis da aplicação.
   ```
    ATRIBUTO=VALOR
    ATRIBUTO=VALOR
    
    ...
   ```


<!-- USAGE EXAMPLES -->
<h2 id="mais-informações">ℹ API</h2>

Além da parte do frontend da aplicação, temos a API que gerencia as requisições e trata todo o esquema e segurança da aplicação,
para acessa-la, basta ir para o link do repositório abaixo: 

_[Mindzone NodeJS API](https://github.com/CaioDev1/socialmedia-backend)_


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
