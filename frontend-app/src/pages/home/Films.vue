<template>

   

    <div class="container_films">
        <div class="movies">

            
            
        </div>


    </div>

</template>


<script>

const API_URL_ALL = "http://localhost:8080/films";
getMovies(API_URL_ALL);
async function getMovies(url){
  
  const resp = await fetch(url, { header:{"Content-Type":"application/json","Access-Control-Allow-Origin":"*"},});
/*
  fetch(url)
  .then(function() {

  })
  .catch(function() {

  });
*/

  const respData = await resp.json();
  console.log(respData);
  showMovies(respData);
}
function showMovies(data){
  const moviesEl = document.querySelector(".movies");


  data.forEach(movie => {
    const movieEl = document.createElement("a")
    movieEl.classList.add("movie")
    movieEl.id=movie.id
    movieEl.href="http://localhost:8081/films/"+movie.id
    var imageurl =""+movie.description
    console.log(imageurl);
    movieEl.innerHTML = `<div class="movie__cover-inner" >
                    <img class="movie__cover" src="${imageurl}.jpg" alt="hz">
                </div>

                <div class="movie__cover-darkened">
                </div>

                <div class="movie__info">
                    
                    <div class="movie__title">${movie.name}</div>
                    <div class="movie__category">${movie.director}</div>
                    <div class="movie__premiera">${movie.status}</div>

                </div>`;
                moviesEl.appendChild(movieEl);
   
  });

}

 
</script>


<style scoped>
h5 {
  color: rgb(35, 70, 40);
}

.header-content{
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 16px;
    height: 60px;
    background-color: black;

}
.header-button-content{
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 16px;
    height: 60px;
    background-color: rgb(173, 128, 68);
}
.header_logo{

    font-size: 32px;
    text-decoration: none;
    color: darkgoldenrod;
    margin-left: auto;
    margin-right: auto;
}
.movies{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}
.movie{
    width: 240px;
    margin: 10px;
    position: relative;
}

.movie__cover-inner{
    position: relative;
    /*height: 360px;*/

}
.movie__cover-darkened{
    background-color: black;
    opacity: 0.1;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    max-width: 100%;
    height: 100%;    
    z-index: 1;


}
.movie__cover-darkened:hover{
    background-color: gray;
    cursor: pointer;
    
}

.movie__cover{
max-width: 100%;
width: 100%;
}
.movie__info{
    padding: 10px 0px;
    

}
.movie__title{

    font-size: 20px;  
    color: aliceblue;
    

}
.movie__category{

    font-size: 14px;
    color: aliceblue;
    

}
.movie__premiera{
    left: 5px;
    position: absolute;
    bottom: 80px;
    color: rgb(228, 192, 33);
}
</style>