import javax.swing.*;
public class Cuenta {
  protected double saldo;
  protected int numeroConsignacion = 0;
  protected int numeroRetiro = 0;
  protected double tasaAnual;
  protected double comisionMensual = 0;
  protected int numeroExtracto = 0;

  public Cuenta(double saldo, double tasaAnual) {
    this.saldo = saldo;
    this.tasaAnual = tasaAnual;
  }

  public void consignar(double valor) {
    if(valor >= 0){
      this.saldo = saldo + valor;
      numeroConsignacion += 1;
      System.out.println("Saldo actual: " + Math.round(saldo * 100.0) / 100.0 + " -- Numero de consignaciones: " + (numeroConsignacion));
    } 
    else {
      JOptionPane.showMessageDialog(null,"El valor a consignar no puede ser negativo");
    }
  }

  public void retirar(double valor) {
    if(valor <= saldo && valor >= 0){
      this.saldo = saldo - valor;
      System.out.println("Retiro exitoso");
      numeroRetiro += 1;
      System.out.println("Saldo actual: " + Math.round(saldo * 100.0) / 100.0 + " -- Numero de retiros: " + (numeroRetiro));
    }
    else {
      JOptionPane.showMessageDialog(null, "El valor a retirar no puede ser negativo o mayor al saldo");
    }

    if (numeroRetiro > 4){
      comisionMensual += 1000;
      this.saldo = saldo - 1000;
      System.out.println("Se ha cobrado una comision de $1000 por exceder el limite de retiros");
    }
  }

  public double calcularInteresMensual(double saldo) {
    this.saldo = saldo + (saldo * (((tasaAnual * 100) / 365) * 30 / 100));
    System.out.println("Interes exitoso");
    System.out.println("El interes mensual es: " + Math.round((saldo * (((tasaAnual * 100) / 365) * 30 / 100)) * 100.0) / 100.0);
    return Math.round(saldo  * 100.0) / 100.0;
  }
  
  public boolean extractoMensual(double saldo){
    if (this.saldo < 10000){
      System.out.println("La cuenta esta inactiva");
    }
    else {
      System.out.println();
      System.out.println("La cuenta esta activa");
      System.out.println();
      System.out.println("Saldo actual menos comision mensual: " + calcularInteresMensual(saldo));
      return true;
    } 
    return false;
  }

  public void mostrarDatos() {
    int transacciones = numeroConsignacion + numeroRetiro;
    JOptionPane.showMessageDialog(null, "INFORMACION DE CUENTA \nSaldo: " + Math.round(saldo*100.0)/100.0 + "$\nNumero de transacciones: " + transacciones + "\nNumero de consignaciones: " + numeroConsignacion + "\nNumero de retiros: " + numeroRetiro + "\nTasa anual: " + Math.round((tasaAnual*100)*100.0)/100.0 + "%\nComision mensual: " + comisionMensual + "$");
  }

  /*
  * Getters ->
  */
  
  public double getSaldo() {
    return saldo;
  }
  
  public int getNumeroConsignacion() {
    return numeroConsignacion;
  }
  
  public int getNumeroRetiro() {
    return numeroRetiro;
  }
  
  public double getTasaAnual() {
    return tasaAnual;
  }
  
  public double getComisionMensual() {
    return comisionMensual;
  }
  
  /*
  * Setters ->
  */

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
  
  public void setNumeroConsignacion(int numeroConsignacion) {
    this.numeroConsignacion = numeroConsignacion;
  }
  
  public void setNumeroRetiro(int numeroRetiro) {
    this.numeroRetiro = numeroRetiro;
  }
  
  public void setTasaAnual(double tasaAnual) {
    this.tasaAnual = tasaAnual;
  }
  
  public void setComisionMensual(double comisionMensual) {
    this.comisionMensual = comisionMensual;
  }	

}