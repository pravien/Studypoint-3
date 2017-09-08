function fetchRandomQuote() {
    fetch('http://localhost:8080/RestQuotes/api/quote/random').then(function (response) {
        return response.json();
    }).then(function (data) {
        document.getElementById("quote").innerHTML = data.quote;
    });
}

function addQuote() {
    event.preventDefault();
    // gets the value from the text field
    var newQuote = document.getElementById("newQuote").value;
    // make object
    var quoteObject ={quote:newQuote} ;
    //var obj = JSON.parse(pers);

    // the conficuration for the fetch
     var conf = {method: 'post', 
        body: JSON.stringify(quoteObject) 
    }
    //fetch(request)
    // the then response is used when you expect an response.
    fetch('http://localhost:8080/RestQuotes/api/quote/',conf).then(function (response){
        return response.json();
    }).then(function (data) {
                alert("Quote: "+data.quote+" with id: "+data.id+" was added");
            });
}

function deleteQuote(){
    event.preventDefault(); 
    var id = document.getElementById("idOfQuote").value;
    var url = 'http://localhost:8080/RestQuotes/api/quote/'+id;
    var conf = {method: 'delete'
    }
    //fetch(request)
    // the then response is used when you expect an response.
    fetch(url,conf).then(function (response){
        return response.json();
    }).then(function (data) {
                alert("The following quote was deleted: "+data.quote);
            });
}

function updateQuote() {
   event.preventDefault(); 
   var id = document.getElementById("idOfQuote").value;
   var newQuote = document.getElementById("newQuote").value;
   var url = 'http://localhost:8080/RestQuotes/api/quote/'+id;
   console.log(newQuote);
   console.log(url);
   
   var quoteObject ={quote:newQuote} ;
   var conf = {method: 'put', 
        body: JSON.stringify(quoteObject)
    }
    //fetch(request)
    // the then response is used when you expect an response.
    fetch(url,conf).then(function (response){
        return response.json();
    }).then(function (data) {
                alert("Quote with id: "+data.id+" was updated to"+data.quote);
            });
}

function onSubmit (buttonValue){
     event.preventDefault(); 
     if(buttonValue == "addQuote"){
        addQuote();
     }
     if(buttonValue == "updateQuote"){
        updateQuote();
     }
     if(buttonValue == "deleteQuote"){
        deleteQuote();
     }
     
}

window.onload = function() {
   fetchRandomQuote(); 
}


