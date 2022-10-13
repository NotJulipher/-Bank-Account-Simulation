import javax.swing.*;
public class CuentaCorriente extends Cuenta{
  protected double sobregiro = 0;
  
  CuentaCorriente(double saldo, double tasaAnual) {
    super(saldo, tasaAnual);
  }
  
  
  public void consignar(double valor) {
    if(valor >= 0){
      if (sobregiro > 0 && (valor - sobregiro) > 0){
        this.saldo = valor - sobregiro;
        this.sobregiro =0;
        numeroConsignacion += 1;
      }
      else if (sobregiro > 0 && (valor - sobregiro) < 0){
        this.saldo = 0;
        this.sobregiro = sobregiro - valor;
        numeroConsignacion += 1;
      }
      else if (sobregiro == 0 && saldo >= 0){
        this.saldo = saldo + valor;
        this.sobregiro = 0;
        numeroConsignacion += 1;
      }
    }

    else {
      JOptionPane.showMessageDialog(null,"El valor a consignar no puede ser negativo");
    }
  }

  public void extractoMensual(){
    if (saldo > 0){
      System.out.println("La cuenta esta activa");
      System.out.println("Saldo sin intereses: " + calcularInteresMensual(saldo));
      System.out.println("Saldo actual: " + Math.round(saldo * 100.0) / 100.0);
    }
    else{
      System.out.println("No se puede calcular el extracto mensual, porque hay sobregiro");
    }
  }
  
  public void mostrarDatos() {
    int transacciones = numeroConsignacion + numeroRetiro;
    JOptionPane.showMessageDialog(null, "INFORMACION DE CUENTA \nSaldo: " + Math.round(saldo*100.0)/100.0 + "$\nNumero de transacciones: " + transacciones + "\nNumero de consignaciones: " + numeroConsignacion + "\nNumero de retiros: " + numeroRetiro + "\nTasa anual: " + Math.round((tasaAnual*100)*100.0)/100.0 + "%\nSobregiro: " + sobregiro + "$");
  }

  public void retirar(double valor) {
    if(valor >= 0){
      if (saldo == 0 && sobregiro >= 0){
        this.sobregiro = sobregiro + valor;
        this.saldo = 0;
        numeroRetiro += 1;
      }

      else if (saldo > 0 && (saldo - valor) < 0){
        this.sobregiro = valor - saldo;
        this.saldo = 0;
        numeroRetiro += 1;
      }
      
      else if (saldo > 0 && (saldo - valor) > 0){
        this.sobregiro = 0;
        this.saldo = saldo - valor;
        numeroRetiro += 1;
      }

      else if (saldo >= 0 && (saldo - valor) == 0){
        this.saldo = 0;
        this.sobregiro = 0;
        numeroRetiro += 1;
      }
      
      System.out.println("Saldo actual: " + Math.round(saldo * 100.0) / 100.0 + " -- Numero de retiros: " + (numeroRetiro));
      System.out.println("El sobregiro es: " + Math.round(sobregiro * 100.0) / 100.0);
      System.out.println("Retiro exitoso");
    }

    else {
      JOptionPane.showMessageDialog(null, "El valor a retirar no puede ser negativo o mayor al saldo");
    }
  
  }

  public void movimientosCuentaCorriente() {
    int opcion;
    do{
      opcion = Integer.parseInt(JOptionPane.showInputDialog( "Seleccione una opcion con la cuenta corriente\n1. Consignar\n2. Retirar\n3. Calcular extracto mensual\n4. Mostrar datos\n5. Salir"));
      switch (opcion) {
        case 1:
          consignar(Double.parseDouble(JOptionPane.showInputDialog("Digite el valor a consignar")));
          break;

        case 2:
          retirar(Double.parseDouble(JOptionPane.showInputDialog("Digite el valor a retirar")));
          break;

        case 3:
          extractoMensual();
          break;

        case 4:
          mostrarDatos();
          break;

        case 5:
          System.out.println("Gracias por usar nuestros servicios");
          break;

        default:
          JOptionPane.showMessageDialog(null, "Opcion invalida");
          break;
      }
    } while (opcion != 5);
  }

}