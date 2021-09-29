<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <c:import url="template-head.jsp" />
    <title>Cupons</title>
</head>

<body>
    <header>
        <c:import url="template-header.jsp" />
    </header>
    <div class="container">
        <div class="card shadow mb-5 pb-5">
            <div class="card-body">
                <h3>Cupons</h3>
                <hr class="my-3">
                <div class="row">
                    <div class="col">
                        <p class="h5">Tipo</p>
                    </div>
                    <div class="col">
                        <p class="h5">Código</p>
                    </div>
                    <div class="col">
                        <p class="h5">Valor</p>
                    </div>
                    <div class="col">
                        <p class="h5">Status</p>
                    </div>
                </div>
                <hr class="my-2">
                <div class="row pt-2">
                    <div class="d-flex align-items-end col ">
                        <p>Promocional</p>
                    </div>
                    <div class="col">
                        <p>12345</p>
                    </div>
                    <div class="col">
                        <p>0,90</p>
                    </div>
                    <div class="col">
                        <p>Utilizado</p>
                    </div>
                </div>
                <div class="row pt-2">
                    <div class="d-flex align-items-end col ">
                        <p>Troca</p>
                    </div>
                    <div class="col">
                        <p>34</p>
                    </div>
                    <div class="col">
                        <p>1,00</p>
                    </div>
                    <div class="col">
                        <p>Utilizado</p>
                    </div>
                </div>
                <div class="row pt-2">
                    <div class="d-flex align-items-end col ">
                        <p>Promocional</p>
                    </div>
                    <div class="col">
                        <p>111111</p>
                    </div>
                    <div class="col">
                        <p>10,00</p>
                    </div>
                    <div class="col">
                        <p>Disponível</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-3">
                <a class="btn btn-secondary w-100" href="#">Voltar</a>
            </div>
        </div>
    </div>
</body>
</html>