function eliminar(id){
swal({
  title: "Esta seguro de eliminar?",
  text: "Una vez borrado, no podrá recuperar este pedido!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/pedido/delete/"+id,
		success: function(res) {
			console.log(res);
		}
	});
    swal("¡Puf! ¡Tu pedido ha sido borrado!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/pedido/all";
		}
});
  } else {
    swal("Su pedido esta a salvo.");
  }
});
	
}