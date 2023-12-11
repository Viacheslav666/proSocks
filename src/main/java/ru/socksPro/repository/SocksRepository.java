package ru.socksPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.socksPro.pojo.Socks;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Long> {

    Socks findByColorAndCottonPart(String color, Long cottonPart);
    @Query("select quantity" +
            " from Socks" +
            " where color = :color" +
            " and cottonPart = :cottonPart")
    Long getQuantityByColorAndCottonPartEqualsThen(@Param("color") String color, @Param("cottonPart") Long cottonPart);
    @Query("select sum(quantity)" +
            " from Socks" +
            " where color = :color " +
            "and cottonPart > :cottonPart")
    Long getQuantityByColorAndCottonPartMoreThen(@Param("color") String color, @Param("cottonPart") Long cottonPart);
    @Query("select sum(quantity)" +
            " from Socks" +
            " where color = :color " +
            "and cottonPart < :cottonPart")
    Long getByQuantityByColorAndCottonPartLessThen(@Param("color") String color, @Param("cottonPart") Long cottonPart);
}
