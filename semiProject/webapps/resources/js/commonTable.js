/**
 * 
 */


$('#mytable tbody tr').click(function(){
			$(this).not('#mytable button:button').addClass("selected");                      
            $(this).siblings().removeClass("selected");
		});