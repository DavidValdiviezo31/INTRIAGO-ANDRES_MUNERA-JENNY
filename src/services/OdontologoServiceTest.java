package services;

import models.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

  @Test
  void obtenerOdontologosUsandoDB() {
    // Arrange
    OdontologoService service = new OdontologoService(true);

    Odontologo od1 = new Odontologo(35453, "Jenny", "Munera");
    Odontologo od2 = new Odontologo(65987, "Andres", "Intriago");

    // Act
    service.guardarOdontologo(od1);
    service.guardarOdontologo(od2);
    List<Odontologo> listaOdontologos = service.obtenerOdontologos();

    int expected = 2;
    int actual = listaOdontologos.size();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void obtenerOdontologosSinDB() {
    // Arrange
    OdontologoService service = new OdontologoService(false);

    Odontologo od1 = new Odontologo(35453, "Jenny", "Munera");
    Odontologo od2 = new Odontologo(65987, "Andres", "Intriago");

    // Act
    service.guardarOdontologo(od1);
    service.guardarOdontologo(od2);
    List<Odontologo> listaOdontologos = service.obtenerOdontologos();

    int expected = 2;
    int actual = listaOdontologos.size();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void verificarPrimerOdontologo(){
    OdontologoService service = new OdontologoService(false);

    Odontologo od1 = new Odontologo(35453, "Jenny", "Munera");
    Odontologo od2 = new Odontologo(65987, "Andres", "Intriago");

    // Act
    service.guardarOdontologo(od1);
    service.guardarOdontologo(od2);
    List<Odontologo> listaOdontologos = service.obtenerOdontologos();

    String expected = "Jenny";
    String actual = listaOdontologos.getFirst().getNombre();

    // Assert
    assertEquals(expected, actual);
  }
}