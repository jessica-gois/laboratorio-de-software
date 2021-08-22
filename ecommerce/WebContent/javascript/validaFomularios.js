
$(document).ready(function() {
$("#formCadastroCliente").validate({
	 highlight: function(element) {
     	$(element).parent().parent().addClass('error');
     },
     unhighlight: function(element) {
     	$(element).parent().parent().removeClass('erro');
     },




});
});