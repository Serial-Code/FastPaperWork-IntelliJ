function eliminar(id){
    swal({
        title: "Esta seguro de eliminar?",
        text: "Una vez borrado, no podrá recuperar esta pqrs!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((ok) => {
            if (ok) {
                $.ajax({
                    url:"/pqrs/delete/"+id,
                    success: function(res) {
                        console.log(res);
                    }
                });
                swal("¡Puf! ¡Tu pqrs ha sido borrado!", {
                    icon: "success",
                }).then((ok)=>{
                    if(ok){
                        location.href="/pqrs/all";
                    }
                });
            } else {
                swal("Su pqrs esta a salvo.");
            }
        });

}