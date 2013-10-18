package ninoshunt.spring.freemarker.sample.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/servlet-context.xml" })
public class FreeMarkerSampleControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void index表示を日本語でおｋ() throws Exception {
        mockMvc.perform(get("/").locale(new Locale("ja_JP")))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(model().hasNoErrors())
            .andExpect(content().string(containsString("Spring Freemarkerのサンプルです。")));
    }

    @Test
    public void index表示を英語でおｋ() throws Exception {
        mockMvc.perform(get("/").locale(new Locale("en_US")))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(model().hasNoErrors())
            .andExpect(content().string(containsString("Spring Freemarker Sample!")));
    }

}
