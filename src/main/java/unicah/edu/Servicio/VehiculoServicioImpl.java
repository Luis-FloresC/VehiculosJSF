package unicah.edu.Servicio;

import unicah.edu.Datos.iVehiculoDao;
import unicah.edu.Dominio.Vehiculo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class VehiculoServicioImpl implements iVehiculoServicio,iVehiculoServicioRemoto {

    @Inject
    private iVehiculoDao vehiculoDao;

    @Override
    public List<Vehiculo> listarVehiculos() {
        return vehiculoDao.findAllVehiculos();
    }

    @Override
    public Vehiculo encontrarVehiculoPorId(Vehiculo vehiculo) {
        return vehiculoDao.findVehiculoById(vehiculo);
    }

    @Override
    public Vehiculo encontrarVehiculoPorPlaca(Vehiculo vehiculo) {
        return vehiculoDao.findVehiculoByPlaca(vehiculo);
    }

    @Override
    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculoDao.insertVehiculo(vehiculo);
    }

    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
        vehiculoDao.updateVehiculo(vehiculo);
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoDao.deleteVehiculo(vehiculo);
    }
}
