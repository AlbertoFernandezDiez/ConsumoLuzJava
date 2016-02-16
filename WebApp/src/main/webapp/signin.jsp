<%@include file="include/head.jsp" %> 

	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
	 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>      
		</button>
     <a class="navbar-brand" href="/"><img src="img/logo.svg" style="width:50px; margin-top: -7px" /></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="login.jsp" >Login</a></li>
      </ul>
    </div>
  </div>
</nav>		

		

			
	<form class="form well"name='myform' method="POST" action="<%=Constantes.CONTROLLER_SIGN_IN %>" validate>
	<h3>Registrarse:</h3>
	<fieldset>
	<div class="form-group">
		<label for='consumo'>Nombre:</label><br>
		<input type='text'  class="form-control" placeholder="Usuario" id='name' name='username'  required/>
		</div>
		<div class="form-group">
		<label for='password'>Contraseña:</label><br>
		<input type='password' placeholder="Contraseña" class="form-control" id='password' name='password' required/>
		<br>  
		</div>
	
		<div class="form-group">
		<button  type='submit' class="btn btn-success form-control center-block" value='Enviar' id='enviar')/>Registrarse</button>
		</div>		
	</fieldset>
	</form>
	

	
	<div id="myModal" class='modal fade' data-ng-show="success" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Felicidades</h4>
      </div>
      <div class="modal-body">
        <p>Usuario registrado.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<div id="myModalError" class='modal fade' data-ng-show="success" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Error</h4>
      </div>
      <div class="modal-body">
        <p>El usuario ya esta registrado.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>   

<%@include file="include/footer.jsp" %> 