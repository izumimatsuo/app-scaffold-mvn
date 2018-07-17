package example.controllers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class TasksControllerTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @WithMockUser
    public void test_タスク一覧画面が表示されること() throws Exception {
        mockMvc.perform(get("/tasks"))
            .andExpect(status().isOk())
            .andExpect(view().name("tasks/index"));
    }

    @Test
    @WithMockUser
    public void test_タスク詳細画面が表示されること() throws Exception {
        mockMvc.perform(get("/tasks/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("tasks/show"));
    }

    @Test
    @WithMockUser
    public void test_タスク登録画面が表示されること() throws Exception {
        mockMvc.perform(get("/tasks/add"))
            .andExpect(status().isOk())
            .andExpect(view().name("tasks/add"));
    }

    @Test
    @WithMockUser
    public void test_タスク登録して入力エラーとなること() throws Exception {
        mockMvc.perform(post("/tasks").with(csrf()))
            .andExpect(status().isOk())
            .andExpect(model().hasErrors())
            .andExpect(view().name("tasks/add"));
    }

    @Test
    @WithMockUser
    public void test_タスク登録して成功すること() throws Exception {
        mockMvc.perform(post("/tasks").with(csrf()).param("title", "テストを実行する").param("status", "未実行"))
            .andExpect(status().isFound())
            .andExpect(view().name("redirect:/tasks"));
    }

    @Test
    @WithMockUser
    public void test_タスク更新画面が表示されること() throws Exception {
        mockMvc.perform(get("/tasks/1/edit"))
            .andExpect(status().isOk())
            .andExpect(view().name("tasks/edit"));
    }

    @Test
    @WithMockUser
    public void test_タスク更新して入力エラーとなること() throws Exception {
        mockMvc.perform(put("/tasks/1").with(csrf()))
            .andExpect(status().isOk())
            .andExpect(model().hasErrors())
            .andExpect(view().name("tasks/edit"));
    }

    @Test
    @WithMockUser
    public void test_タスク更新して成功すること() throws Exception {
        mockMvc.perform(put("/tasks/1").with(csrf()).param("id", "1").param("title", "テストを実行する").param("status", "実行中"))
            .andExpect(status().isFound())
            .andExpect(view().name("redirect:/tasks/1"));
    }

    @Test
    @WithMockUser
    public void test_タスク削除して成功すること() throws Exception {
        mockMvc.perform(delete("/tasks/1").with(csrf()))
            .andExpect(status().isFound())
            .andExpect(view().name("redirect:/tasks"));
    }
}
