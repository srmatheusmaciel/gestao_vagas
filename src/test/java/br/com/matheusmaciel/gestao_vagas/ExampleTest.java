package br.com.matheusmaciel.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExampleTest {


  @Test
  public void deve_ser_possivel_calcular_dois_numeros(){
    var result = calculate(5, 5);
    assertEquals(result, 10);
  }




  public static int calculate(int num1, int num2){
    return num1 + num2;
  }


}
