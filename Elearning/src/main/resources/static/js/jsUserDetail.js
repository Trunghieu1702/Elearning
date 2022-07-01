$( document ).ready(function() {

    $( "#btnEditUser" ).on( "click", function() {
  		switchModeEdit(true);
	});
	
	$( "#btnEditCancel" ).on( "click", function() {
  		location.reload(true);
	});
	
	$( ".fRoleId" ).change(function() {
	
		var str = "";
    	$( ".fRoleId option:selected" ).each(function() {
      		str += $( this ).text() + " ";
    	});
  		$( "div.txtRole" ).text( str );
	});
	
	function switchModeEdit(isEdit){
		if(isEdit){
			$( "#btnEditUser" ).hide();
  		$( "#btnEditSubmit" ).show();
  		$( "#btnEditCancel" ).show();
  		$( "#btnAddAvatar" ).show();
  		$( "#btnRemoveAvatar" ).show();
  		$("#kt_modal_edit_user_form :input").prop("disabled", false);
  		$( ".fRoleId" ).show();
  		$( "div.txtRole" ).addClass("elementHide");
		}else{
		$( "#btnEditUser" ).show();
  		$( "#btnEditSubmit" ).hide();
  		$( "#btnEditCancel" ).hide();
  		$( "#btnAddAvatar" ).hide();
  		$( "#btnRemoveAvatar" ).hide();
  		$("#kt_modal_edit_user_form :input").prop("disabled", true);
  		$( ".fRoleId" ).hide();
  		$( "div.txtRole" ).removeClass("elementHide");
  		$( "#btnEditSubmit" ).hide();
  		$( "#btnEditCancel" ).hide();
  		$( "#btnAddAvatar" ).hide();
  		$( "#btnRemoveAvatar" ).hide();
		}
	}
	$( ".fRoleId" ).change();
	switchModeEdit(false);
	
	$( "#btnEditSubmit" ).on( "click", function() {
  		Swal.fire({
       		 text: "Thay doi cua ban da duoc luu",
        	icon: "success",
        	buttonsStyling: false,
        	confirmButtonText: "Ok, toi dong y!",
        	customClass: {
            confirmButton: "btn btn-primary"
        	}
    		}).then(() => {
  			$("#kt_modal_edit_user_form").submit();
			});;
	});
	
	
	
});

