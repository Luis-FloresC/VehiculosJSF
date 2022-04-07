package unicah.edu.Web;

import org.primefaces.event.RowEditEvent;
import unicah.edu.Dominio.Vehiculo;
import unicah.edu.Servicio.iVehiculoServicio;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("VehiculosBean")
@RequestScoped
public class VehiculosBean {
   @Inject
    private iVehiculoServicio vehiculoServicio;

    private Vehiculo vehiculoSeleccionado;

    List<Vehiculo> vehiculos;

    public VehiculosBean() {
    }

    @PostConstruct
    public void inicializar(){
        this.vehiculos = vehiculoServicio.listarVehiculos();
        this.vehiculoSeleccionado = new Vehiculo();
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        this.vehiculoSeleccionado = vehiculoSeleccionado;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void editListener(RowEditEvent event){
        Vehiculo vehiculo = (Vehiculo) event.getObject();
        vehiculoServicio.modificarVehiculo(vehiculo);
    }

    public void agregarVehiculo(){
        this.vehiculoServicio.registrarVehiculo(vehiculoSeleccionado);
        this.vehiculos.add(vehiculoSeleccionado);
        this.vehiculoSeleccionado = null;
    }

    public void elimnarVehiculo(){
        this.vehiculoServicio.eliminarVehiculo(vehiculoSeleccionado);
        this.vehiculos.remove(this.vehiculoSeleccionado);
        this.vehiculoSeleccionado = null;
    }

    public void ReinciarVehiculoSeleccionado(){
        this.vehiculoSeleccionado = new Vehiculo();
    }
}
