function eliminar(id){
swal({
  title: "Esta seguro de eliminar?",
  text: "Una vez borrado, no podrá recuperar este archivo!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/eliminar/usuario/"+id,
		success: function(res) {
			console.log(res);
		}
	});
    swal("¡Puf! ¡Tu archivo ha sido borrado!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/listar/usuario";
		}
});
  } else {
    swal("Su archivo está a salvo.");
  }
});
	
}