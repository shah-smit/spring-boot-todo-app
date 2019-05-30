package Service;

import com.yourname.Entity.AppUser;
import com.yourname.Entity.TodoItem;
import com.yourname.Repository.AppUserRepository;
import com.yourname.Repository.TodoItemRepository;
import com.yourname.Service.AppUserService;
import com.yourname.Service.Interface.IAppUserService;
import com.yourname.Service.TodoItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
public class AppUserServiceUnitTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public AppUserService appUserService() {
            return new AppUserService();
        }
    }

    @Autowired
    private IAppUserService appUserService;

    @MockBean
    private AppUserRepository appUserRepository;

    @Before
    public void setUp(){
        AppUser app = new AppUser("admin","admin","Smit","Shah","USER");
        app.setCreateDateTime(LocalDateTime.now());
        Mockito.when(appUserRepository.save(Mockito.any(AppUser.class))).thenReturn(app);
    }

    @Test
    public void abilityToCreateUser_shouldReturnTheSameUser(){
        AppUser app = new AppUser("admin","admin","Smit","Shah","USER");
        AppUser user = appUserService.createUser(app);

        assertThat(user.getCreateDateTime()).isNotNull();
    }

}

