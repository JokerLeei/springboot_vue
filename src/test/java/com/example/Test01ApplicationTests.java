package com.example;

import com.example.model.Book;
import com.example.service.HelloService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01ApplicationTests {
    @Autowired
    HelloService helloService;

    // 注入 WebApplicationContext 来模拟 ServletContext 环境
    @Autowired
    WebApplicationContext wac;

    // 声明一个 MockMvc 对象
    MockMvc mockMvc;

    // 在每个测试方法前进行 MockMvc 的初始化操作
    @Before
    public void before(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

    // service 层直接测就完了
    @Test
    public void contextLoads() {
        String hello=helloService.sayHello("abc");
        System.out.println(hello);
    }

    // Controller 层 get 测试
    @Test
    public void test1() throws Exception{
        /*
            调用 MockMvc 中的 perform 方法开启一个 RequestBuilder 请求，体的请求则通过 MockMvcRequestBuilders 进行构建，调用
            MockMvcRequestBuilders 中的get方法表示发起一个GET请求，调用post方法表示一个POST请求，其他类似，param设置请求参数。
        */
        MvcResult mvcResult=mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/hello")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name","Michael"))
                // 添加返回值的验证规则，利用 MockMvcResultMatchers 进行验证。这里验证响应码是否为 200。
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 将请求详细信息答应到控制台
                .andDo(MockMvcResultHandlers.print())
                // 返回相应的 MvcResult
                .andReturn();
        // 打印出这个 MvcResult
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    // Controller 层 post 测试
    @Test
    public void test2() throws Exception{
        ObjectMapper om = new ObjectMapper();
        Book book = new Book();
        book.setId(1);
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        String s = om.writeValueAsString(book);
        MvcResult mvcResult=mockMvc
                .perform(MockMvcRequestBuilders
                        .post("book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}
