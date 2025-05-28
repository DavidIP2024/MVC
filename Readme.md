# Proyecto CocheMVC

Este proyecto implementa una pequeña aplicación de consola en Java que simula el funcionamiento de coches utilizando el patrón de diseño **MVC (Modelo-Vista-Controlador)**. Los coches pueden crearse, acelerar, frenar, avanzar y recibir gasolina.

---

## Estructura del Proyecto

- **Model.java**: Gestiona la lista de coches y la lógica de negocio (crear, buscar, cambiar velocidad).
- **Coche.java**: Representa un coche con matrícula, modelo, velocidad, gasolina y posición.
- **Controller.java**: Intermediario entre vista y modelo.
- **View.java**: Interfaz de consola (menú y entradas del usuario).
- **Avanzar.java**: Lógica de avance de un coche, calcula consumo y actualiza posición.
- **Gasolinera.java**: Permite añadir gasolina a un coche.

---

## Funcionalidades

1. **Crear coche**
2. **Aumentar velocidad** (incrementa 10 km/h)
3. **Disminuir velocidad** (reduce 10 km/h)
4. **Mostrar todos los coches**
5. **Avanzar coche**:
    - Introduces una distancia en metros.
    - Consumo:
      ```
      consumo = (metros / 1000) * (velocidad * 0.05)
      ```
    - Si hay suficiente gasolina: se resta del depósito y se avanza la posición.
    - Si no hay suficiente gasolina: se avisa.
6. **Poner gasolina**:
    - Introduces cuántos litros añadir.
    - Se suman al depósito del coche.
    - Se muestra el total actualizado.

---

## Ejemplo de uso

