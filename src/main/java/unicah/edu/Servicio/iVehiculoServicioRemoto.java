package unicah.edu.Servicio;

import unicah.edu.Dominio.Vehiculo;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface iVehiculoServicioRemoto {

    public List<Vehiculo> listarVehiculos();
    public Vehiculo encontrarVehiculoPorId(Vehiculo vehiculo);
    public Vehiculo encontrarVehiculoPorPlaca(Vehiculo vehiculo);
    public void registrarVehiculo(Vehiculo vehiculo);
    public void modificarVehiculo(Vehiculo vehiculo);
    public void eliminarVehiculo(Vehiculo vehiculo);
}
