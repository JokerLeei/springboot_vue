/*
package com.example.dao;

import com.example.model.Bok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

// 自定义请求路径
// path：原路径 localhost:8080/实体类名小写/ => localhost:8080/bs/
// collectionResourceRel：将返回得JSON集合中 book 集合的key修改为 bs
// itemResourceRel：将返回的JSON集合中的单个book的key修改为b
@RepositoryRestResource(path = "bs", collectionResourceRel = "bs", itemResourceRel = "b")
public interface BookRepository extends JpaRepository<Bok, Integer> {
    // 自定义查询方法
    // 不加 @RestResource 注解的path，则访问路径默认为方法名
    @RestResource(path = "author",rel = "author")
    List<Bok> findByAuthorContains(@Param("author") String author);

    @RestResource(path = "name",rel="name")
    Bok findByNameEquals(@Param("name")String name);
}
*/
