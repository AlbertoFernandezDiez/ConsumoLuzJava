<%@page import="com.alberto.fernandez.diez.webapp.Constantes"%>
<%@include file="../include/head.jsp"%>

<%@include file="../include/nav.jsp"%>

<form class="form well" action="<%=Constantes.CONTROLLER_CONSUMPTION%>"
	method="POST">
	<h3>Detalle consumo:</h3>
	<input type="hidden" name="op" value="${requestScope.operation}" /> <input
		type="hidden" name="cId"
		value="${requestScope.consumption.consumptionId}">
	<fieldset>
		<div class="form-group">
			<label for='quantity'>Cantidad:</label><br> <input type='number'
				class="form-control" step="0.1"
				value="${requestScope.consumption.quantity}" id='quantity'
				name='quantity' required />
		</div>
		<div class="form-group">
			<label for='price'><span><i class="fa fa-eur"></i></span> Precio(&euro;/Kw):</label><br> <input
				type='number' min="0" step="0.1"
				value="${requestScope.consumption.price}" class="form-control"
				id='price' name='price' required />
		</div>

		<div class="form-group">
			<label for='endingdate'><span><i class="fa fa-calendar"></i></span> Fecha fin facturaci&oacute;n:</label><br>
			<input type='text' class="form-control" id='endingdate'
				name='endingdate' placeholder="dd/MM/yyyy"
				pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}"
				value="<fmt:formatDate pattern="dd/MM/yyyy" 
            value="${requestScope.consumption.endingDate}" />"
			<c:if test="${requestScope.consumption.consumptionId > 0}">readonly</c:if>	required />
		</div>



		<div class="form-group">
			<c:choose>
				<c:when test="${requestScope.consumption.consumptionId eq -1}">
					<button type="submit"
						class="btn btn-success form-control center-block" value='Añadir'
						id='enviar'><span><i
							class="fa fa-plus"></i></span> A&ntilde;adir</button>
				</c:when>
				<c:otherwise>
					<div class="form-group">
						<button type="submit"
							class="btn btn-warning form-control center-block"
							value='modificar' id='enviar'>Modificar</button>
					</div>
					<div class="form-group">
						<button type="button"
							class="btn btn-danger form-control center-block" value='eliminar'
							id='enviar' data-toggle="modal" data-target="#eliminar"><span><i class="fa fa-trash"></i></span> Eliminar</button>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</fieldset>
</form>

<!-- Pop Up de eliminación-->
<div class="modal fade" id="eliminar" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">X</span><span class="sr-only">Cerrar</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Eliminaci&oacute;n de
					Consumo</h4>
			</div>
			<div id="nuevaAventura" class="modal-body">
				<form method="post" action="<%=Constantes.CONTROLLER_CONSUMPTION%>">
					<div class="form-group">
						<input type="hidden" name="op" value="<%=Constantes.OP_ELIMINAR%>">
						<input type="hidden" name="id"
							value="${requestScope.consumption.consumptionId}"><label
							for="aviso"> &#191;Est&aacute; seguro que desea eliminar el
							consumo? Esta acci&oacute;n no se puede deshacer.</label>
						<button type="submit" class="btn btn-danger" id="eliminacion"
							style="margin: 10px 0;">Eliminar</button>
						<button type="button" class="btn btn-success" data-dismiss="modal"
							style="margin: 10px 0;">Cerrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- fin Pop Up de eliminación-->
<%@include file="../include/footer.jsp"%>