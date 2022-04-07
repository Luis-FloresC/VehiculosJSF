package unicah.edu.Servicio;
import unicah.edu.Dominio.Vehiculo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface iVehiculoServicio {
    public List<Vehiculo> listarVehiculos();
    public Vehiculo encontrarVehiculoPorId(Vehiculo vehiculo);
    public Vehiculo encontrarVehiculoPorPlaca(Vehiculo vehiculo);
    public void registrarVehiculo(Vehiculo vehiculo);
    public void modificarVehiculo(Vehiculo vehiculo);
    public void eliminarVehiculo(Vehiculo vehiculo);
}
