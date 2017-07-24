package cn.com.agent.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.agent.bean.BackupBean;
import cn.com.agent.bean.ResultBean;
import cn.com.agent.bean.query.MerchantQueryBean;
import cn.com.agent.dao.MerchantDAO;
import cn.com.agent.dao.UserDAO;
import cn.com.agent.pojo.UserDO;
import cn.com.agent.service.MerchantBackUpService;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	private MerchantDAO merchantDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private MerchantBackUpService merchantBackUpService;
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
	@ResponseBody
	@RequestMapping("/addBackupMerchant")
	public ResultBean backupAdd(BackupBean backupBean){
		//return merchantBackUpService.backupAddMerchant(backupBean.getMerchNo());
		return merchantBackUpService.backupAddMerchant(backupBean);
	}
	@ResponseBody
	@RequestMapping("/deleteBackupMerchant")
	public ResultBean backupDelete(String merchNo){
		return merchantBackUpService.backupDeleteMerchant(merchNo);
	}
	
	@ResponseBody
	@RequestMapping("/updateBackupMerchant")
	public ResultBean backupUpdate(BackupBean backupBean){
		//return merchantBackUpService.backupUpdateMerchant(backupBean.getMerchNo());
		return merchantBackUpService.backupUpdateMerchant(backupBean);
	}
	
	@ResponseBody
	@RequestMapping("/queryBackupMerchant")
	public ResultBean backupQuery(String merchNo){
		//return merchantBackUpService.backupAddMerchant(backupBean.getMerchNo());
		return merchantBackUpService.backupQueryMerchant(merchNo);
	}
}
