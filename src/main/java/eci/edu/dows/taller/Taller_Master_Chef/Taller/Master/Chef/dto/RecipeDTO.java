package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.dto;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import java.util.List;

public class RecipeDTO {
    private String titulo;
    private List<String> ingredientes;
    private List<String> pasos;
    private String nombreChef;
    private ChefType tipoChef;
    private Integer temporada;

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
