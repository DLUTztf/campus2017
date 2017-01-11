window.onload = function(){
    ajax();
    function createElement(obj){
        return document.createElement(obj);
    }
    function ajax(){
        var xhr = new XMLHttpRequest()||new ActiveXObject("Microsoft.HTTP");
        var date;
        xhr.onreadystatechange = function(){
            if(xhr.readyState ==4 && xhr.status==200){
                date = eval('('+xhr.responseText+')');
                create(date);
            }
        };
        xhr.open("get","http://localhost:8888/tsconfig.json","true");
        xhr.send();
    }
    function create(date){
        var table = document.getElementsByTagName("table")[0];
        var tbody = table.getElementsByTagName("tbody")[0];
        for(var i=0;i<date.length;i++){
            var tr = createElement("tr");
            var td1 = createElement("td");
            td1.className = "td1";
            var p1 = createElement("p");
            var p2 = createElement("p");
            p1.innerHTML = date[i].time1;
            p2.innerHTML = date[i].time2;
            td1.appendChild(p1);
            td1.appendChild(p2);
            var td2 = createElement("td");
            td2.className = "td2";
            td2.innerHTML = date[i].name;
            var td3 = createElement("td");
            td3.className = "td3";
            td3.innerHTML = date[i].number;
            var td4 = createElement("td");
            td4.className = "td4";
            td4.innerHTML = date[i].em;
            var td5 = createElement("td");
            td5.className = "td5";
            td5.innerHTML = date[i].status;
            var td6 = createElement("td");
            td6.className = "td6";
            td6.innerHTML = date[i].msg;
            var td7 = createElement("td");
            td7.className = "td7";
            var input = createElement("input");
            input.type = "button";
            input.value = "兑换信息";
            td7.appendChild(input);
            var td8 = createElement("td");
            td8.className = "td8";
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);
            tr.appendChild(td6);
            tr.appendChild(td7);
            tr.appendChild(td8);
            tbody.appendChild(tr);
        }
    }
};