package com.techlab.demo.repository;

import com.techlab.demo.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

  // TODO: query methods: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

  /**
   * Devuelve productos cuyo nombre contiene la cadena dada (equivalente a LIKE %nombre%).
   * Uso: llamado por ProductService.listarProductos cuando se filtra por nombre.
   *
   * @param nombre texto parcial a buscar en el nombre
   * @return lista de productos que contienen el texto en su nombre
   */
  List<Producto> findByNombreContaining(String nombre);

  /**
   * Devuelve productos con precio menor o igual al valor proporcionado.
   * Uso: llamado por ProductService.listarProductos cuando se filtra por precio.
   *
   * @param precio precio máximo permitido
   * @return lista de productos con precio <= precio
   */
  List<Producto> findByPrecioLessThanEqual(Double precio);

  /**
   * Combina filtros: nombre contiene y precio <= valor dado.
   * Uso: llamado por ProductService.listarProductos cuando se proporcionan ambos filtros.
   *
   * @param nombre texto parcial a buscar en el nombre
   * @param precio precio máximo permitido
   * @return lista de productos que cumplen ambos criterios
   */
  List<Producto> findByNombreContainingAndPrecioLessThanEqual(String nombre, Double precio);
}
