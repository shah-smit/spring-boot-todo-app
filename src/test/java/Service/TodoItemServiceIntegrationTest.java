package Service;

import com.yourname.Entity.TodoItem;
import com.yourname.Repository.TodoItemRepository;
import com.yourname.Service.TodoItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class TodoItemServiceIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public TodoItemService todoItemService() {
            return new TodoItemService();
        }
    }

    @Autowired
    private TodoItemService todoItemService;

    @MockBean
    private TodoItemRepository todoItemRepository;

    @Before
    public void setUp(){
        TodoItem t = new TodoItem(1, "Test Item 1");

        Mockito.when(todoItemRepository.findById(t.getId())).thenReturn(java.util.Optional.ofNullable(t));
    }

    @Test
    public void nonEmptyItemName_ReturnsTrue(){
        final boolean returnedValue = todoItemService.isItemNameValid("NonEmpty");
        assertThat(returnedValue).isEqualTo(true);
    }

    @Test
    public void emptyItemName_ReturnsFalse(){
        final boolean returnedValue = todoItemService.isItemNameValid("");
        assertThat(returnedValue).isEqualTo(false);
    }

    @Test
    public void whenValidId_thenTodoItemShouldBeFound(){
        int id = 1;
        TodoItem found = todoItemService.getTodoItemById(id);

        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    public void whenIdNotValid_thenTodoItemShouldReturnNull(){
        int id = 2;
        TodoItem found = todoItemService.getTodoItemById(id);

        assertThat(found).isNull();
    }


}
