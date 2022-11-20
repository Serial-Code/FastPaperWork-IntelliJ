function session(){
swal({
  title: "¿Cerrar sesion, esta seguro?",
  text: "Al salir contara que no esta registrado",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	$.ajax({
		url:"/logearse",
		success: function(res) {
			console.log(res);
		}
	});
    swal("¡Se ha cerrado session correctamente!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/logearse";
		}
});
  } else {
    swal("Cancelado");
  }
});
	
}