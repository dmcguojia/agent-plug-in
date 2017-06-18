package cn.com.agent.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.agent.bean.CardRateBean;
import cn.com.agent.dao.FeeDAO;
import cn.com.agent.dao.UserDAO;
import cn.com.agent.pojo.UserDO;
import cn.com.agent.utils.JsonUtils;
import cn.com.agent.utils.UserHelper;

@SuppressWarnings("all")
@Controller
@RequestMapping("/fee")
public class FeeController {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FeeDAO feeDAO;
	/**
	 * 新版卡类型扣率
	 * 
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月24日 上午10:27:01
	 * @version v1.0
	 */
	@RequestMapping("showNewCardRate")
	public ModelAndView showNewCardRate(String userId,HttpServletRequest request) {
		
		ModelAndView result = new ModelAndView(
				"/fee/rate_card_manager");
		UserDO user = userDAO.getUserById(Long.valueOf(userId));
		request.getSession().setAttribute("login_user", user);
		return result;
	}
	@RequestMapping("loadBusiPack")
	@ResponseBody
	public Object loadBusiPack(String busiPackStatus){
		return feeDAO.queryBusiPack(busiPackStatus);
	}
	
	/**
	 * 新卡扣率分页查询
	 * 
	 * @author: zhangshd
	 * @param cardRateEntity
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 * @return Map<String, Object>
	 * @date: 2017年2月24日 上午10:32:00
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryNewCardRate")
	public Map<String, Object> queryNewCardRate(CardRateBean cardRateEntity, String page, String rows,
			HttpServletRequest request, HttpServletResponse response) {
		cardRateEntity.setInuser(UserHelper.getCurrentUser(request).getUserId());
		return feeDAO.findNewCardRateByPage(cardRateEntity, page, rows);
	}

	/**
	 * 查询一条卡扣率版本实例信息
	 * 
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:33:00
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneCardRate")
	public Map<String, Object> queryOneCardRate(String caseid) {
		Map<String, Object> feecase = feeDAO.queryOneCardRate(caseid);
		//return feecase;
		return feecase;
	}
	
	/**
	 * 添加卡扣率信息
	 * 
	 * @param cardRateEntity
	 * @param request
	 * @param response
	 *            void
	 * @date: 2017年2月24日 上午10:35:08
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveCardRate")
	public String saveCardRate(CardRateBean cardRateEntity, HttpServletRequest request, HttpServletResponse response) {
		cardRateEntity.setInuser(UserHelper.getCurrentUser(request).getUserId());
		return feeDAO.addOneCardRate(cardRateEntity);
		//JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	@ResponseBody
	@RequestMapping("updateCardRate")
	public String updateCardRate(CardRateBean cardRateEntity, HttpServletRequest request, HttpServletResponse response) {
		cardRateEntity.setInuser(UserHelper.getCurrentUser(request).getUserId());
		return feeDAO.updateCardRate(cardRateEntity);
		//JsonUtils.json_encodeAndWrite(response, mark);
	}
	@ResponseBody
	@RequestMapping("queryFeeCaseByFeever")
	public Object queryFeeCaseByFeever(String feever){
		return feeDAO.queryFeeCase(feever);
	}
	@ResponseBody
	@RequestMapping("queryFeeCase")
	public Object queryFeeCase(String feever){
		return feeDAO.queryFeeCaseByName(feever);
	}
}
