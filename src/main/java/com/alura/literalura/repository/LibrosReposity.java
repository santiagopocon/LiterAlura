package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Idioma;
import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosReposity extends JpaRepository<Libro, Long> {

    List<Libro> findByIdiomas(Idioma idioma);

    List<Libro> findTop5ByOrderByNumeroDeDescargasDesc();
    @Query("SELECT l FROM Libro a JOIN a.autor l")
    List<Autor> mostrarAutores();

    @Query("SELECT l FROM Libro a JOIN a.autor l WHERE l.fechaDeNacimiento <= :anio AND l.fechadeMuerte >= :anio")
    List<Autor> mostrarAutoresVivos(String anio);


//    @Query("SELECT l FROM Libo a JOIN a.autor l WHERE a.nombre = :autor")
//    List<Libro> librosPorAutor(String autor);

}
