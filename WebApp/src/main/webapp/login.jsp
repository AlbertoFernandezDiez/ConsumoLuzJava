<%@include file="include/head.jsp" %> 

		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/"><img src="img/logo.svg"
						style="width: 50px; margin-top: -7px" /></a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="signin.jsp">Registro</a></li>
					</ul>
					<ul class="nav navbar-nav">
						<li><a target="_blank" href="documentacion.jsp">Documentación</a></li>
					</ul>
				</div>
			</div>
		</nav>



<%@include file="/include/mensaje.jsp"%>
		<form class="form well" action="<%=Constantes.CONTROLLER_LOGIN%>" method="POST">
			<h3>Inicia sesión:</h3>
			<fieldset>
				<div class="form-group">
					<label for='consumo'>Nombre:</label><br> <input type='text'
						class="form-control" id='name' name='username' 
						required />
				</div>
				<div class="form-group">
					<label for='password'>Contraseña:</label><br> <input
						type='password' class="form-control" id='password' name='password'
						required />
				</div>

				<div class="form-group">
					<button type="submit"
						class="btn btn-success form-control center-block"
						value='Enviar' id='enviar' )/>
					Identificarse
					</button>
				</div>
			</fieldset>
		</form>


	</div>

<%@include file="include/footer.jsp" %> 