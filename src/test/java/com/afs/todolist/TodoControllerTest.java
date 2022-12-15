package com.afs.todolist;

import com.afs.todolist.entity.Todo;
import com.afs.todolist.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {
    @Autowired
    MockMvc client;

    @Autowired
    TodoRepository todoRepository;

    @BeforeEach
    void cleanRepository() {
        todoRepository.deleteAll();
    }
    @Test
    void should_get_all_todos_when_perform_get() throws Exception {

        todoRepository.save(new Todo("Test",false,"#ffffff"));
        todoRepository.save(new Todo("22",false,"#000000"));
        //when & then
        client.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].color").value("#ffffff"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].text").value("22"));

    }

    @Test
    void should_delete_item_by_id_when_perform_item_given_todo_id() throws Exception {

        Todo todo = todoRepository.save(new Todo("Test",false,"#ffffff"));

        //when & then
        client.perform(MockMvcRequestBuilders.delete("/todos/"+todo.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        assertEquals(todoRepository.findAll().size(), 0);
    }
    
}
