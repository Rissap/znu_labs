console.log("connected");

let id_interval_foo_2 = 0;

let img_size_2 = 200;

let side_2 = 3; // move slides to the left or to the right
let speed_2 = 3; //every 3 seconds
let elements_2 = 3;
let width_2 = elements_2*200+100; //width of the container with slides
let img_set_2 = ['1', '2', '3', '4', '5', '6', '7', '8'];
let index_2 = 0;

//document are ready for js
$(function(){
	id_interval_foo_2 = setInterval(scroll_2, speed_2*1000)
}); 

/* observer changes */
$("#amount-2").on("input", function() {
	elements_2 = $("#amount-2").val()
	console.log(elements_2)
})

$("#speed-2").on("input", function() {
	speed_2 = $(this).val()
	clearInterval(id_interval_foo_2)
	id_interval_foo_2 = setInterval(scroll_2, speed_2*1000)
})

$("#width-2").on("input", function() {
	$(".scroll-2").width(
		$(this).val()
	);
})

function scroll_2()
{
	let template_2="";
	for(j=0;j<elements_2;j++)
	{
		template_2+="<li class='tmp_li-2'><img src='../img/"+img_set_2[index_2%img_set_2.length]+".png'></li>";
		index_2++;
	}
	$("#img-list-2").html(template_2)
}