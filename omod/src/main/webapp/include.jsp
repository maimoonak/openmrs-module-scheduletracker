<link href="/openmrs/moduleResources/scheduletracker/default.css" type="text/css" rel="stylesheet">

<script type="text/javascript">
function expandRecord(obj){
	var trId=obj.title;
	// var divId=obj.title+"dv";
	act=obj.value;
	if(act==undefined || act=="+"){
		document.getElementById(trId).style.display="table-row";
		//document.getElementById(divId).style.display="table";

		obj.value="-";
	}
	else{
		document.getElementById(trId).style.display="none";
		//document.getElementById(divId).style.display="none";
		
		obj.value="+";
	}
}

jQuery( document ).ready(function() {
	jQuery(".numbersOnly").forceNumeric();
});

jQuery.fn.forceNumeric = function () {
    return this.each(function () {
        jQuery(this).keypress(function (e) {
            if (/\D/g.test(this.value))
            {
                // Filter non-digits from input value.
                this.value = this.value.replace(/\D/g, '');
            }
            
             var key = e.which || e.keyCode;

             /* if (!e.shiftKey && !e.altKey && !e.ctrlKey &&
            // numbers   
                key >= 48 && key <= 57 ||
            // Numeric keypad
                key >= 96 && key <= 105 ||
            // comma, period and minus, . on keypad
               key == 190 || key == 188 || key == 109 || key == 110 ||
            // Backspace and Tab and Enter
               key == 8 || key == 9 || key == 13 ||
            // Home and End
               key == 35 || key == 36 ||
            // left and right arrows
               key == 37 || key == 39 ||
            // Del and Ins
               key == 46 || key == 45)
                return true; */
                
                if(key == 8 || key == 9 || key == 13 || 
                	key == 35 || key == 36 || 
                	key == 37 || key == 39 || 
                	key == 46 || key == 45 ||
                	/^\d+$/.test(String.fromCharCode(key))){
                	return true;
                }

            return false;
        });
    });
};
</script>