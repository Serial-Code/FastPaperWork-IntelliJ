function eliminar(id){
swal({
  title: "Esta seguro de eliminar?",
  text: "Una vez borrado, no podrá recuperar esta forma de pago!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/forma_de_pago/delete/"+id,
		success: function(res) {
			console.log(res);
		}
	});
    swal("¡Puf! ¡Tu forma de pago ha sido borrado!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/forma_de_pago/all";
		}
});
  } else {
    swal("Tu forma de pago esta a salvo!");
  }
});
	
}