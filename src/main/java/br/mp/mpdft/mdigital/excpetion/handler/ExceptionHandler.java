package br.mp.mpdft.mdigital.excpetion.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.mp.mpdft.mdigital.excpetion.NegocioException;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable e) {
		ResponseError response = new ResponseError();
		if (e instanceof NegocioException) {
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(response).type(MediaType.APPLICATION_JSON).build();
		} else {
			response.setStatus("ERROR");
			response.setMessage("Erro interno, favor entre com contato com o administrador do sistema!");
			return Response.serverError().entity(response).type(MediaType.APPLICATION_JSON).build();
		}
	}
}
