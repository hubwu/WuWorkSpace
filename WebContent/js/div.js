window.onload=function(){
	
	var screenHeight=window.screen.height;//屏幕高
	var screenWidth=window.screen.availWidth;//屏幕宽
	var advImg="http://wifi.isurl.cn/downapp/adv.jpg";
	var deleteImg="http://wifi.isurl.cn/downapp/delete.png";
	var divNode=document.createElement('div');
	divNode.id="advDiv";
	divNode.width="100%";
	divNode.height="14%";
    divNode.innerHTML="<img src='"+advImg+"'  width='100%' height='100%'/><div style=' position:absolute;width:10%;height:50%;float:right;right:0;top:0;'><img src='"+deleteImg+"' onClick='closeDiv()' style='width:100%;height:100%;'/>aaaaa</div>";
	divNode.style.cssText=" border-top: 1px solid #CCCCCC;bottom:0px;height:14%;width:100%;left: 0;line-height: 44px;position: fixed;text-align: center;";
    var bodyNode=document.body;
    document.body.appendChild(divNode);
};

function closeDiv(){
   var divNode=document.getElementById('advDiv');
   divNode.style.display='none';
}
	