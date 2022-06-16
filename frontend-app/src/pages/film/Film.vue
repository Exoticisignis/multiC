<template>
    <div class="movie_pole">

    
    </div>
    <div class="logowanie">

    
    </div>
    
 
</template>

<script>
    const API_URL_ALL = "http://localhost:8080"+window.location.href.slice(21);
    //console.log(API_URL_ALL)
    getMovie(API_URL_ALL);
    async function getMovie(url){
    
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
    showMovie(respData);
    }

   

    function showMovie(data){
        const moviesEl = document.querySelector(".movie_pole");

        console.log(data);
        
        var imageurl ="http://localhost:8081/"+data.description
        console.log(imageurl);
        
        moviesEl.innerHTML = `
                    <div class="film_L">
                        
                        <img class="film__image" src="${imageurl}.jpg" alt="hz">
                        
                        
                        
                    </div>

                    <div class="film_R">
                        <div class="film_nazwa" >
                         ${data.name}
                        </div>
                        
                        <div class="film_opis" >
                         ${data.genre}
                        </div>
                        <div class="film_button" >
                            
                        <button onclick="logowanie()" class="kup_bilet">Kupić Bilet</button>
                        </div>
                    </div>
                        `;


        /*movieEl.id=data.id
            movieEl.href="http://localhost:8081/films/"+data.id
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

                        </div>`;*/
        
        
        

    }

    

   
    
</script>
<style>
.film__image{
    width: 300px;
    
    position: relative;
}
.film_L{

    margin: 50px;
    float: left
}
.film_R{
    margin: 50px;
    position: relative;
    float: left;
    
   
}
.film_nazwa{
    margin-top: 10px;
    color: aliceblue;
}
.film_opis{
    margin-top: 50px;
    color: aliceblue;
}
.film_button{
    
    margin-top: 50px;
}
</style>