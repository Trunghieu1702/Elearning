renderPermisson(roleLst);
var dt = $('#kt_datatable_role').DataTable( {
    "draw": 1,
    "recordsTotal": 57,
    "recordsFiltered": 57,
    "data":roleLst,
    columns: [
        { data: 'id' },
        { data: 'name' },
        { 
        data: 'strPermisssion' ,
        render: function (data, type) {
        			
                    return data;
                },
        }
    ]
});
;

$('#btnSearch').on( 'keyup', function () {
    dt.search( this.value ).draw();
} );

function renderMgrRole(roleDisplay){
	console.log(roleDisplay);
	if(roleDisplay.permisssion) return ;
	
	
}


renderMgrRole(roleDisplay);
$('#pnlRole').append(txtAccording);


