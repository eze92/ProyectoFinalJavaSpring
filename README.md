🛒 Proyecto Final — E‑commerce API (Java + Spring Boot)
API RESTful desarrollada en Java con Spring Boot para la gestión de productos de un e‑commerce.
Incluye operaciones CRUD completas, búsqueda filtrada, y actualización parcial mediante PATCH.

🚀 Tecnologías utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Maven
- Base de datos configurable (MySQL, H2, etc.)
La configuración de la base de datos se realiza en
src/main/resources/application.properties.

📦 Modelo de datos
Entidad principal: Producto
|  |  |  | 
| id |  |  | 
| nombre |  |  | 
| precio |  |  | 
| cantidad |  |  | 



✅ Funcionalidades principales
- Crear productos
- Listar todos los productos
- Filtrar por:
- nombre (coincidencia parcial)
- precio (menor o igual)
- Editar un producto completo (PUT)
- Actualizar parcialmente (PATCH)
- Eliminar productos por ID


📡 Endpoints de la API
POST /products
Crea un nuevo producto.
Body ejemplo:


{
  "nombre": "Lapiz",
  "precio": 10.5,
  "cantidad": 20
}

GET /products
Lista todos los productos o aplica filtros opcionales

Ejemplos:
- /products — todos
- /products?nombre=Lap
- /products?precio=50
- /products?nombre=Lap&precio=50

PUT /products/{id}
Reemplaza el producto completo.
(En la implementación actual solo modifica el nombre.

{
  "id": 1,
  "nombre": "Lapiz Pro",
  "precio": 12.0,
  "cantidad": 15
}

PATCH /products/{id}
Actualización parcial.
Se puede enviar cualquier combinación de campos:

{
  "precio": 8.5
}

DELETE /products/{id}
Elimina un producto por su ID.

🛠️ Build y ejecución
Ejecutar con Maven

mvn clean package
java -jar target/<nombre-del-jar>.jar

O ejecutar directamente
mvn spring-boot:run

 Notas importantes
- Configurar la base de datos en application.properties (URL, usuario, contraseña, dialecto).
- Validaciones mínimas implementadas (ej.: nombre no nulo/no vacío).
- Búsquedas implementadas con métodos de Spring Data JPA:
- findByNombreContaining
- findByPrecioLessThanEqual
- findByNombreContainingAndPrecioLessThanEqual









