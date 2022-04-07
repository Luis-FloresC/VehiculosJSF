package unicah.edu.Dominio;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v ORDER BY v.IdVehiculo"),
        @NamedQuery(name="Vehiculo.findById", query="SELECT v FROM Vehiculo v where v.IdVehiculo = :IdVehiculo")
})
@Table(name="vehiculos")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Vehiculo implements Serializable {
    private static final long serialVersionUIO = -6555504856528103960L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdVehiculo")
    private int IdVehiculo;
    private String Placa;
    private String Marca;
    private String Modelo;
    private String Color;
    private int Anio;

    public Vehiculo(){}

    public Vehiculo(int idVehiculo,String  placa,String marca,String modelo, String color,int año)
    {
        this.IdVehiculo = idVehiculo;
        this.Placa =placa;
        setAño(año);
        this.Color = color;
        this.Marca = marca;
        this.Modelo = modelo;
    }

    public Vehiculo(int idVehiculo) {
        IdVehiculo = idVehiculo;
    }

    public int getIdVehiculo(){return  IdVehiculo;}
    public void setIdVehiculo(int id){ this.IdVehiculo = id; }
    public String getPlaca(){return  Placa;}
    public void setPlaca(String placa){ this.Placa = placa; }
    public String getModelo(){return  Modelo;}
    public void setModelo(String modelo){ this.Modelo = modelo; }
    public String getColor(){return  Color;}
    public void setColor(String color){ this.Color = color; }
    public String getMarca(){return  Marca;}
    public void setMarca(String marca){ this.Marca = marca; }
    public int getAño(){return  Anio;}
    public void setAño(int año)
    {
        if(año < 1990)
        {
            this.Anio = 1990;
        }
        else if(año > 2022)
        {
            this.Anio = 2022;
        }
        else
        {
            this.Anio = año;
        }
    }

    @Override
    public String toString()
    {
        return "Vehiculo{" +  '\n' +
                "idVehiculo: " + IdVehiculo + "," + '\n' +
                "Placa: " + Placa + "," +  '\n' +
                "Modelo: " + Modelo +  "," + '\n' +
                "Marca: " + Marca + "," + '\n' +
                "Año: " + Anio + "," + '\n' +
                "Color: " + Color + '\n' +
                "},";
    }

}