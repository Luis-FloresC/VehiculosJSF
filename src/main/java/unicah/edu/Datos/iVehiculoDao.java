package unicah.edu.Datos;



import unicah.edu.Dominio.Vehiculo;

import java.util.List;

public interface iVehiculoDao {
    public List<Vehiculo> findAllVehiculos();

    public Vehiculo findVehiculoById(Vehiculo vehiculo);

    public Vehiculo findVehiculoByPlaca(Vehiculo vehiculo);

    public void insertVehiculo(Vehiculo vehiculo);

    public void updateVehiculo(Vehiculo vehiculo);

    public void deleteVehiculo(Vehiculo vehiculo);

}