package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

    private Recipe recipe;
    private List<String> ingredientes;
    private List<String> pasos;

    @BeforeEach
    void setUp() {
        ingredientes = Arrays.asList("Harina", "Huevos", "Azúcar");
        pasos = Arrays.asList("Mezclar", "Hornear", "Servir");

        recipe = new Recipe("Pastel", ingredientes, pasos, "Gordon Ramsay", ChefType.CHEF, 5);
    }

    @Test
    @DisplayName("Caso exitoso - Constructor inicializa todos los campos correctamente")
    void testConstructor_Exitoso() {
        assertAll("Validar campos del constructor",
                () -> assertEquals("Pastel", recipe.getTitulo()),
                () -> assertEquals(ingredientes, recipe.getIngredientes()),
                () -> assertEquals(pasos, recipe.getPasos()),
                () -> assertEquals("Gordon Ramsay", recipe.getNombreChef()),
                () -> assertEquals(ChefType.CHEF, recipe.getTipoChef()),
                () -> assertEquals(5, recipe.getTemporada())
        );
    }

    @Test
    @DisplayName("Caso exitoso - Setters y Getters funcionan correctamente")
    void testSettersYGetters_Exitoso() {
        Recipe r = new Recipe();
        r.setTitulo("Pizza");
        r.setIngredientes(Arrays.asList("Harina", "Queso"));
        r.setPasos(Arrays.asList("Amasar", "Hornear"));
        r.setNombreChef("Jamie Oliver");
        r.setTipoChef(ChefType.PARTICIPANTE);
        r.setTemporada(3);

        assertAll("Validar getters",
                () -> assertEquals("Pizza", r.getTitulo()),
                () -> assertEquals(Arrays.asList("Harina", "Queso"), r.getIngredientes()),
                () -> assertEquals(Arrays.asList("Amasar", "Hornear"), r.getPasos()),
                () -> assertEquals("Jamie Oliver", r.getNombreChef()),
                () -> assertEquals(ChefType.PARTICIPANTE, r.getTipoChef()),
                () -> assertEquals(3, r.getTemporada())
        );
    }

    @Test
    @DisplayName("Caso borde - Campos con valores null")
    void testCamposNull_Borde() {
        Recipe r = new Recipe(null, null, null, null, null, null);
        assertAll("Validar valores null",
                () -> assertNull(r.getTitulo()),
                () -> assertNull(r.getIngredientes()),
                () -> assertNull(r.getPasos()),
                () -> assertNull(r.getNombreChef()),
                () -> assertNull(r.getTipoChef()),
                () -> assertNull(r.getTemporada())
        );
    }
}
