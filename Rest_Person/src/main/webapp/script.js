function getAllPerons() {
    fetch('http://localhost:8080/Rest_Person/api/person').then(function (response) {
        return response.json();
    }).then(function (data) {
        console.log(data);
        var persons = data.map(function (x) {
            return "<tr><td>" + x.id + "</td><td>" + x.fname + "</td><td>" + x.lname + "</td><td>" + x.phone + "</td><td><button id="+x.id+" onclick='deletePerson()'>Delete</button></td></tr>"
        });
        var ps = persons.join("");
        console.log(ps);
        document.getElementById("tableBody").innerHTML = ps;
    });

}

function deletePerson(){
    alert(event.target.id);

 var myHeaders = new Headers({'Content-Type': 'application/json'});
var conf = { method: 'DELETE',
               headers: myHeaders};

fetch('http://localhost:8080/Rest_Person/api/person/'+event.target.id, conf);
getAllPerons();
}


function getPersonById(id){
    id = document.getElementById("id").value;
    fetch('http://localhost:8080/Rest_Person/api/person/'+id).then(function(response){
        return response.json();
    }).then(function (x){
        
            document.getElementById("tableBody").innerHTML = "<tr><td>" + x.id + "</td><td>" + x.fname + "</td><td>" + x.lname + "</td><td>" + x.phone + "</td><td><button id="+x.id+" onclick='deletePerson()'>Delete</button></td></tr>"
        
        
    });
}

function addPerson(){
  
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var phone = document.getElementById("phone").value; 
    var person = {fname:fname,lname:lname,phone:phone};
    console.log(person)
    var myHeaders = new Headers({'Content-Type': 'application/json'});
    
    var conf = { method: 'post',
                body:JSON.stringify(person),
               headers: myHeaders};

fetch('http://localhost:8080/Rest_Person/api/person/', conf);
getAllPerons();
}


function updatePerson(){
    var id = document.getElementById("id").value
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var phone = document.getElementById("phone").value; 
    var person = {fname:fname,lname:lname,phone:phone};
    console.log(person)
    var myHeaders = new Headers({'Content-Type': 'application/json'});
    
    var conf = { method: 'put',
                body:JSON.stringify(person),
               headers: myHeaders};

fetch('http://localhost:8080/Rest_Person/api/person/'+id, conf);
getPersonById(id);
}


window.onload = function () {
    event.preventDefault();
    getAllPerons();


};

setInterval(function () {
 canGetPersonBePressed();
 canUpdateBePressed();
 setCreatePerseonBtn();
   
}, 200);


function canGetPersonBePressed() {

    var id = document.getElementById("id").value;
    if (id !== "") {
        document.getElementById("getPersonBtn").disabled = false;
    } else {
        document.getElementById("getPersonBtn").disabled = true;
    }

}

function canUpdateBePressed() {
    var id = document.getElementById("id").value;
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var phone = document.getElementById("phone").value;
    if (id !=="" && fname !== "" && lname !== "" &&  phone !== "") {
        document.getElementById("personUpdateBtn").disabled = false;
    } else {
        document.getElementById("personUpdateBtn").disabled = true;
    }


}


function setCreatePerseonBtn() {
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var phone = document.getElementById("phone").value;
    if ( fname !== "" && lname !== "" &&  phone !== "") {
        document.getElementById("createPersonBtn").disabled = false;
    } else {
        document.getElementById("createPersonBtn").disabled = true;
    }


}
