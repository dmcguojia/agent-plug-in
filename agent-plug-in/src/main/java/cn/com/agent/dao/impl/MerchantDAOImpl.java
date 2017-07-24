package cn.com.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.com.agent.bean.CreditCardRateBean;
import cn.com.agent.bean.DebitCardRateBean;
import cn.com.agent.bean.RateBean;
import cn.com.agent.bean.enums.SelfFeeTypeEnum;
import cn.com.agent.bean.query.MerchantQueryBean;
import cn.com.agent.dao.MerchantDAO;
import cn.com.agent.dao.base.impl.HibernateBaseDAOImpl;
import cn.com.agent.pojo.CardRateDO;
import cn.com.agent.pojo.CityDO;
import cn.com.agent.pojo.DedurateCaseDO;
import cn.com.agent.pojo.MccRateDO;
import cn.com.agent.pojo.MerchantDO;
import cn.com.agent.pojo.ProvinceDO;
import cn.com.agent.pojo.TxnRateDO;
import cn.com.agent.utils.BeanCopyUtil;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

@Repository
public class MerchantDAOImpl extends HibernateBaseDAOImpl<MerchantDO> implements MerchantDAO{

	private static final Logger logger = LoggerFactory.getLogger(MerchantDAOImpl.class);
	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> queryMerchantByPage(MerchantQueryBean merchantQueryBean,Long page,Long rows){
		Map<String, Object> returnMap = Maps.newHashMap();
		Criteria criteria2 = getSession().createCriteria(MerchantDO.class);
		Criteria criteria = getSession().createCriteria(MerchantDO.class);
		if(!StringUtils.isEmpty(merchantQueryBean.getMerchNo())){
			criteria.add(Restrictions.eq("merchNo",merchantQueryBean.getMerchNo()));
			criteria2.add(Restrictions.eq("merchNo",merchantQueryBean.getMerchNo()));
		}
		if(!StringUtils.isEmpty(merchantQueryBean.getMerchName())){
			criteria.add(Restrictions.like("merchName", "%"+merchantQueryBean.getMerchName()+"%"));
			criteria2.add(Restrictions.like("merchName", "%"+merchantQueryBean.getMerchName()+"%"));
		}
		criteria.add(Restrictions.eq("status", "00"));
		criteria.add(Restrictions.not(Restrictions.eq("backupStatus", "99")));
		criteria.addOrder(Order.desc("backupStatus"));
		criteria2.add(Restrictions.eq("status", "00"));
		criteria2.add(Restrictions.not(Restrictions.eq("backupStatus", "99")));
		criteria.setFirstResult((page.intValue() - 1) * rows.intValue());  
	    criteria.setMaxResults(rows.intValue()); 
	    
	    List<?> list = criteria.list();
	    
	    returnMap.put("total",criteria2.setProjection(Projections.rowCount()).uniqueResult());
        returnMap.put("rows", list);
		return returnMap;
	}

