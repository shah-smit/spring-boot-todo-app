package Service;

import com.yourname.Entity.AppUser;
import com.yourname.Exception.AppUserNotCreatedException;
import com.yourname.Exception.AppUserNotFoundException;
import com.yourname.Repository.AppUserRepository;
import com.yourname.Service.AppUserService;
import com.yourname.Service.Interface.IAppUserService;
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
import java.util.Optional;

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
        Mockito.when(appUserRepository.findById(app.getUsername())).thenReturn(Optional.of(app));
    }

    @Test
    public void abilityToCreateUser_shouldReturnTheSameUser() throws AppUserNotCreatedException {
        AppUser app = new AppUser("admin","admin","Smit","Shah","USER");
        AppUser user = appUserService.createUser(app);

        assertThat(user).isNotNull();
    }

    @Test
    public void abilityToCreateUser_shouldReturnWithCreatedAtDate() throws AppUserNotCreatedException {
        AppUser app = new AppUser("admin","admin","Smit","Shah","USER");
        AppUser user = appUserService.createUser(app);

        assertThat(user.getCreateDateTime()).isNotNull();
    }

    @Test
    public void updateAppUser_shouldReturnWithNewPassword() throws AppUserNotFoundException {
        AppUser app = new AppUser("admin","admin1","Smit","Shah","USER");
        AppUser user = appUserService.updateUser(app);

        assertThat(user.getPassword()).isEqualTo(app.getPassword());
    }

    @Test
    public void updateAppUserWithNullPassword_shouldNotChangeOldPassword() throws AppUserNotFoundException {
        AppUser app = new AppUser("admin",null,"Smit","Shah","USER");
        AppUser user = appUserService.updateUser(app);

        assertThat(user.getPassword()).isNotNull();
    }

    @Test
    public void updateAppUser_shouldReturnWithNewRole() throws AppUserNotFoundException {
        AppUser app = new AppUser("admin","admin","Smit","Shah","ADMIN");
        AppUser user = appUserService.updateUser(app);

        assertThat(user.getRole()).isEqualTo(app.getRole());
    }

    @Test
    public void updateAppUser_shouldReturnWithNewFirstName() throws AppUserNotFoundException {
        AppUser app = new AppUser("admin","admin","Smit","Shah","ADMIN");
        AppUser user = appUserService.updateUser(app);

        assertThat(user.getRole()).isEqualTo(app.getRole());
    }

    @Test
    public void deleteAppUserWithInValidId_shouldThrowAppUserNotFoundException(){
        String id = "admin1";
        try {
            appUserService.deleteUser(id);
        } catch (AppUserNotFoundException e) {
            assertThat(e).hasNoCause();
        }
    }

    @Test
    public void updateAppUserWithInValidId_shouldThrowAppUserNotFoundException(){
        AppUser app = new AppUser("admin1","admin","Smit","Shah","USER");
        try {
            appUserService.updateUser(app);
        } catch (AppUserNotFoundException e) {
            assertThat(e).hasNoCause();
        }
    }

    @Test
    public void findAppUserWithInValidId_shouldThrowAppUserNotFoundException(){
        String id = "admin1";
        try {
            appUserService.findById(id);
        } catch (AppUserNotFoundException e) {
            assertThat(e).hasNoCause();
        }
    }

}

