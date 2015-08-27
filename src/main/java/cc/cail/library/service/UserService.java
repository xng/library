package cc.cail.library.service;
/**
 * 
 * @author www.cail.cc
 *
 */
public interface UserService {
	/**
	 * @param name 姓名
	 * @param pwd 密码
	 * @return 成功失败
	 */
	public boolean login(String name, String pwd);
}
