let form1 = document.getElementById("firstForm");
let form2 = document.getElementById("secondForm");
let form3 = document.getElementById("thirdForm");

let next1 = document.getElementById("next1");
let next2 = document.getElementById("next2");
let back1 = document.getElementById("back1");
let back2 = document.getElementById("back2");
let submit = document.getElementById("submit")

let progress = document.getElementById("progress")

next1.onclick = function (){
    form1.style.left = "-450px";
    form2.style.left = "40px";
    progress.style.width = "240px";
};
back1.onclick = function (){
    form1.style.left = "40px";
    form2.style.left = "450px";
    progress.style.width = "120px";
};
next2.onclick = function (){
    form2.style.left = "-450px";
    form3.style.left = "40px";
    progress.style.width = "360px";
};
back2.onclick = function (){
    form2.style.left = "40px";
    form3.style.left = "450px";
    progress.style.width = "240px";
};
submit.onclick = function clickMe(){
    alert("Your order was placed successfully")
}