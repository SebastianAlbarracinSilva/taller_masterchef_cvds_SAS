package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;
    private String titulo;
    private List<String> ingredientes;
    private List<String> pasos;
    private String nombreChef;
    private ChefType tipoChef;
    private Integer temporada;

    public Recipe() {}

    public Recipe(String titulo, List<String> ingredientes, List<String> pasos,
                  String nombreChef, ChefType tipoChef, Integer temporada) {
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.nombreChef = nombreChef;
        this.tipoChef = tipoChef;
        this.temporada = temporada;
    }

    public String getId() { return id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public List<String> getIngredientes() { return ingredientes; }
    public void setIngredientes(List<String> ingredientes) { this.ingredientes = ingredientes; }

    public List<String> getPasos() { return pasos; }
    public void setPasos(List<String> pasos) { this.pasos = pasos; }

    public String getNombreChef() { return nombreChef; }
    public void setNombreChef(String nombreChef) { this.nombreChef = nombreChef; }

    public ChefType getTipoChef() { return tipoChef; }
    public void setTipoChef(ChefType tipoChef) { this.tipoChef = tipoChef; }

    public Integer getTemporada() { return temporada; }
    public void setTemporada(Integer temporada) { this.temporada = temporada; }
}
