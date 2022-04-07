package unicah.edu.Servicio;

import unicah.edu.Datos.iVehiculoDao;
import unicah.edu.Dominio.Vehiculo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/Vehiculos")
@Stateless
public class VehiculoServicioRestApi {
    @Inject
    private iVehiculoServicio vehiculoServicio;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Vehiculo> listarVehiculos(){
        return vehiculoServicio.listarVehiculos();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{id}")
    public Vehiculo encontrarVehiculoPorId(@PathParam("id") int id){
        return  vehiculoServicio.encontrarVehiculoPorId(new Vehiculo(id));
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response registrarVehiculo(Vehiculo vehiculo){
        try {
            vehiculoServicio.registrarVehiculo(vehiculo);
            return Response.ok().entity(vehiculo).build();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response modificarVehiculo(@PathParam("id") int id, Vehiculo vehiculoModificado){
        try {
            Vehiculo vehiculo = vehiculoServicio.encontrarVehiculoPorId(new Vehiculo(id));
            if(vehiculo != null){
                vehiculoServicio.modificarVehiculo(vehiculoModificado);
                return Response.ok().entity(vehiculoModificado).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DELETE
    @Path("{id}")
    public Response eliminarVehiculo(@PathParam("id") int id){
        try{
            vehiculoServicio.eliminarVehiculo(new Vehiculo(id));
            return Response.ok().build();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
