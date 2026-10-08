package manhatan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    @DisplayName("Distancia entre el mismo punto debe ser 0")
    void distanciaMismoPuntoEsCero() {
        Point p = new Point(5, 5);
        assertEquals(0, Point.manhattanDistance(p, p));
    }
    @Test
    @DisplayName("Distancia horizontal y vertical pura")
    void distanciaLineaRecta() {
        Point p1 = new Point(2, 5);
        Point p2 = new Point(8, 5);
        assertEquals(6, Point.manhattanDistance(p1, p2));
    }
    @Test
    @DisplayName("Distancia entre distintos cuadrantes (coordenadas negativas)")
    void distanciaCoordenadasNegativas() {
        Point p1 = new Point(-3, 4);
        Point p2 = new Point(2, -1);
        assertEquals(10, Point.manhattanDistance(p1, p2));
    }
    @ParameterizedTest(name = "P1({0},{1}) y P2({2},{3}) ->; Distancia: {4}")
    @CsvSource({ "0, 0, 0, 0, 0", "1, 1, 4, 5, 7", "-1, -1, -4, -5, 7", "10, -20, -10, 20, 60" })
    @DisplayName("Pruebas parametrizadas de clases de equivalencia")
    void distanciaCasosParametrizados(int x1, int y1, int x2, int y2, int esperado) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        assertEquals(esperado, Point.manhattanDistance(p1, p2));
    }
    @Test
    @DisplayName("Validacion de excepcion ante puntos nulos")
    void lanzaExcepcionSiPuntoEsNulo() {
        Point p = new Point(1, 1);
        assertThrows(IllegalArgumentException.class, () -> Point.manhattanDistance(null, p));
    }
}