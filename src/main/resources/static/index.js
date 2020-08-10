// JavaScript source code
function initialize() {
    document.getElementById("pagetitle").insertAdjacentHTML('beforeend', "<h1>自習時間</h1>");
    document.getElementById("pagebody").insertAdjacentHTML('beforeend', "<div class=\"text-center\"><img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/3002_Kanji.svg/957px-3002_Kanji.svg.png\" alt=\"Study Hard!\"></div>");
    //getPage("/api/study");
}

/*function getPage(url) {
    var xhttpList = new XMLHttpRequest();
    xhttpList.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            renderRequest(this.responseText);
        }
    };
    xhttpList.open("GET", url, true);
    xhttpList.send();
    console.log("Page received.");
}*/