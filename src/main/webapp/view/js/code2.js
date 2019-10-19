/** 
		 *验证码生成和判断js版
		**/
	    /**生成一个随机数**/
	    var str; //全局的str
	    var code;
	    function validate2() {
	        var inputCode = document.getElementById("code2").value;
	        if (inputCode.length <= 0) {
	            alert("请输入验证码！");
	            return false;
	        } else if (inputCode != code) {
	            alert("验证码输入错误！");
	            document.getElementById("code2").value = "";
	            
				drawPic();//刷新验证码   
				return false;
	        } else {
				var tid = document.getElementById("Tid").value;
				var sid = document.getElementById("Sid").value;
				let teacher = document.getElementById("Tteacher");
				let student = document.getElementById("Sstudent");
				if(teacher.style.display == "block"){
					if(tid.length <=0){
						alert("请输入教师编号！");
						return false;
					}
					else{
						return true;
					}
				}
	        	if(student.style.display == "block"){
	        		if(Sid.length <=0){
	        			alert("请输入学号！");
	        			return false;
	        		}
	        		else{
	        			return true;
	        		}
	        	}
	        }
			
	    }
	    
	    function randomNum(min,max){
	        return Math.floor( Math.random()*(max-min)+min);
	    }
	    /**生成一个随机色**/
	    function randomColor(min,max){
	        var r = randomNum(min,max);
	        var g = randomNum(min,max);
	        var b = randomNum(min,max);
	        return "rgb("+r+","+g+","+b+")";
	    }
	    window.onload = drawPic();
	    
	
	    /**绘制验证码图片**/
	    function drawPic2(){
	        var canvas=document.getElementById("canvas2");
	        var width=canvas.width;
	        var height=canvas.height;
	        var ctx = canvas.getContext('2d');
	        ctx.textBaseline = 'bottom';
	
	        /**绘制背景色**/
	        ctx.fillStyle = randomColor(180,240); //颜色若太深可能导致看不清
	        ctx.fillRect(0,0,width,height);
	        /**绘制文字**/
	        str = 'ABCEFGHJKLMNPQRSTWXY0123456789';//str在此
			code = "";
	        for(var i=0; i<4; i++){
	            var txt = str[randomNum(0,str.length)];
				code += txt;
				
	            ctx.fillStyle = randomColor(50,160);  //随机生成字体颜色
	            ctx.font = randomNum(25,35)+'px SimHei'; //随机生成字体大小
	            var x = 10+i*23;
	            var y = randomNum(25,40);
	            var deg = randomNum(-45, 45);
	            //修改坐标原点和旋转角度
	            ctx.translate(x,y);
	            ctx.rotate(deg*Math.PI/180);
	            ctx.fillText(txt, 0,0);
	            //恢复坐标原点和旋转角度
	            ctx.rotate(-deg*Math.PI/180);
	            ctx.translate(-x,-y);
	        }
	        /**绘制干扰线**/
	        /* for(var i=0; i<8; i++){
	            ctx.strokeStyle = randomColor(40,180);
	            ctx.beginPath();
	            ctx.moveTo( randomNum(0,width), randomNum(0,height) );
	            ctx.lineTo( randomNum(0,width), randomNum(0,height) );
	            ctx.stroke();//实际地绘制出通过 moveTo() 和 lineTo() 方法定义的路径
	        } */
	        /**绘制干扰点**/
	        for(var i=0; i<100; i++){
	            ctx.fillStyle = randomColor(0,255);
	            ctx.beginPath();
	            ctx.arc(randomNum(0,width),randomNum(0,height), 1, 0, 2*Math.PI);//左边距,上边距,半径
	            ctx.fill();//填充当前图像
	        }
			
		}
		document.getElementById("canvas2").onclick = function(e){
		    e.preventDefault();
		    drawPic2();
		}