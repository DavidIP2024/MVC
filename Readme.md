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

## Aplicación de coches con alarma de gasolina baja usando patrón Observer

Esta aplicación gestiona coches con funcionalidades como crear coches, cambiar velocidad, avanzar y repostar gasolina.

Para cumplir con el requisito de mostrar una alarma cuando la gasolina baja de 10 litros, se ha aplicado el patrón **Observer** exclusivamente al atributo gasolina.

### Implementación del patrón Observer

1. **Sujeto (Observable):**  
   La clase `Coche` actúa como sujeto. Mantiene una lista de observadores interesados en el estado de la gasolina.

2. **Observadores:**  
   Se creó una interfaz `Observer` con el método `update(String mensaje)`.  
   La clase `AlarmaGasolina` implementa esta interfaz y muestra un mensaje de alerta cuando es notificada.

3. **Notificación:**  
   Cuando se cambia la gasolina con el método `setGasolina`, se comprueba si el nivel de gasolina está por debajo de 10 litros.  
   Si es así, se llama a todos los observadores para que reaccionen.

4. **Registro y gestión de observadores:**  
   En `Coche` existen métodos para añadir (`addGasolinaObserver`) y eliminar (`removeGasolinaObserver`) observadores.  
   Esto permite que la alarma se registre al coche que se quiere vigilar.

5. **Desacoplamiento:**  
   La alarma está separada de la lógica interna del coche. El coche solo notifica cambios, y el observador decide qué hacer con la alerta.  
   Esto facilita modificar o añadir más observadores en el futuro sin cambiar la clase `Coche`.

### Uso en la aplicación

- Los métodos que modifican la gasolina (`Avanzar.avanzar` y `Gasolinera.ponerGasolina`) usan el setter `setGasolina` para actualizar la gasolina y disparar la alarma cuando corresponde.
- Así, cuando la gasolina baja de 10 litros, automáticamente aparece el mensaje **"Alerta: Repostar"**.

### Resumen

Esta implementación del patrón Observer permite detectar fácilmente cuando la gasolina está baja y avisar con una alarma, cumpliendo el requisito del examen y respetando la separación de responsabilidades.

### Mermaid
sequenceDiagram
participant Usuario
participant Controller
participant Model
participant Coche
participant AlarmaGasolina
participant Avanzar
participant Gasolinera

Usuario->>Controller: crearCoche(matricula, modelo)
Controller->>Model: crearCoche(matricula, modelo)
Model-->>Controller: coche creado

Usuario->>Controller: registrarAlarma(matricula)
Controller->>Model: getCoche(matricula)
Model-->>Controller: coche
Controller->>Coche: addGasolinaObserver(AlarmaGasolina)

Usuario->>Controller: aumentarVelocidad(matricula)
Controller->>Model: cambiarVelocidad(matricula, +10)
Model-->>Controller: velocidad actualizada

Usuario->>Avanzar: avanzar(coche, metros)
Avanzar->>Coche: getVelocidad()
Avanzar->>Coche: getGasolina()
Avanzar->>Coche: setGasolina(nuevaGasolina)
Avanzar->>Coche: setPosicion(nuevaPosicion)
    
alt gasolina < 10 litros
Coche->>AlarmaGasolina: update("Repostar")
AlarmaGasolina-->>Usuario: mostrar alerta
end

Usuario->>Gasolinera: ponerGasolina(coche, litros)
Gasolinera->>Coche: setGasolina(gasolina + litros)


