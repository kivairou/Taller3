# Taller 03 – Juego de Simulación de Magia

## Descripción del Proyecto

Este proyecto corresponde al **Taller 3** del curso de **Programación Orientada a Objetos (POO)**. 
El objetivo es desarrollar un software interactivo de gestión de magia en **Java** utilizando los principios de la Programación Orientada a Objetos y una arquitectura limpia en capas. El sistema permite administrar un gremio de magos, un repertorio global de hechizos elementales de distintas clases (Fuego, Tierra, Planta y Agua), y realizar análisis de rendimiento mediante rankings y puntuaciones dinámicas.

El sistema implementa persistencia de datos mediante lectura y escritura de archivos planos de texto, y utiliza el patrón de diseño **Singleton** para el motor principal de la lógica, garantizando una única fuente de verdad y una gestión centralizada de las estructuras en memoria RAM:
* **Hechizos.txt**: Base de datos que almacena los atributos, tipos y propiedades específicas de cada hechizo global.
* **Magos.txt**: Archivo de persistencia que registra a los magos del gremio y las relaciones indexadas con los hechizos que dominan.

---

## Integrantes

- Kevin Zamora Riquelme – RUT: 21.578.521-1 – Usuario GitHub: kivairou 
- Tomás Zepeda Velasquez - RUT: 21.789.061-6 - Usuario GitHub: tomaszepeda2411

---

## Estructura del Proyecto

La arquitectura se encuentra desacoplada en tres capas principales (Lógica y Dominio), facilitando la mantenibilidad y la cohesión del software:

```text
├── taller3/
│   ├
│   ├── dominio/                # Capa de Dominio (Modelos de datos y Polimorfismo)
│   │   ├── Hechizo.java        # Clase abstracta base para la herencia elemental
│   │   ├── HechizoFuego.java   # Subclase con propiedades de quemadura y cálculo especializado
│   │   ├── HechizoTierra.java  # Subclase con propiedades de mitigación/defensa
│   │   ├── HechizoPlanta.java  # Subclase con propiedades de control de masas (Stun)
│   │   ├── HechizoAgua.java    # Subclase con propiedades de restauración (Heal)
│   │   └── Mago.java           # Clase de entidad que representa al hechicero y muta sus atributos
│   │
│   └── logica/                 # Capa de Negocio (Reglas, procesamiento y persistencia)
│       ├── Sistema.java        # Interfaz / Contrato de abstracción de las operaciones
│       ├── SistemaImpl.java    # Motor principal del juego implementado con el patrón SINGLETON
│       └── App.java            # Gestión de menús divididos (Administrador y Analista) y control de excepciones
│                 
├── Hechizos.txt                # Archivo de persistencia para el repertorio de hechizos
└── Magos.txt                   # Archivo de persistencia para los magos y sus relaciones
```

---
## Instrucciones de Ejecución
### En Visual Studio Code
1. Abre VS Code y selecciona **File > Open Folder**.  
   Elige la carpeta raíz del proyecto (donde está `src/`).
2. Instala la extensión **Java Extension Pack** si no la tienes.
3. Abre el archivo `App.java` dentro de `src/`.
4. Haz clic en el botón **Run** que aparece arriba del método `main`.
5. El programa se ejecutará en la terminal integrada de VS Code.

### En Eclipse
1. Abre Eclipse y selecciona **File > New > Java Project**.
2. Asigna un nombre al proyecto (ejemplo: `Taller03`).
3. Copia la carpeta `src/` y los archivos dentro del proyecto.
4. Asegúrate de que `App.java` esté dentro del paquete `src`.
5. Haz clic derecho sobre `App.java` → **Run As > Java Application**.
6. El programa se ejecutará en la consola de Eclipse.
