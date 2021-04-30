package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(102);
        System.out.println(user);

        user = userMapper.selectByName("guanyu");
        System.out.println(user);
    }

    @Test
    public void testDiscusspost(){
        List<DiscussPost> discussPostList = discussPostMapper.selectDiscussPost(149,0,10);
        for(DiscussPost discussPost :discussPostList ){
            System.out.println(discussPost);
        }
        int count = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(count);
    }
}
