<h1 align=center>Задание</h1>

<h3 align=center>На работу с фреймворком Junit</h3>

Создайте приложение как Maven проект, в который:
<ul>
  <li>добавьте Junit зависимость в файл pom.xml;</li>
  <li>добавьте класс, использующийся для конвертации значения температуры в
различные единицы измерения (Цельсий, Кельвин, Фаренгейт)</li>

  <li>добавьте класс с junit-тестами для проверки всех методов описанного
класса и запустите их для проверки;</li>
  <li>добавьте возможность параметризированного запуска тестов.</li>
</ul>

``` java
public class TemperatureConverter {
  public double convertFtoC(double degreesFahrenheit) {
    return (degreesFahrenheit - 32.0) / 9.0 * 5.0;
  }
  
  public double convertCtoF(double degreesCelsius) {
    return degreesCelsius / 5.0 * 9.0 + 32.0;
  }

  public double convertCtoK(double degreesCelsius) {
    return degreesCelsius + 273.2;
  }

  public double convertKtoC(double kelvin) {
    return kelvin - 273.2;
  }

  public double convertFtoK(double degreesFahrenheit) {
    return (degreesFahrenheit + 459.7) / 9.0 * 5.0;
  }

  public double convertKtoF(double kelvin) {
    return kelvin / 5.0 * 9.0 - 459.7;
  }
}
```

<pre>ТРЕБОВАНИЯ.
  1. Приложение должно быть написано на языке Java.
  2. При кодировании должны быть использованы соглашения об
оформлении кода для языка Java.
  3. Для реализации модульного тестирования используйте фреймворк
JUnit 4.</pre>
