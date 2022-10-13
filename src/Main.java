import javax.swing.*;
public class Main {
  public static void main(String[] args) {
    int opcion = 0;

    CuentaAhorros cuenta1 = new CuentaAhorros(100000, 0.28);
    CuentaCorriente cuenta2 = new CuentaCorriente(100000, 0.30);

    
    do {
      opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion\n1. Cuenta de ahorros\n2. Cuenta corriente\n3. Salir"));
      switch (opcion) {
        case 1:
          System.out.println("Cuenta 1");
          cuenta1.movimientosCuentaAhorros();
          break;
        case 2:
          System.out.println("Cuenta 2");
          cuenta2.movimientosCuentaCorriente();
          break;
      }
      
    } while (opcion != 3);
    
  }
}
