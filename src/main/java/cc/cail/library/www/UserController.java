package cc.cail.library.www;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.cail.library.service.UserService;

@Controller
public class UserController {

	final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String index(Model m) {
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
		logger.info("user login " + name + " : " + pwd);
		Map<String, String> result = new HashMap<String, String>();
		boolean logFlag = userService.login(name, pwd);
		logger.info("登录结果" + logFlag);
		result.put("result", logFlag ? "成功" : "失败");
		return result;
	}

}
