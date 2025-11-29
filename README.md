# Proyecto Final Ecommerse Java con Spring Boot

# Demo Productos

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

## Ejemplos (curl)
- Crear:

curl -X POST -H "Content-Type: application/json" -d '{"nombre":"Lapiz","precio":10.5,"cantidad":20}' http://localhost:8080/products

- Listar con filtro:

curl "http://localhost:8080/products?nombre=Lap&precio=50"

- Borrar:

curl -X DELETE http://localhost:8080/products/1

## Build y ejecución
- Compilar y ejecutar con Maven:

mvn clean package java -jar target/<nombre-del-jar>.jar

mvn spring-boot:run

## Notas
- Configurar la conexión a la base de datos en `src/main/resources/application.properties` (URL, usuario, contraseña, dialecto).
- Validaciones mínimas en el servicio (p. ej. nombre no nulo/no en blanco para editar).
- Los métodos de búsqueda usan los métodos de Spring Data JPA: `findByNombreContaining`, `findByPrecioLessThanEqual`, `findByNombreContainingAndPrecioLessThanEqual`.

