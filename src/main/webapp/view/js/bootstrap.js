// JavaScript Document
window.onload = function () {
	var list = document.getElementById('list');
	var prev = document.getElementById('prev');
	var next = document.getElementById('next');

	function animate(offset) {
		var newlist = parseInt(list.style.left) + offset;
		list.style.left = newlist + 'px';
		if (newlist < -5000) {
			list.style.left=-1000+'px';
		}
		if (newlist > -1000) {
			list.style.left=-5000+'px';
		}
	}
	prev.onclick=function(){
		animate(1000);
	}
	next.onclick=function(){
		animate(-1000);
	}
	var times;
	function play(){
		times=setInterval(function(){
			next.onclick();
		m},3000)
	}
	play();
	function stop(){
		clearInterval(times);
	}
	var containter=document.getElementById('containter');
	containter.onmouseover=stop;
	containter.onmouseout=play;
	var index=1;
	var buttons=document.getElementById('buttons').getElementsByTagName('span');
	function buttonShow(){
		for(var i=0;i<buttons.length;i++){
			if(buttons[i].className=='on'){
				buttons[i].className='';
			}
			buttons[index-1].className='on';
		}
	}
	prev.onclick=function(){
		index-=1;
		if(index<1){
			index=5;
		}
		buttonShow();
		animate(1000);
	}
	next.onclick=function(){
		index+=1;
		if(index>5){
			index=1;
		}
		buttonShow();
		animate(1000);
	}
	for(var i=0;i<buttons.length;i++){
		(function(i){
			buttons[i].onclick=function(){
				var clickButton=parseInt(this.getAttribute('index'));
				var a=1000*(index-clickButton);
				animate(a);
				index=clickButton;
				buttonShow();
				
			}
		})(i)
	}
}
$(document).ready(function(){
	$('#secondarticle').click(function(){
		$('#Article').hide();
		$('#secondArticle').show();
	});
	$('#onearticle').click(function(){
		$('#secondArticle').hide();
		$('#Article').show();
	})
})