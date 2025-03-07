# Casos de uso de la aplicación

## Identificador: Inicio de curso
**Actor(es):**  
- Usuario  
- Sistema  

**Objetivo:**  
Iniciar el curso (por primera vez) en el que el usuario adquirirá nuevos conocimientos sobre alguna materia.  

**Precondiciones:**  
- El curso existe y está integrado en el sistema.  

**Pasos:**  
1. El usuario accede a la aplicación y a la ventana de selección de cursos.  
2. El usuario selecciona el curso que quiere realizar y la estrategia de aprendizaje.  
3. El sistema carga el archivo JSON con la información del curso y usa su contenido para comenzar.  

**Cuestiones:**  
- ¿Qué pasa si se produce un error a la hora de leer el archivo del curso?  

**Alternativas:**  
- **3.a**: Se produce un error al leer el archivo JSON → Se muestra un mensaje de error en la aplicación y el usuario regresa a la ventana de selección de curso.  

---

## Identificador: Pausa en el curso
**Actor(es):**  
- Usuario  
- Sistema  

**Objetivo:**  
El usuario debe poder cambiar de curso o cerrar la aplicación sin perder su progreso.  

**Pasos:**  
1. El usuario está en medio de un curso y selecciona la opción de salir.  
2. El sistema crea un archivo de persistencia con las estadísticas y progreso actuales (podría ser una sección en el archivo JSON).  
3. La próxima vez que se seleccione el curso, el sistema revisará este archivo y restaurará el estado anterior.  

**Cuestiones:**  
- ¿Qué pasa si se produce un error al leer el archivo de persistencia?  
- ¿Qué pasa si la aplicación se cierra de forma imprevista?  

**Alternativas:**  
- **3.a**: Se produce un error al leer el archivo de persistencia → Se muestra un mensaje de error en la aplicación y el usuario tendrá que empezar desde el principio.  
- **1.a**: La aplicación se cierra sin que el sistema haya guardado → Para minimizar pérdidas, se realiza un guardado automático del progreso cada cierto tiempo.  

---

## Identificador: Guardado de estadísticas
**Actor(es):**  
- Usuario  
- Sistema  

**Objetivo:**  
El usuario debe poder conservar sus estadísticas de uso de la aplicación, como tiempo de uso o mejores rachas.  

**Pasos:**  
1. El usuario usa la aplicación.  
2. El sistema actualiza constantemente un archivo de persistencia con las estadísticas.  
3. La próxima vez que se abra la aplicación, el sistema revisará este archivo y restaurará el estado anterior.  

**Cuestiones:**  
- ¿Qué pasa si se produce un error al leer el archivo de persistencia?  

**Alternativas:**  
- **3.a**: Se produce un error al leer el archivo de persistencia → Se muestra un mensaje de error en la aplicación y el usuario tendrá que empezar desde el principio.  

---

## Identificador: Sistema de logros
**Actor(es):**  
- Usuario  
- Sistema  

**Objetivo:**  
El usuario obtendrá logros (o medallas) cuando logre realizar ciertas hazañas (Ej: racha de más de 20 días).  

**Pasos:**  
1. El usuario realiza una hazaña.  
2. El sistema lo reconoce y muestra un mensaje de celebración.  
3. El sistema añade el logro a la colección del usuario.  
4. El sistema actualiza el archivo de persistencia.  

---

## Identificador: Compartir cursos
**Actor(es):**  
- Usuario  

**Objetivo:**  
El usuario podrá compartir un curso creado con otros usuarios.  

**Precondiciones:**  
- El curso ha sido creado previamente.  

**Pasos:**  
1. El usuario accede a la carpeta donde tiene almacenados los cursos.  
2. Envía a otro usuario el archivo JSON correspondiente al curso que desea compartir.  
3. El otro usuario lo recibe y lo coloca en su carpeta.  


## Diagrama de Clases UML

```mermaid
classDiagram
    class Usuario {
        - String nombre
        - String email
        - String contraseña
        + registrarse()
        + iniciarSesion()
        + iniciarCurso(Curso curso)
        + guardarProgreso(Curso curso)
        + guardarEstadisticas(Estadisticas estadisticas)
    }

    class EstrategiaAprendizaje {
    }

    class Secuencial {
    }
    class RepeticionEspaciada {
    }
    class Aleatoria {
    }

    class Curso {
        - String nombre
        - String dominio
        + responderPreguntas(BloqueContenido bloque, EstrategiaAprendizaje estrategia)
    }

    class BloqueContenido {
        - String titulo
    }

    class Pregunta {
        - String enunciado
    }

    class PreguntaTest {
        - List<String> opciones
        + validarRespuesta(String respuesta)
    }

    class Completar {
        - String respuestaCorrecta
        + validarRespuesta(String respuesta)
    }

    class Flashcard {
        - String informacion
        + mostrar()
    }

    class Estadisticas {
        - int tiempoUso
        - int mejorRacha
        + actualizarEstadisticas()
        + conseguirLogro()
        - array logrosConseguidos
    }

    Usuario "1" -- "*" Curso : realiza
    Curso "1" -- "*" BloqueContenido : contiene
    BloqueContenido "1" -- "*" Pregunta : tiene
    Pregunta <|-- PreguntaTest
    Pregunta <|-- Completar
    Pregunta <|-- Flashcard
    EstrategiaAprendizaje <|-- Secuencial
    EstrategiaAprendizaje <|-- RepeticionEspaciada
    EstrategiaAprendizaje <|-- Aleatoria
    Usuario "1" -- "1" Estadisticas : tiene
    Curso "*" -- "1" EstrategiaAprendizaje : aplica
