<template>
    <div class="opis filmu">

         
    
    </div>
    <div class="opcje_biletu">
        <div class="dropdown">
        <button onclick="myFunction()" class="dropbtn">Dostępne Seansy</button>
        <div id="myDropdown" class="dropdown-content">
            
        </div>
        </div>

    
    </div>
    <div class="miejsce">
        
    
    </div>
    <div class="wybrane_miejsca">

    
    </div>
    
 
</template>

<script>
    //var seans=0;
    //function change_seans(id){seans=id}
   
    var idf=get_id_film()
     //showNazwa(idf)
     console.log("adfsgd")
    let seanses=new Array
    $.ajax("http://localhost:8080/seansy",{
                success: function(data){
                    
                    data.forEach(el =>{//console.log("check2");
                    console.log(idf+"dasfgddsfgdhfgadsfgdhf")
                    console.log(el.film+"iiiii")
                        if(el.film==idf){seanses.push(el.idS-1+1); 
                        
                        
                        
                            $.ajax("http://localhost:8080/seansy/"+el.idS,{
                                success: function(data)
                                {
                                    console.log("adfsgd")
                                    const seansesEl = document.querySelector("#myDropdown");
                                    const seansEl = document.createElement("a")
                                    seansEl.classList.add("czas")
                                    seansEl.innerHTML=`
                                    <div onclick="change_seans(${el.idS})">${data.czasR+"-"+data.czasZ}</div>
                                    
                                    `
                                    seansesEl.appendChild(seansEl);

                                    console.log(data.czasR)
                                }


                            })
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        }
                        //console.log(seanses)
                        
                    })
                   
                    //films.push(1)
                    //console.log(seanses)
              
                    
                   
                    
                   
                }
                

            })
    
   
   

    
    

    //console.log(seanses[1])
    
    //let data=get_all_seans(get_id_film());
    //console.log(get_all_seans(get_id_film()))
    const nazwa=document.getElementById('nazwafilmu')
    
                        

           //  })






















        

    // Close the dropdown menu if the user clicks outside of it
    window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('show')) {
            openDropdown.classList.remove('show');
        }
        }
    }
    }






    const API_URL_ALL = "http://localhost:8080/bilety";
    console.log(API_URL_ALL)
    getbilety(API_URL_ALL);
    async function getbilety(url){
    
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
    //showbilets(respData);
    }





    function showbilets(data){
        const moviesEl = document.querySelector(".miejsce");

        console.log(data);
        
        console.log(seans);
        
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


        

    }




</script>


<style>

.dropbtn {
    background-color: #3498DB;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
    background-color: #2980B9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}
.dropbtn{margin-top: 20px; }
</style>