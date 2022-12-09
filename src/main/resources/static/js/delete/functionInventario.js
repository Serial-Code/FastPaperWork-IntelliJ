function eliminar(id){
swal({
  title: "Esta seguro de eliminar?",
  text: "Una vez borrado, no podrá recuperar este producto!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/inventario/delete/"+id,
		success: function(res) {
			console.log(res);
		}
	});
    swal("¡Puf! ¡Tu producto ha sido borrado!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/inventario/all";
		}
});
  } else {
    swal("Su producto esta a salvo.");
  }
});
	
}