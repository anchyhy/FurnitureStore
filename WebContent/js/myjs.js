/**
 * 
 */

function showTypeWindow(){
	   
    	document.getElementById('window_type').style.display='block';
    	document.getElementById('fade').style.display='block';
    }
    function closeTypeWindow(){
    	document.getElementById('window_type').style.display='none';
    	document.getElementById('fade').style.display='none';
    }
    
    function showPhotoWindow(){
    	document.getElementById('window_photo').style.display='block';
    	document.getElementById('fade').style.display='block';
    }
    function closePhotoWindow(){
    	document.getElementById('window_photo').style.display='none';
    	document.getElementById('fade').style.display='none';
    }
    
    
    function showSlideWindow(){
    	document.getElementById('window_slide').style.display='block';
    	document.getElementById('fade').style.display='block';
    }
    function closeSlideWindow(){
    	document.getElementById('window_slide').style.display='none';
    	document.getElementById('fade').style.display='none';
    } 
    function pleaseLogin(e,f){
    	document.getElementById('lf').value=e;
    	if(f>0){
    		document.getElementById('goodsid').value=f;
    	}
    	document.getElementById('window_login').style.display='block';
    	document.getElementById('fade').style.display='block';
    }
    function closeLoginWindow(){
    	document.getElementById('window_login').style.display='none';
    	document.getElementById('fade').style.display='none';
    } 
    function disagreeGoodsWindow(e){
    	document.getElementById('goodsid').value=e;
    	document.getElementById('window_goods').style.display='block';
    	document.getElementById('fade').style.display='block';
    }
    function closedisagreeGoodsWindow(){
    	document.getElementById('window_goods').style.display='none';
    	document.getElementById('fade').style.display='none';
    }
    function disagreeSellerWindow(e){
    	document.getElementById('sellerid').value=e;
    	document.getElementById('window_seller').style.display='block';
    	document.getElementById('fade').style.display='block';
    }
    function closedisagreeSellerWindow(){
    	document.getElementById('window_seller').style.display='none';
    	document.getElementById('fade').style.display='none';
    }
    function Evaluate(e){
    	document.getElementById("orderid").value=e;
    	document.getElementById('window_evaluate').style.display='block';
    	document.getElementById('fade').style.display='block';
    }
    function closeEvaluateWindow(){
    	document.getElementById('window_evaluate').style.display='none';
    	document.getElementById('fade').style.display='none';
    }