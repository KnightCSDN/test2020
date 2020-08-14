import com.yhd.dao.UserMapper;
import com.yhd.dao.proxy.InProxy;
import com.yhd.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    @Test
    public void userTest(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        InProxy inProxy = new InProxy();
        UserMapper userMapper = (UserMapper)inProxy.getUserMapper(mapper);

        List<User> users = userMapper.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("查询结束！");
    }
}
