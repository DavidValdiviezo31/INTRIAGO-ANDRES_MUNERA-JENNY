import models.Odontologo;
import services.OdontologoService;

public class Main {
  public static void main(String[] args) {
    OdontologoService service = new OdontologoService(false);

    Odontologo od1 = new Odontologo(35453, "Jenny", "Munera");
    Odontologo od2 = new Odontologo(65987, "Andres", "Intriago");

    service.guardarOdontologo(od1);
    service.guardarOdontologo(od2);

    service.obtenerOdontologos();

  }
}
