# Casos de uso de la aplicación

## Identificador: Inicio de curso
**Actor(es):**  
- Persona que quiere realizar un curso  

**Objetivo:**  
Iniciar el curso (por primera vez) en el que el usuario adquirirá nuevos conocimientos sobre alguna materia.  

**Pasos:**  
1. El usuario accede a la aplicación y a la ventana de selección de cursos.  
2. El usuario selecciona el curso que quiere realizar y la estrategia de aprendizaje.  
3. El sistema carga el archivo de curso con la información del curso y usa su contenido para comenzar.  

**Cuestiones:**  
- ¿Qué pasa si se produce un error a la hora de leer el archivo del curso?  

**Alternativas:**  
- **3.a**: Se produce un error al leer el archivo de curso → Se muestra un mensaje de error en la aplicación y el usuario regresa a la ventana de selección de curso.  

---

## Caso de Uso: Realización del curso

**Actores:**
-Persona que está realizando un curso

**Objetivo:**
-Permitir que el usuario realize el curso hasta el final, incluso haciendo pausas de por medio.

**Precondiciones**
- El usuario está inscrito en el curso.

**Pasos**
1. El usuario selecciona un curso.
2. El sistema muestra las lecciones disponibles.
3. El usuario elige una lección.
4. El sistema presenta los ejercicios.
5. El usuario responde.
6. El sistema verifica y muestra datos de análisis.
7. Si el usuario completa la lección, el sistema registra el progreso de forma persistente.
8. Si el usuario falla, el sistema permite repetir ejercicios.
9. Al finalizar, el sistema muestra el progreso actual del curso.

---

## Identificador: Reaudación del curso
**Actor(es):**  
- Persona que quiere reanudar un curso que antes ha sido pausado.
- 
**Objetivo:**  
El usuario debe poder reanudar el curso que antes ha dejado a medias.  

**Pasos:**  
1. El usuario accede a la aplicación y a la ventana de selección de cursos.  
2. El usuario selecciona el curso que quiere realizar.
3. El sistema reconoce que se tienen "datos de guardado".
4. Se usan estos datos para dejar el curso en el estado en el que estuvo por última vez.   

**Cuestiones:**  
- ¿Qué pasa si se produce un error al leer el archivo de persistencia?  

**Alternativas:**  
- **3.a**: Se produce un error al leer el archivo de persistencia → Se muestra un mensaje de error en la aplicación y el usuario tendrá que empezar desde el principio.  

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
        + iniciarCurso(Cursorealizado curso)
        + guardarProgreso(CursoRealizado curso)
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
    }

    class cursoRealizado {
        - ProgresoCurso progreso
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
        - logrosConseguidos
        + actualizarEstadisticas()
        + conseguirLogro()
    }

    Usuario "1" -- "*" cursoRealizado : realiza
    cursoRealizado "1" -- "*" BloqueContenido : contiene
    BloqueContenido "1" -- "*" Pregunta : tiene
    Pregunta <|-- PreguntaTest
    Pregunta <|-- Completar
    Pregunta <|-- Flashcard
    EstrategiaAprendizaje <|-- Secuencial
    EstrategiaAprendizaje <|-- RepeticionEspaciada
    EstrategiaAprendizaje <|-- Aleatoria
    Usuario "1" -- "1" Estadisticas : tiene
    cursoRealizado "*" -- "1" EstrategiaAprendizaje : aplica

    Curso <|-- cursoRealizado

