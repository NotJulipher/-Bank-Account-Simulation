import javax.swing.*;
public class CuentaAhorros extends Cuenta{
  protected boolean estado;
  int opcion;
  int contadorRetiros = 0;


  public CuentaAhorros(double saldo, double tasaAnual) {
    super(saldo, tasaAnual);
  }

  public void movimientosCuentaAhorros() {
    if (saldo < 10000) {
      estado = false;
    } else {
      estado = true;
    }

    do{
      opcion = Integer.parseInt(JOptionPane.showInputDialog( "Seleccione una opcion\n1. Consignar\n2. Retirar\n3. Calcular extracto mensual\n4. Mostrar datos\n5. Salir"));
      switch (opcion) {
        case 1:
          if (estado == true) {
            consignar(Double.parseDouble(JOptionPane.showInputDialog("Digite el valor a consignar")));
          } 
          else {
            JOptionPane.showMessageDialog(null, "No se puede consignar, la cuenta esta inactiva");
          }
          break;

        case 2:
          if (estado == true) {
            retirar(Double.parseDouble(JOptionPane.showInputDialog("Digite el valor a retirar")));
          } 
          else {
            JOptionPane.showMessageDialog(null, "No se puede retirar, la cuenta esta inactiva");
          }
          break;

        case 3:
          if (estado == true) {
            if (extractoMensual(this.saldo) == true) {
              estado = true;
            }
            else {
              estado = false;
            }
            System.out.println();
            System.out.println("El saldo actual con intereses es: " + Math.round(saldo * 100.0) / 100.0);
          } 
          else {
            JOptionPane.showMessageDialog(null, "No se puede calcular el extracto mensual, la cuenta esta inactiva");
          }
          break;

        case 4:
          mostrarDatos();
          break;

        case 5:
          JOptionPane.showMessageDialog(null, "Gracias por usar nuestros servicios");
          break;

        default:
          JOptionPane.showMessageDialog(null, "Opcion invalida");
          break;
      }
    } while (opcion != 5);

  }
  
}
