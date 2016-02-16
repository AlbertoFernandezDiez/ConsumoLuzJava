<%@page import="com.alberto.fernandez.diez.webapp.Constantes"%>
<%@include file="../include/head.jsp"%>

<%@include file="../include/nav.jsp"%>

<form class="form well" action="<%=Constantes.CONTROLLER_CONSUMPTION%>"
	method="POST">
	<h3>Detalle consumo: </h3>
	<input type="hidden" name="op" value="${requestScope.operation}" />
	<input type="hidden" name="cId" value="${requestScope.consumption.consumptionId}">
	<fieldset>
		<div class="form-group">
			<label for='quantity'>Cantidad:</label><br> <input type='number'
				class="form-control" step="0.1" value="${requestScope.consumption.price}" id='quantity'
				name='quantity' required />
		</div>
		<div class="form-group">
			<label for='price'>Precio(&euro;/Kw):</label><br> <input
				type='number' min="0" step="0.1" value="${requestScope.consumption.price}" class="form-control"
				id='price' name='price' required />
		</div>

		<div class="form-group">
			<label for='endingdate'>Fecha fin facturaci&oacute;n:</label><br>
			<input type='date' class="form-control" id='endingdate'
				name='endingdate' placeholder="dd/MM/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}" value="<fmt:formatDate pattern="dd/MM/yyyy" 
            value="${requestScope.consumption.endingDate}" />" required />
		</div>



		<div class="form-group">
			<c:choose>
				<c:when test="${requestScope.consumption.consumptionId eq -1}">
					<button type="submit"
						class="btn btn-success form-control center-block" value='Añadir'
						id='enviar'>A&ntilde;adir</button>
				</c:when>
				<c:otherwise>
					<div class="form-group">
						<button type="submit" 
							class="btn btn-warning form-control center-block" 
							value='modificar' id='enviar'>Modificar</button>
					</div>
					<div class="form-group">
						<button type="button"
							class="btn btn-danger form-control center-block"  value='eliminar' 
							id='enviar'>Eliminar</button>
							</div>
				</c:otherwise>
			</c:choose>
			
		</div>
	</fieldset>
</form>
<%@include file="../include/footer.jsp"%>