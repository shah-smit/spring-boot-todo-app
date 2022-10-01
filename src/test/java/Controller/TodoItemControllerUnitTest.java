package Controller;


import com.yourname.Controller.TodoItemController;
import com.yourname.Entity.TodoItem;
import com.yourname.Main;
import com.yourname.Repository.TodoItemRepository;
import com.yourname.Service.TodoItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
@WebMvcTest(controllers = { TodoItemController.class }, secure = false)
public class TodoItemControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoItemService todoItemService;

    @MockBean
    private TodoItemRepository todoItemRepository;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


    @Before
    public void setUp(){
        LocalDateTime localDateTime=LocalDateTime.MIN;
        TodoItem t = new TodoItem(1, "First Todo Item", localDateTime);
        List<TodoItem> todoItemList = new ArrayList<>();
        todoItemList.add(t);

        Mockito.when(todoItemService.getAllItems()).thenReturn(todoItemList);

        Mockito.when(todoItemRepository.findById(t.getId())).thenReturn(java.util.Optional.ofNullable(t));

        Mockito.when(todoItemRepository.save(Mockito.any(TodoItem.class))).thenReturn(t);

    }

    @Test
    public void findAllTodoItems() throws Exception {
        ResultActions actions = mockMvc.perform(get("/todoitems"));

        actions.andExpect(status().isOk()).andExpect(content().contentType(contentType));

    }

}

