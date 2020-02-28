package com.example.controller;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    /**
     * 跨域资源共享 CORS (配置跨域)
     *  方法 1(细粒度，配置在某个接口上)
     *  方法 2(全局配置，见config/MyWebMvcConfig.java)
     *
     * @CrossOrigin 注解：
     * value：支持的域(这里表示来自 http://localhost:8081 域的请求是支持跨域的)
     * maxAge 表示探测请求的有效期(除了GET的请求以及自定义请求头时会先发送探测请求，
     *      探测请求不会每次都发，会有个有效期，过期再发送)
     * allowedHeaders 表示允许的请求头，*表示所有请求头都被允许
     */
    /*@PostMapping("/")
    @CrossOrigin(value = "http://localhost:8081",
            maxAge = 1800, allowedHeaders = "*")
    public String addBook(String name) {
        return "receive:" + name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081",
            maxAge = 1800, allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }*/


    /*@Autowired
    BookService bookService;

    @GetMapping("/bookOps")
    public void bookOps() {
        Book b1 = new Book();
        b1.setName("西厢记");
        b1.setAuthor("王实甫");
        int add = bookService.addBook(b1);
        System.out.println("addBook>>>" + add);

        Book b2 = new Book();
        b2.setId(1);
        b2.setName("朝花夕拾");
        b2.setAuthor("鲁迅");
        int update = bookService.updateBook(b2);
        System.out.println("updateBook>>>" + update);

        Book b3 = bookService.getBookById(1);
        System.out.println("getBookById>>>" + b3);

        int delete = bookService.deleteBookById(2);
        System.out.println("deleteBookById>>>" + delete);

        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("getAllBooks>>>" + allBooks);
    }*/

    /*@Resource(name = "jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    @GetMapping("/test1")
    public void test1() {
        List<Book> books1 = jdbcTemplateOne.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
        List<Book> books2 = jdbcTemplateTwo.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
        System.out.println("books1:" + books1);
        System.out.println("books2:" + books2);
    }*/

    /*@Autowired
    BookMapper bookMapper;
    @Autowired
    BookMapper2 bookMapper2;

    @GetMapping("/test1")
    public void test1() {
        List<Book> books1 = bookMapper.getAllBooks();
        List<Book> books2 = bookMapper2.getAllBooks();
        System.out.println("books1:" + books1);
        System.out.println("books2:" + books2);
    }*/

    // RedisTemplate，可以操作对象
    // 序列化方案：JdkSerializationRedisSerializer
    /*@Autowired
    RedisTemplate redisTemplate;
    // StringRedisTemplate 是 RedisTemplate 的子类，其 key、value 都是String
    // 序列化方案：StringRedisSerializer
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")
    public void test1() {
        // StringRedisTemplate和RedisTemplate都是通过opsForValue、opsForZSet等先获取一个操作对象
        // 再使用该操作对象完成数据的读写。
        *//*ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name", "ABCD");
        String name = ops1.get("name");
        System.out.println(name);
        ValueOperations ops2 = redisTemplate.opsForValue();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("红楼梦");
        b1.setAuthor("曹雪芹");
        ops2.set("b1", b1);
        Book book = (Book) ops2.get("b1");
        System.out.println(book);*//*

        // redis集群测试
        ValueOperations ops=redisTemplate.opsForValue();
        Book book = new Book();
        book.setName("水浒传");
        book.setAuthor("施耐庵");
        ops.set("b1",book);
        System.out.println(ops.get("b1"));
        ValueOperations<String,String> ops2=stringRedisTemplate.opsForValue();
        ops2.set("k1","v1");
        System.out.println(ops2.get("k1"));
    }*/

    /*@Autowired
    BookDao bookDao;

    @GetMapping("/test1")
    public void test1(){
        List<Book> books=new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("朝花夕拾");
        b1.setAuthor("鲁迅");
        books.add(b1);
        Book b2 = new Book();
        b2.setId(2);
        b2.setName("呐喊");
        b2.setAuthor("鲁迅");
        books.add(b2);

        bookDao.insert(books);
        List<Book> books1 = bookDao.findByAuthorContains("鲁迅");
        System.out.println(books1);

        Book book = bookDao.findByNameEquals("朝花夕拾");
        System.out.println(book);
    }*/
}
