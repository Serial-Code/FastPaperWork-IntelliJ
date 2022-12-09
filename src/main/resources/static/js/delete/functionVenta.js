function eliminar(id){
swal({
  title: "Esta seguro de eliminar?",
  text: "Una vez borrado, no podrá recuperar esta venta!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/venta/delete/"+id,
		success: function(res) {
			console.log(res);
		}
	});
    swal("¡Puf! ¡Tu venta ha sido borrado!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/venta/all";
		}
});
  } else {
    swal("Su archivo está a salvo.");
  }
});
	
}