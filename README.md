# 🛒 Proyecto Final — E‑commerce API (Java + Spring Boot)

API RESTful desarrollada en **Java con Spring Boot** para la gestión de productos de un e‑commerce.  
Incluye operaciones **CRUD**, **búsqueda filtrada**, y **actualización parcial** mediante `PATCH`.

---

## 🚀 Tecnologías utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Maven
- Base de datos configurable (MySQL, H2, etc.)

> La configuración de la base de datos se realiza en  
> `src/main/resources/application.properties`.

---

## 📦 Modelo de datos

Entidad principal: **Producto**

| Campo      | Tipo   | Descripción                     |
|------------|--------|---------------------------------|
| `id`       | Long   | Identificador autogenerado      |
| `nombre`   | String | Nombre del producto             |
| `precio`   | double | Precio del producto             |
| `cantidad` | int    | Stock disponible                |

---

## ✅ Funcionalidades principales
- Crear productos  
- Listar todos los productos  
- Filtrar por:
  - `nombre` (coincidencia parcial)
  - `precio` (menor o igual)
- Editar un producto completo (`PUT`)
- Actualizar parcialmente (`PATCH`)
- Eliminar productos por ID

---

## 📡 Endpoints de la API

### ✅ **POST /products**
Crea un nuevo producto.

**Body ejemplo:**
```json
{
  "nombre": "Lapiz",
  "precio": 10.5,
  "cantidad": 20
}
```

---

### ✅ **GET /products**
Lista todos los productos o aplica filtros opcionales.

**Parámetros opcionales:**
- `nombre` → coincidencia parcial  
- `precio` → precio máximo

**Ejemplos:**
- `/products`
- `/products?nombre=Lap`
- `/products?precio=50`
- `/products?nombre=Lap&precio=50`

---

### ✅ **GET /products/{id}**
Obtiene un producto por su ID.

**Ejemplo:**
```
GET /products/1
```

---

### ✅ **PUT /products/{id}**
Reemplaza el producto completo.

**Body ejemplo:**
```json
{
  "id": 1,
  "nombre": "Lapiz Pro",
  "precio": 12.0,
  "cantidad": 15
}
```

---

### ✅ **PATCH /products/{id}**
Actualización parcial del producto.

**Body ejemplo:**
```json
{
  "precio": 8.5
}
```

---

### ✅ **DELETE /products/{id}**
Elimina un producto por su ID.

**Ejemplo:**
```
DELETE /products/1
```

---

## 🧪 Ejemplos listos para Postman

> URL base: `http://localhost:8080/products`

### Crear producto
```
POST /products
Content-Type: application/json
```
```json
{
  "nombre": "Lapiz",
  "precio": 10.5,
  "cantidad": 20
}
```

### Listar todos
```
GET /products
```

### Filtrar por nombre
```
GET /products?nombre=Lap
```

### Filtrar por precio
```
GET /products?precio=50
```

### Filtrar por ambos
```
GET /products?nombre=Lap&precio=50
```

### Actualizar completo (PUT)
```
PUT /products/1
```
```json
{
  "id": 1,
  "nombre": "Lapiz Pro",
  "precio": 12.0,
  "cantidad": 15
}
```

### Actualización parcial (PATCH)
```
PATCH /products/1
```
```json
{
  "precio": 8.5
}
```

### Eliminar producto
```
DELETE /products/1
```

---

## 🛠️ Build y ejecución

### Ejecutar con Maven
```bash
mvn clean package
java -jar target/<nombre-del-jar>.jar
```

### O ejecutar directamente
```bash
mvn spring-boot:run
```

---

## 📌 Notas importantes
- Configurar la base de datos en `application.properties` (URL, usuario, contraseña, dialecto).
- Validaciones mínimas implementadas (ej.: nombre no nulo/no vacío).
- Búsquedas implementadas con métodos de Spring Data JPA:
  - `findByNombreContaining`
  - `findByPrecioLessThanEqual`
  - `findByNombreContainingAndPrecioLessThanEqual`

---