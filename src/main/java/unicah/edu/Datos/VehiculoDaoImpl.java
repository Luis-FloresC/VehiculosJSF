package unicah.edu.Datos;

import unicah.edu.Dominio.Vehiculo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class VehiculoDaoImpl implements iVehiculoDao{

    @PersistenceContext(unitName="VehiculoPU")
    EntityManager em;

    @Override
    public List<Vehiculo> findAllVehiculos() {
        return em.createNamedQuery("Vehiculo.findAll").getResultList();
    }

    @Override
    public Vehiculo findVehiculoById(Vehiculo vehiculo) {
        return em.find(Vehiculo.class,vehiculo.getIdVehiculo());
    }

    @Override
    public Vehiculo findVehiculoByPlaca(Vehiculo vehiculo) {
        Query query = em.createQuery("select v from Vehiculo v where v.Placa =:Placa");
        query.setParameter("Placa", vehiculo.getPlaca());
        return (Vehiculo) query.getSingleResult();
    }

    @Override
    public void insertVehiculo(Vehiculo vehiculo) {
        em.persist(vehiculo);
    }

    @Override
    public void updateVehiculo(Vehiculo vehiculo) {
        em.merge(vehiculo);
    }

    @Override
    public void deleteVehiculo(Vehiculo vehiculo) {
        em.remove(em.merge(vehiculo));
    }
}
