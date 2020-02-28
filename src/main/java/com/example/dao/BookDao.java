/*
package com.example.dao;

import com.example.model.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
// @CacheConfig 指明使用缓存的名字，这个配置可选，若不使用则在 @Cacheable 指明缓存名字
@CacheConfig(cacheNames = "book_cache")
public class BookDao {
    // @Cacheable 表示对该方法进行缓存，默认情况下缓存key是方法的参数，value是返回值
    // 当开发者在其他类中调用该方法时，首先会根据调用参数查看缓存中是否有相关数据，
    // 若有则返回缓存数据，没有则调用这个方法执行成功后将返回值缓存起来，但若是在当前类
    // 中调用这个方法，则缓存不生效
    // @Cacheable 有个属性 condition 用来描述缓存的执行时机，例如 condition = "#id%2==0"
    @Cacheable(value = "c1")
    public String getBookById(Integer id){
        System.out.println("getBookById");
        */
/*Book book = new Book();
        book.setId(id);
        book.setName("三国演义");
        book.setAuthor("罗贯中");*//*

        return "这本书是三国演义！";
    }

    // 自定义缓存的key，不使用默认的方法名作key
    // 属性名字          属性描述                用法示例
    // methodName       当前方法名              #root.methodName
    // method           当前方法对象            #root.method.name
    // caches           当前方法使用的缓存       #root.cache[0].name
    // target           当前被调用的对象         #root.target
    // targetClass      当前被调用的对象的class  #root.targetClass
    // args             当前方法参数数组         #root.args[0]

    // 如果这些key还是不满足，则自定义个key生成器类，这个类实现 KeyGenerator 接口
    // @CachePut(value = "c1", key = "#book.id")

    // c1存在于configMap集合中，使用的缓存策略是configMap集合中c1所对应的缓存策略
    // c2不存在于configMap集合中，因此使用的缓存策略是默认的缓存策略
    @CachePut(value = "c1")
    public String  updateBookById(Integer id){
        */
/*System.out.println("updateBookById");
        book.setName("三国演义 2");
        return book;*//*

        return "这是全新的三国演义！";
    }

    @CacheEvict(value = "c1")
    public void deleteBookById(Integer id){
        System.out.println("deleteBookById");
    }

    @Cacheable(value = "c2")
    public String getBookById2(Integer id){
        System.out.println("getBookById2");
        return "这本书是红楼梦";
    }
}
*/
