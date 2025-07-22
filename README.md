# TallerPersistencia

## ✅ Funcionalidades principales

- Registrar una nueva mascota
- Listar todas las mascotas registradas
- Eliminar una mascota por nombre
- Actualizar los datos de una mascota existente

---

## 📦 Descripción de las Clases

### `Mascota.java` (model)

Modelo de entidad que representa a una mascota, con los siguientes atributos:
- `nombre` (String)
- `especie` (String)
- `edad` (int)

También incluye:
- `toLineaArchivo()` para convertir el objeto a una línea CSV.
- `desdeLineaArchivo()` para construir una mascota desde una línea del archivo.

---

### `MascotaDTO.java` (DTO)

Data Transfer Object para transferir datos entre capas. Contiene:
- `nombre`
- `especie`
- `edad`

No tiene lógica, solo getters.

---

### `MascotaDAO.java` (DAO)

Clase encargada de la lógica de acceso a datos (lectura/escritura del archivo `mascotas.txt`).

Métodos:
- `guardar(Mascota mascota)`
- `listar()`
- `eliminarPorNombre(String nombre)`
- `actualizar(String nombreClave, Mascota nueva)`

---

### `MascotaControlador.java` (Controlador)

Clase de lógica de negocio:
- Valida los datos antes de pasarlos al DAO.
- Coordina la creación, actualización, eliminación y listado de mascotas.

---

## 🗃 Archivo de almacenamiento

El archivo `data/mascotas.txt` guarda las mascotas en format


---

## ▶️ Cómo ejecutar

1. Asegúrate de tener Java instalado (JDK 8 o superior).
2. Abre el proyecto en NetBeans o tu IDE preferido.
3. Ejecuta la lógica desde una clase de prueba o crea una interfaz para usar el `MascotaControlador`.
4. Verifica que el archivo `data/mascotas.txt` exista o se cree automáticamente.

---

## 🛠 Requisitos

- Java JDK 8+
- IDE como NetBeans o IntelliJ
- Permisos para escribir/leer archivos locales

---

## ✍ Autor

**Pedro Luis Martínez**  
📧 pedroluismartinezs@hotmail.es

---

## 💡 Ideas futuras

- Interfaz gráfica con `Swing`
- Validaciones más robustas
- Búsqueda por especie o edad
- Estadísticas de mascotas registradas
