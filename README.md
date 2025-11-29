# Proyecto Final Ecommerse Java con Spring Boot

Aplicación RESTful en Java (Spring Boot + Spring Data JPA) para gestionar productos. Provee operaciones CRUD y búsqueda por nombre y/o precio.

## Tecnologías
- Java
- Spring Boot
- Spring Data JPA
- Maven
- (Configurar base de datos en `src/main/resources/application.properties` o usar una base en memoria para desarrollo)

## Modelo principal
Entidad `Producto` con campos:
- `id` (Long, generado)
- `nombre` (String)
- `precio` (double)
- `cantidad` (int)

## Qué hace
- Crear, listar, editar, eliminar y actualizar parcialmente productos.
- Filtrado de lista por `nombre` (contiene) y/o `precio` (<=).
- Actualización parcial mediante `PATCH` aceptando `nombre`, `cantidad` y/o `precio`.

## Endpoints
- `POST /products`  
  Crea un producto. Body JSON: `{ "nombre": "Lapiz", "precio": 10.5, "cantidad": 20 }`

- `GET /products`  
  Lista productos. Query params opcionales: `nombre` (texto parcial), `precio` (valor máximo).  
  Ejemplos:
  - `/products` — todos
  - `/products?nombre=Lap` — nombre contiene "Lap"
  - `/products?precio=50` — precio <= 50
  - `/products?nombre=Lap&precio=50` — ambos filtros

- `PUT /products/{id}`  
  Edita el producto completo (en el código actual solo modifica el `nombre`). Body JSON con campos del producto.

- `PATCH /products/{id}`  
  Actualización parcial. Body JSON con cualquier combinación de:  
  `{ "nombre": "Nuevo", "cantidad": 5, "precio": 12.99 }`

- `DELETE /products/{id}`  
  Elimina el producto por id.

## A continuación ejemplos directos para importar/ejecutar en Postman (usar tipo de body = raw - JSON). URL base: http://localhost:8080/products

# Crear producto (POST)
POST http://localhost:8080/products
Content-Type: application/json

{
  "nombre": "Lapiz",
  "precio": 10.5,
  "cantidad": 20
}

# Listar todos (GET)
GET http://localhost:8080/products
Accept: application/json

# Listar filtrando por nombre (GET)
GET http://localhost:8080/products?nombre=Lap
Accept: application/json

# Listar filtrando por precio (GET)
GET http://localhost:8080/products?precio=50
Accept: application/json

# Listar por ambos filtros (GET)
GET http://localhost:8080/products?nombre=Lap&precio=50
Accept: application/json

# Actualizar completo (PUT) - reemplazo (en el código actual solo modifica nombre)
PUT http://localhost:8080/products/1
Content-Type: application/json

{
  "id": 1,
  "nombre": "Lapiz Pro",
  "precio": 12.0,
  "cantidad": 15
}

# Actualización parcial (PATCH) - body con los campos a cambiar
PATCH http://localhost:8080/products/1
Content-Type: application/json

{
  "precio": 8.5
}

# Borrar producto (DELETE)
DELETE http://localhost:8080/products/1
Accept: application/json



## Build y ejecución
- Compilar y ejecutar con Maven:

mvn clean package java -jar target/<nombre-del-jar>.jar

mvn spring-boot:run

## Notas
- Configurar la conexión a la base de datos en `src/main/resources/application.properties` (URL, usuario, contraseña, dialecto).
- Validaciones mínimas en el servicio (p. ej. nombre no nulo/no en blanco para editar).
- Los métodos de búsqueda usan los métodos de Spring Data JPA: `findByNombreContaining`, `findByPrecioLessThanEqual`, `findByNombreContainingAndPrecioLessThanEqual`.

