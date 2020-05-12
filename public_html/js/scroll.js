console.log("connected");

let id_interval_foo = 0;

let img_size = 200;

let side = 3; // move slides to the left or to the right
let speed = 3; //every 3 seconds
let elements = 3;
let width = elements*200+100; //width of the container with slides
let img_set = ['1', '2', '3', '4', '5', '6', '7', '8'];
let index = 0;

$(document).ready(function(){
  $(".owl-carousel").owlCarousel();
});



function upd_slide() {
	elements = document.getElementById("amount").value;
	speed = document.getElementById("speed").value;
	width = document.getElementById("width").value;

	let html_obj = document.getElementsByClassName("scroll");
	html_obj[0].style.width = width+"px";

	clearInterval(id_interval_foo)
	id_interval_foo = setInterval(scroll, speed*1000)	
}


function scroll() {
	let template = "";
	for (i=0;i<elements;i++)
	{
		template+="<li><img src='../img/"+img_set[index%img_set.length]+".png'></li>"
		index++;
	}
	document.getElementById("img-list").innerHTML = template;	
}

id_interval_foo = setInterval(scroll, speed*1000);