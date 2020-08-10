// JavaScript source code
function initialize() {
    getPage("main");
}

function getPage(newPage) {
    var pageheader, pgbody;
    document.getElementById("pagetitle").innerHTML = "";
    document.getElementById("pagebody").innerHTML = "";
    switch (newPage) {
        case "listpage":
            pageheader = "<h1><strong>Study Lists</strong></h1>";
            getRequest("/api/studylists");
            break;
        case "hiragana":
            pageheader = "<h1><strong>ひらがな</strong></h1><h2>Hiragana</h2>";
            getRequest("/api/japanese_syllabaries/type/hiragana");
            break;
        case "main":
            pageheader = "<h1><strong>Japanese Character Flash Card Study Tool</strong></h1>";
            pgbody = "<div class=\"text-center\"><h1>自習時間</h1><img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/3002_Kanji.svg/957px-3002_Kanji.svg.png\" alt=\"Study Hard!\"></div>";
            document.getElementById("pagebody").insertAdjacentHTML('beforeend', pgbody);
            break;
        default:
            pageheader = "<h1><strong>Default Title</strong></h1>";
            pgbody = "<div class=\"text-center\"><h1><strong>Default Body</strong></h1></div>";
            document.getElementById("pagebody").insertAdjacentHTML('beforeend', pgbody);
            break;
    }
    document.getElementById("pagetitle").insertAdjacentHTML('beforeend', pageheader);
}

function getRequest(url) {
    var xhttpList = new XMLHttpRequest();
    xhttpList.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            renderRequest(this.responseText, url);
        }
    };
    xhttpList.open("GET", url, true);
    xhttpList.send();
    console.log("Page received.");
}

function renderRequest(data, request) {
    var json = JSON.parse(data), mgbody;
    console.log(json);
    switch (request) {
        case "/api/studylists":
            mgbody = '<table class="table table-borderless"><thead><tr><th>Lists</th><th></th></tr></thead><tbody>';
            for (var index = 0; index < json.length; index++) {
                mgbody += '<tr id="' + json[index].id + '"><td><a class="link" href="#">' + json[index].name + '</a></td><td><button class="btn-danger" onclick="deleteList(' + json[index].id + ')">Delete</button></td></tr>';
            }
            mgbody += '</tbody ></table ><button class="btn" style="background:transparent;color:gray">+ List</button>';
            console.log("rendered: " + mgbody);
            break;
        case "/api/japanese_syllabaries/type/hiragana":
            mgbody = '<table class="table table-borderless"><thead><tr><th>Lists</th><th></th></tr></thead><tbody>';
            for (var index = 0; index < json.length; index++) {
                if (index % 5 == 0 && index > 0) {
                    mgbody += '</div>';
                }
                if (index % 5 == 0) {
                    mgbody += '<div class="row">';
                }
                syllabaryId = json[index].id;
                //updateModal = renderModal("update", json[index]);
                mgbody += '<div class="col-lg-3">'
                    + '<div id="' + syllabaryId + '" class="card"  style="width:100%;height:200px">'
                    + '<div class="card-body">'
                    + '<img class="card-img-top" src= ' + json[index].strokeOrder + ' alt="Card image" style="width:100%">'
                    + '<h4 class="card-title">' + json[index].character + ' ' + json[index].reading + '</h4>'
                    + '<a href="#" class="btn stretched-link" style="background:transparent">+ Add to List</a>'
                    + '</div>'
                    + '</div>'
                    + '</div>';
            }
            break;
        default:
            mgbody = "<div class=\"text-center\"><h1><strong>ERROR</strong></h1></div>";
            break;
    }
    document.getElementById("pagebody").insertAdjacentHTML('beforeend', mgbody);
}

function deleteList(id) {
    var link = "/api/delete/studylist/" + id, ok = confirm("Are you sure you want to delete this list?\nPress 'OK' to continue, or 'Cancel' to abort"), xhttp;
    if (ok == true) {
        xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", link, true);
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var removeList = document.getElementById(id);
                removeList.parentNode.removeChild(removeList);
                console.log("List with ID:" + id + " deleted.");
            }
        };
        xhttp.send(null);
    }
}