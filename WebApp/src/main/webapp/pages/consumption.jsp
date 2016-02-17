<%@page import="com.alberto.fernandez.consumo.luz.pojo.Consumption"%>
<%@page import="com.alberto.fernandez.diez.webapp.Constantes"%>
<%@include file="../include/head.jsp"%>

<%@include file="../include/nav.jsp"%>

<%@include file="../include/mensaje.jsp"%>

<h2>Listado Consumos</h2>
<p>Aqui puedes visualizar, editar y eliminar tus consumos</p>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>Consumo(KW/h)</th>
				<th>Precio(KW/h)</th>
				<th>FechaFin</th>
				<th>Factura</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${requestScope.consumptionlist}" var="item">
					<tr>
						<td><a
							href="<%=Constantes.CONTROLLER_CONSUMPTION %>?op=<%=Constantes.OP_DETALLE%>&id=${item.consumptionId }">${item.consumptionId }</a></td>
						<td>${item.quantity }</td>
						<td>${item.price }</td>
						<td>${item.endingDate }</td>
						<td><fmt:formatNumber value="${item.quantity * item.price }" maxFractionDigits="2" /> &euro;</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
</div>

<%@include file="../include/footer.jsp"%>
