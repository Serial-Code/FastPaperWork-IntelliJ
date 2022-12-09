function eliminar(id){
    swal({
        title: "Esta seguro de eliminar?",
        text: "Una vez borrado, no podrá recuperar esta respuesta!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((ok) => {
            if (ok) {
                $.ajax({
                    url:"/respuesta/delete/"+id,
                    success: function(res) {
                        console.log(res);
                    }
                });
                swal("¡Puf! ¡Tu respuesta ha sido borrada!", {
                    icon: "success",
                }).then((ok)=>{
                    if(ok){
                        location.href="/respuesta/all";
                    }
                });
            } else {
                swal("Su respuesta esta a salvo.");
            }
        });

}