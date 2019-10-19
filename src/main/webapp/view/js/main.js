function Down(){
	let flex = document.getElementById("flex");
	if(flex.style.display == "none"){
		flex.style.display = "inline-block";
	}
	else{
		flex.style.display = "none";
	}
		
}

/* function hide(){
	let right = document.getElementById("right");
	let sideNav = document.getElementById("sideNav");
	let left = document.getElementById("left");
	if(right.style.width == "80%"){
		right.style.width = "100%";
		sideNav.style.left = "0";
		left.style.width = "0";
	}
	else{
		right.style.width = "80%";
		sideNav.style.left = "20%";
		left.style.width = "20%";
	}
} */

$(document).ready(function(){
  $("#sideNav").click(function(){
	let lwidth = $("#leftNav").width();
	if(lwidth != 0){
		$("#leftNav").animate({width:'0'},500);
		$("#right").animate({width: '100%'},500);
		$('#sideNav').animate({left: '0'},500);
	}
	else{
		$("#leftNav").animate({width:'100%'},500);
		$("#right").animate({width: '80%'},500);
		$('#sideNav').animate({left: '20%'},500);
	}
    
  });
  
 /* $("li").click(function(){
	  $(this).addClass("first-a");
	  $(this).siblings().removeClass("first-a");
  }); */
  
  
});


