package com.example.libraryProject3.controller;

import com.example.libraryProject3.enums.Role;
import com.example.libraryProject3.models.User;
import com.example.libraryProject3.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testLockUserAsAdmin() throws Exception {
        when(userService.getUserByUsername("admin")).thenReturn(new User("admin","admin", Role.ADMIN));
 doNothing().when(userService).lockUser(1);
mockMvc.perform(put("/api/library/user/lock/1")
        .contentType(MediaType.APPLICATION_JSON)
        .header("username","admin"))
        .andExpect(status().isOk());
verify(userService,times(1)).lockUser(1);

    }
    @Test
    public void testLockUserAsReaderForbidden() throws Exception {
        when(userService.getUserByUsername("reader")).thenReturn(new User("reader", "reader", Role.READER));
        mockMvc.perform(put("/api/library/user/lock/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("username", "reader"))
                .andExpect(status().isForbidden());
        verify(userService, never()).lockUser(1);
    }
}
