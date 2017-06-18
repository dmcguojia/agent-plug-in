package cn.com.agent.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.agent.bean.ResultBean;
import cn.com.agent.bean.query.MerchantQueryBean;
import cn.com.agent.bean.query.TermQueryBean;
import cn.com.agent.dao.FinaPosDAO;
import cn.com.agent.dao.UserDAO;
import cn.com.agent.pojo.UserDO;
import cn.com.agent.service.TermPOSBackUpService;

@Controller
@RequestMapping("/term")
public class TermController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FinaPosDAO finaPosDAO;
	@Autowired
	private TermPOSBackUpService termPOSBackUpService;
	
	@ResponseBody
	@RequestMapping("/showManager")
	public ModelAndView showManager(String userId,HttpServletRequest request) {
		ModelAndView result = new ModelAndView(
				"/term/term_filing");
		UserDO user = userDAO.getUserById(Long.valueOf(userId));
		request.getSession().setAttribute("login_user", user);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/queryTerm")
	public Map<String, Object> queryMerchant(TermQueryBean termQueryBean,int page, int rows,HttpServletRequest request){
		if(termQueryBean==null){
			termQueryBean = new TermQueryBean();
		}
		UserDO user = (UserDO) request.getSession().getAttribute("login_user");
		termQueryBean.setUserId(user.getUserId());
		return finaPosDAO.queryTermByPage(termQueryBean, page, rows);
	}
	
	@ResponseBody
	@RequestMapping("/addBackupTerm")
	public ResultBean backupAdd(String termNo){
		return termPOSBackUpService.backupAddTermPOS(termNo);
	}
	@ResponseBody
	@RequestMapping("/deleteBackupTerm")
	public ResultBean backupDelete(String termNo){
		return termPOSBackUpService.backupDeleteTermPOS(termNo);
	}
	
	@ResponseBody
	@RequestMapping("/updateBackupTerm")
	public ResultBean backupUpdate(String termNo){
		return termPOSBackUpService.backupUpdateTermPOS(termNo);
	}
}
