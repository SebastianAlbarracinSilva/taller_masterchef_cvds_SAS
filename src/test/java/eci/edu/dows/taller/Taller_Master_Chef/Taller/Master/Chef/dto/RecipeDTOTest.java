package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.dto;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeDTOTest {

    private RecipeDTO dto;

    @BeforeEach
    void setUp() {
        dto = new RecipeDTO();
        dto.setTitulo("Tiramisú");
        dto.setIngredientes(Arrays.asList("Café", "Mascarpone"));
        dto.setPasos(Arrays.asList("Preparar base", "Montar crema"));
        dto.setNombreChef("Massimo Bottura");
        dto.setTipoChef(ChefType.CHEF);
        dto.setTemporada(10);
    }

    @Test
    @DisplayName("Caso exitoso - Setters y Getters funcionan correctamente")
    void testSettersYGetters_Exitoso() {
        assertAll("Validar getters",
                () -> assertEquals("Tiramisú", dto.getTitulo()),
                () -> assertEquals(Arrays.asList("Café", "Mascarpone"), dto.getIngredientes()),
                () -> assertEquals(Arrays.asList("Preparar base", "Montar crema"), dto.getPasos()),
                () -> assertEquals("Massimo Bottura", dto.getNombreChef()),
                () -> assertEquals(ChefType.CHEF, dto.getTipoChef()),
                () -> assertEquals(10, dto.getTemporada())
        );
    }

    @Test
    @DisplayName("Caso borde - Campos nulos")
    void testCamposNulos_Borde() {
        RecipeDTO r = new RecipeDTO();
        assertAll("Validar campos nulos",
                () -> assertNull(r.getTitulo()),
                () -> assertNull(r.getIngredientes()),
                () -> assertNull(r.getPasos()),
                () -> assertNull(r.getNombreChef()),
                () -> assertNull(r.getTipoChef()),
                () -> assertNull(r.getTemporada())
        );
    }
}
