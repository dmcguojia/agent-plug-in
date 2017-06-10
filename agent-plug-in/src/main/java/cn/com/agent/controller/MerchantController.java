package cn.com.agent.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.agent.bean.query.MerchantQueryBean;
import cn.com.agent.dao.MerchantDAO;
import cn.com.agent.dao.UserDAO;
import cn.com.agent.pojo.UserDO;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	private MerchantDAO merchantDAO;
	@Autowired
	private UserDAO userDAO;
	@ResponseBody
	@RequestMapping("/showManager")
	public ModelAndView showManager(String userId,HttpServletRequest request) {
		ModelAndView result = new ModelAndView(
				"/merchant/merchant_filing");
		UserDO user = userDAO.getUserById(Long.valueOf(userId));
		request.getSession().setAttribute("login_user", user);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/queryMerchant")
	public Map<String, Object> queryMerchant(MerchantQueryBean merchantQueryBean,Long page, Long rows,HttpServletRequest request){
		if(merchantQueryBean==null){
			merchantQueryBean = new MerchantQueryBean();
		}
		UserDO user = (UserDO) request.getSession().getAttribute("login_user");
		merchantQueryBean.setUserId(user.getUserId());
		return merchantDAO.queryMerchantByPage(merchantQueryBean, page, rows);
	}
}
