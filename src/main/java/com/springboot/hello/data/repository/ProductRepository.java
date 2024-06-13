package com.springboot.hello.data.repository;

import com.springboot.hello.data.entity.Product;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //find...By
    //특정 데이터를 찾아서 엔티티를 반환
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long Number);

    //exists...By
    //특정 데이터가 존재하는지 여부
    boolean existsByNumber(Long number);

    //count...By
    //레코드의 개수를 리턴
    long countByName(String name);

    //delete...By
    //삭제쿼리를 수행하거나 삭제한 횟수를 리턴
    void deleteByNumber(Long number);
    long removeByName(String name);

    //...First<number>... / ...Top<number>...
    //결괏값의 개수를 제한
    List<Product> findFirstByName(String name);
    List<Product> findTop10ByName(String name);

    //findByNumber 메서드와 동일하게 동작
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    //Not 키워드를 사용한 쿼리 메서드
    //해당 값과 불일치한 데이터를 조회
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);

    //Null 키워드를 사용한 쿼리 메서드
    //값이 null인지 검사하여 조회
//    List<Product> findByUpdatedAtNull();
//    List<Product> findByUpdatedIsNull();
//    List<Product> findByUpdatedNotNull();
//    List<Product> findByUpdatedAtIsNull();

    //True, False 키워드를 사용한 쿼리 메서드
    //boolean타입으로 지정된 컬럼값을 확인
//    Product findByActiveTrue();
//    Product findByActiveIsTrue();
//    Product findByActiveFalse();
//    Product findByActiveIsFalse();

    //And, Or 키워드를 사용한 쿼리 메서드
    //여러 조건의 쿼리를 묶을 때 사용
//    Product findByNumberAndName(Long number, String name);
//    Product findByNumberOrName(Long number, String name);
//
//    //GreaterThan, LessThan, Between 키워드를 사용한 쿼리메서드
//    //비교연산을 사용한 조건자 키워드
//    List<Product> findByPriceIsGreaterThan(Long price);
//    List<Product> findByPriceGreaterThan(Long price);
//    List<Product> findByPriceGreaterThanEqual(Long price);
//    List<Product> findByPriceIsLessThan(Long price);
//    List<Product> findByPriceLessThan(Long price);
//    List<Product> findByPriceLessThanEqual(Long price);
//    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
//    List<Product> findByPriceBetween(Long lowPrice, Long highPrice);
//
//    //부분 일치 키워드를 사용한 쿼리 메서드
//    //일부 일치 여부를 확인하는 조건자 키워드
//    List<Product> findByNameLike(String name);
//    List<Product> findByNameIsLike(String name);
//
//    List<Product> findByNameContains(String name);
//    List<Product> findByNameContaining(String name);
//    List<Product> findByNameIsContaining(String name);
//
//    List<Product> findByNameStartWith(String name);
//    List<Product> findByNameStartingWith(String name);
//    List<Product> findByNameIsStartingWith(String name);
//
//    List<Product> findByNameEndsWith(String name);
//    List<Product> findByNameEndingWith(String name);
//    List<Product> findByNameIsEndingWith(String name);
//
//    //쿼리 메서드의 정렬 처리
//    //ASC : 오름차순 / DESC : 내림차순
//    List<Product> findByNameOrderByNumberAsc(String name);
//    List<Product> findByNameOrderByNumberDesc(String name);
//
//    //쿼리 메서드에서 여러 정렬 기준 사용
//    //And를 붙이지 않음
//    List<Product> findByOrderByPriceAscStockDesc(String name) throws SqlScriptException;
//
//    //매개변수를 활용한 쿼리 정렬
//    List<Product> findByName(String name, Sort sort);
//
//    //페이징 처리를 위한 쿼리 메서드
//    Page<Product> findByName(String name, Pageable pageable);
//
//    //@Query 어노테이션을 사용하는 메서드
//    //?1은 첫번째 파라미터를 의미함
//    @Query("SELECT p FROM Product AS p WHERE p.name = ?1")
//    List<Product> findByName(String name);
//
//    //@Query 어노테이션과 @Param 어노테이션을 사용한 메서드
//    //:name은 Param의 값
//    @Query("SELECT p FROM Product p WHERE p.name = :name")
//    List<Product> findByNameParam(@Param("name") String name);
//
//    //특정 컬럼만 추출하는 쿼리
//    @Query("SELECT p.name, p.price, p.stock FROM Product p WHERE p.name = :name")
//    List<Object[]> findByNameParam2(@Param("name") String name);






}
