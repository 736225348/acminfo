function zhu(){
	let box = document.getElementById("Bbox");
	let box2 = document.getElementById("Bbox2");
	
	box.style.display = "none";
	box2.style.display = "block";
}

function login(){
	let box = document.getElementById("Bbox");
	let box2 = document.getElementById("Bbox2");
	box.style.display = 'block';
	box2.style.display = 'none';
}

function displayt(){
	let teacher = document.getElementById("Tteacher");
	let student = document.getElementById("Sstudent");
	teacher.style.display = "block";
	student.style.display = "none";
}
function displays(){
	let teacher = document.getElementById("Tteacher");
	let student = document.getElementById("Sstudent");
	student.style.display = "block";
	teacher.style.display = "none";
}