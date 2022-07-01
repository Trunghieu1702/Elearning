$( "#btnDeleteSelect" ).on( "click", function() {
		var lstDel =[] ;	 
  		$( "input:checked.user-checked" ).each(function(element){ 
  		
  		lstDel.push($( this )[0].id);
  		});
  		var formData = new FormData();
  		formData.append('codesDel[]', lstDel);
  		$.ajax({
  			type : 'POST',
            url : '/admin/deleteUsers',
            enctype : 'multipart/form-data',
            data : formData,
            contentType: false,
            processData: false
			}).done(function(response) {
			Swal.fire({
       		 text: "Here's a basic example of SweetAlert!",
        	icon: "success",
        	buttonsStyling: false,
        	confirmButtonText: "Ok, got it!",
        	customClass: {
            confirmButton: "btn btn-primary"
        	}
    		});
            	
        	})
        	.fail(function(response) {
            Swal.fire({
       		 text: "Here's a basic example of SweetAlert!",
        	icon: "error",
        	buttonsStyling: false,
        	confirmButtonText: "Ok, got it!",
        	customClass: {
            confirmButton: "btn btn-danger"
        	}
    		});
        	});
});