package cc.cail.library.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.cail.library.dao.entity.User;
import cc.cail.library.dao.entity.UserExample;
import cc.cail.library.dao.manager.UserMapper;
import cc.cail.library.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean login(String name, String pwd) {
		logger.info("login : " + name + " : " + pwd);
		/*按姓名和密码去数据库查询*/
		UserExample ex = new UserExample();
		ex.createCriteria().andNameEqualTo(name).andPwdEqualTo(pwd);
		List<User> users = userMapper.selectByExample(ex);
		/*----------------题外话----------------*/
		/* 上面我们看到了怎么用Example来拼条件去查询了，如果是按主键查询 */
		/*就按下面这样查询就行*/
		/*User user = userMapper.selectByPrimaryKey(1);*/
		/*相应的，delete update也可以这样，如果按条件去更新，比如把名字叫小明的升级到3年级，如下*/
		/*ex.clear();//清除签名and的条件
		ex.createCriteria().andNameEqualTo("小明");
		//这时ex是查询条件，那更新的年级怎么传呢，新建一个User
		User updateUser = new User();
		updateUser.setGrade("三年级");
		userMapper.updateByExampleSelective(updateUser, ex);*/
		//updateByExample 这里就是说以ex为条件updateUser传最新值，加上Selective的意思是只更新updateUser有的字段（grade)
		//不然就是按updateUser全部更新，我们的updateUser的id是null,name也是null,你懂得会发生什么
		/*----------------题外话结束----------------*/
		return users.size()>0;//返回是否存在此用户以确定是否登录成功
	}

}
