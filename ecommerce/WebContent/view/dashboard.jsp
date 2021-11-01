<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
 <script src="https://www.amcharts.com/lib/3/serial.js"></script>
 <script src="https://www.amcharts.com/lib/3/pie.js"></script>
 <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
 <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
 <%@ page import="java.util.List, dto.GraficoVendasLivroDTO" %>
<!DOCTYPE html>
<html lang="pt-br">
<c:import url="template-head-admin.jsp" />
<body>
<c:import url="template-header-admin.jsp" />
<c:url value="/controlador" var="stub"/>
<fmt:setLocale value = "pt_BR"/>
<%
	String dadosGrafico = (String) request.getSession().getAttribute("dadosGrafico");
	List<GraficoVendasLivroDTO> listaDadosPeriodo = (List<GraficoVendasLivroDTO>) request.getSession().getAttribute("listaDto");
%>
</body>
<div class="container">
<p class="h4 mb-2 mt-5">Dashboard de vendas</p>
	<div class="card mb-3 mt-3">		
		<div class="card-body">
			<div class="row">
				<div class="col-4">
					<p class="h5">Data inicial</p>
				</div>
				<div class="col-4">
					<p class="h5">Data final</p>
				</div>
				<div class="col-2">
					<p class="h5" style="color: #FFF;"></p>
				</div>
			</div>
			<form id="formConsultaDashboard" action="${stub}" method="post"
				novalidate>
				<div class="row mb-2 d-flex align-items-center">
					<div class="col-4">
						<input class="form-control" type="date" id="dataInicial"
							name="dataInicial" required="true" />
					</div>
					<div class="col-4">
						<input class="form-control" type="date" id="dataFinal"
							name="dataFinal" required="true"/>
					</div>
					<input type="hidden" name="acao" value="consultar" />
					<input type="hidden" name="viewHelper" value="ConsultarGraficoVendasLivroVH" />
					<div class="col-2">
						<button class="btn btn-blue w-100" type="submit" title="Buscar"
							alt="Buscar">Buscar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<div id="lineChart" class="<%=dadosGrafico == null || dadosGrafico.isBlank()
	? "d-none"  : ""%>" style="height: 300px;"></div>

<%if(listaDadosPeriodo != null && !listaDadosPeriodo.isEmpty()){%>	
	<div class="ms-4" style="width: 97%;">
	<center><p class="h5 mb-3 mt-2">Relatório geral de vendas</p></center>
	<div class="row">
		<div>
			<div class="col-12 mb-3">				
				<div class="row d-flex justify-content-between">
					<table class="table">
						<thead class="table table-striped ">
							<tr>
								<th>Mês</th>
								<th>Quantidade vendida</th>
								<th>Total do faturamento</th>								
							</tr>
						</thead>
						<tbody>
							<%
								for (GraficoVendasLivroDTO dto : listaDadosPeriodo) {
							%>
							<tr>
								<td><%=dto.getPeriodo()%></td>
								<td><fmt:formatNumber value = "<%=dto.getQuantidadeTotalVendasPeriodo()%>" type = "number" maxFractionDigits="0"/></td>
								<td><fmt:formatNumber value = "<%=dto.getValorTotalVendasPeriodo()%>" type = "currency"/></td>								
							<%
								}
							%>
						</tbody>
					</table>
					<br />
				</div>
			</div>
		</div>
	</div>
</div>
<%
	}
%>

<script>
	 const dados = <%=dadosGrafico%>
	 
	 if (typeof dados != "undefined") {
	let chart = AmCharts.makeChart("lineChart",
				{	
					"type": "serial",
					"categoryField": "category",
					"startDuration": 1,
					"dataProvider": dados,
					"theme": "light",
					"categoryAxis": {
						"gridPosition": "start"
					},
					 "export": {
						 "enabled": true
						  },
					"trendLines": [],
					"graphs": [],
					"guides": [],
					"valueAxes": [
						{
							"id": "ValueAxis-1",
							"title": "Unidades vendidas"
						}
					],
					"allLabels": [],
					"balloon": {},
					"legend": {
						"enabled": true,
						"useGraphSettings": true
					},
					"titles": [
						{
							"id": "Title-1",
							"size": 15,
							"text": "Volume de vendas no período por livro"
						}
					]					
				}
			);
	 
	 let campos = [];
     chart.dataProvider.forEach(dado => campos.push(Object.keys(dado).filter(function (value) {
         return value !== chart.categoryField;
     })));
     campos = campos.join().split(",")

	let valorCampos = campos.filter(function (valor, i) {
         return campos.indexOf(valor) === i;
     });

     valorCampos.forEach(function (valueField) {
         chart.graphs.push({
             "valueField": valueField,
             "title": valueField,
             "type": "line",
             "bullet": "round",
             "bulletSize": 10,
             "bulletBorderThickness": 2,
             "balloonText": "[[title]]:[[value]] vendas",
             "lineAlphas": 0.2
         })
     });
	 } 
	 
</script>
<!--<c:import url="template-footer.jsp" />-->
</html>