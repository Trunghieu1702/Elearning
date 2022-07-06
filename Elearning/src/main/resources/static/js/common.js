//var roleOfUser =[[${roleOfUser}]];
//	console.log(roleOfUser);

var txtAccording = '<div class="accordion-item"><h2 class="accordion-header" id="header_{{{panelheader}}}"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-{{{panelbody}}}" aria-expanded="true" aria-controls="panelsStayOpen-{{{panelbody}}}">'
			+'{{{header}}}</button></h2><div id="panelsStayOpen-{{{panelbody}}}" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingOne"><div class="accordion-body">{{{body}}}</div></div></div>';
function renderPermisson(roleLst){
	if(roleLst.length<1)return;
	roleLst.forEach(function(item){
		var str='<div class="accordion" id="accordionPanels">';
		var n =0; 
		item.permisssion.forEach(function(item1){
			n++;
			str+=txtAccording;
			var strbody='';
			str= str.replaceAll("{{{header}}}", item1.title);
			item1.items.forEach(function(item2){
				strbody+='<div style="display: flex;align-items: center;justify-content: space-between;"><span style="display: flex;align-items: center;text-transform: uppercase;"><span class="bullet bg-danger"></span>'+ item2.title +'</span>'
				 + '<input type="checkbox" id="'+item1.name+'-'+item.id+'" name="'+item1.name+'-'+item.id+'" value="'+item2.name+'" '+(item2.value?'checked':'')+' '+(item.id!=0?'onclick="return false;"':'')+'>'
				 + '</div>';
			});
			str= str.replaceAll("{{{body}}}",strbody);
			str= str.replaceAll("{{{panelheader}}}", item.name+'_'+n);
			str= str.replaceAll("{{{panelbody}}}", item.name+'_'+n);
		});
		str+='</div>';
		
		item.strPermisssion=str;
	});

}