function eliminar(id){
swal({
  title: "Esta seguro de eliminar?",
  text: "Una vez borrado, no podrá recuperar estos datos",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/proveedor/delete/" + id,
		success: function(res) {
			console.log(res);
		}
	});
    swal("¡Puf! ¡Tus datos fueron borrados!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/proveedor/all";
		}
});
  } else {
    swal("No se borraron tus datos.");
  }
});
	
}