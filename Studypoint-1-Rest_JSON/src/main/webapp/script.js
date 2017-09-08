function getData(){
    fetch('http://localhost:8080/Studypoint-2-Rest/api/data/50/20').then(function (response) {
        return response.json();
    }).then(function (data) {
        console.log(data);
        var persons = data.map(function (x) {
            return "<tr><td>" + x.id + "</td><td>" + x.fname + "</td><td>" + x.lname + "</td><td>" + x.age + "</td></tr>"
        });
        var ps = persons.join("");
        console.log(ps);
        document.getElementById("tableBody").innerHTML = ps;
    });
}

window.onload= function(){
    getData();
}