	@Override
	@Transactional(readOnly=true)
	public MerchantDO getMerchanByMerchNo(String merchNo) {
		Criteria criteria = getSession().createCriteria(MerchantDO.class);
		criteria.add(Restrictions.eq("merchNo", merchNo));
		return (MerchantDO) criteria.uniqueResult();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> queryBankInfo(String bankNode){
		SQLQuery sqlQuery = (SQLQuery) getSession().createSQLQuery("select * from t_bank_info t where t.bank_node=?").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		sqlQuery.setParameter(0, bankNode);
		Map<String, Object> uniqueResult = (Map<String, Object>) sqlQuery.uniqueResult();
		return uniqueResult;
	}
	@Override
	@Transactional(readOnly=true)
	public ProvinceDO queryProvinceById(long tid){
		Criteria criteria = getSession().createCriteria(ProvinceDO.class);
		criteria.add(Restrictions.eq("PId", tid));
		return (ProvinceDO) criteria.uniqueResult();
	}
	@Override
	@Transactional(readOnly=true)
	public CityDO queryCityById(long tid){
		Criteria criteria = getSession().createCriteria(CityDO.class);
		criteria.add(Restrictions.eq("CId", tid));
		return (CityDO) criteria.uniqueResult();
	}
	
	@Override
	@Transactional(readOnly=true)
	public RateBean getMerchantRate(String busiPackCode,String mcc){
		RateBean rateBean = null;
		Criteria criteria = getSession().createCriteria(DedurateCaseDO.class);
		criteria.add(Restrictions.eq("busiPackCode", busiPackCode));
		criteria.add(Restrictions.eq("busicode", "0201"));
		DedurateCaseDO dedurateCase = (DedurateCaseDO) criteria.uniqueResult();
		logger.info("dedurateCase:"+JSON.toJSONString(dedurateCase));
		criteria = null;
		SelfFeeTypeEnum selfFeeTypeEnum = SelfFeeTypeEnum.fromValue(dedurateCase.getSelfFeeType().toString());
		if(selfFeeTypeEnum==SelfFeeTypeEnum.free){
			rateBean = new RateBean();
			rateBean.setFeeRate(0.0);
			rateBean.setMaxFee(0.0);
			rateBean.setMinFee(0.0);
		}else if(selfFeeTypeEnum==SelfFeeTypeEnum.txn){
			criteria = getSession().createCriteria(TxnRateDO.class);
			criteria.add(Restrictions.eq("busipackcode", busiPackCode));
			criteria.add(Restrictions.eq("busicode", "0201"));
			TxnRateDO txnRateDO = (TxnRateDO) criteria.uniqueResult();
			logger.info("txnRateDO:"+JSON.toJSONString(txnRateDO));
			rateBean = BeanCopyUtil.copyBean(RateBean.class, txnRateDO);
		}else if(selfFeeTypeEnum==SelfFeeTypeEnum.mcc){
			criteria = getSession().createCriteria(MccRateDO.class);
			criteria.add(Restrictions.eq("busipackcode", busiPackCode));
			criteria.add(Restrictions.eq("mcc", mcc));
			MccRateDO mccRate = (MccRateDO) criteria.uniqueResult();
			logger.info("mccRate:"+JSON.toJSONString(mccRate));
			rateBean = BeanCopyUtil.copyBean(RateBean.class, mccRate);
		}else if(selfFeeTypeEnum==SelfFeeTypeEnum.card){
			rateBean = new RateBean();
			criteria = getSession().createCriteria(CardRateDO.class);
			criteria.add(Restrictions.eq("feever", org.apache.commons.lang.StringUtils.rightPad(busiPackCode, 8, " ")));
			criteria.add(Restrictions.eq("busicode", org.apache.commons.lang.StringUtils.rightPad("0201", 8, " ")));
			List<CardRateDO> cardRateList = criteria.list();
			logger.info("cardRateList:"+JSON.toJSONString(cardRateList));
			for(CardRateDO cardRate : cardRateList){
				if(cardRate.getCardtype()==1){//借记卡
					rateBean.setDebitCardRateBean(BeanCopyUtil.copyBean(DebitCardRateBean.class, cardRate));
				}else if(cardRate.getCardtype()==2){//贷记卡
					rateBean.setCreditCardRateBean(BeanCopyUtil.copyBean(CreditCardRateBean	.class, cardRate));
				}
			}
			//rateBean = BeanCopyUtil.copyBean(RateBean.class, mccRate);
		}
		rateBean.setSelfFeeTypeEnum(selfFeeTypeEnum);
		return rateBean;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateMerchantBackupStatus(String merchNo,String status){
		Query query = getSession().createQuery("update MerchantDO set backupStatus = ? where merchNo = ?");
		query.setParameter(0, status);
		query.setParameter(1, merchNo);
		query.executeUpdate();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateMerchantBackup(String merchNo,String status,String merchantId){
		Query query = getSession().createQuery("update MerchantDO set backupStatus = ?,merchantId = ? where merchNo = ?");
		query.setParameter(0, status);
		query.setParameter(1, merchantId);
		query.setParameter(2, merchNo);
		query.executeUpdate();
	}
}
