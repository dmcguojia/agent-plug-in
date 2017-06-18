package cn.com.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.com.agent.bean.CardRateBean;
import cn.com.agent.dao.FeeDAO;
import cn.com.agent.dao.base.impl.HibernateBaseDAOImpl;

@Repository
public class FeeDAOImpl extends HibernateBaseDAOImpl<Object> implements FeeDAO {

	@Override
	public Map<String, Object> findNewCardRateByPage(
			CardRateBean cardRateEntity, String page, String rows) {

		String[] columns = new String[] { "v_feever", "v_busicode",
				"v_feename", "v_cardtype", "v_rate_type", "i_no", "i_perno" };
		Object[] paramaters = new Object[] {
				cardRateEntity.getFeever(),
				cardRateEntity.getBusicode(),
				null,
				cardRateEntity.getCardtype(), null, page, rows };
		return executePageOracleProcedure(
				"{CALL MODI_T_CARD_RATE.sel_t_card_rate(?,?,?,?,?,?,?,?,?)}",
				columns, paramaters, "cursor0", "v_total");
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<?> queryBusiPack(String status){
		String sql = "";
		if(status!=null&&status.equals("all")){
			sql = "select * from t_busi_pack ";
		}else {
			sql = "select * from t_busi_pack t where t.status=1 ";
		}
		SQLQuery query = (SQLQuery) getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	@Override
	@Transactional(readOnly=true)
	public List<?> queryFeeCase(String feever){
		String sql = "select b.* from t_busi_case b where b.busi_pack_code=(select a.busi_pack_code from  T_BUSI_PACK a where a.busi_pack_id=?)";
		SQLQuery query = (SQLQuery) getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		//query.setParameter(0, "00");
		query.setParameter(0, feever);
		return query.list();
	}

	@Override
	public Map<String, Object> queryOneCardRate(String caseid) {
		String[] columns = new String[] { "v_in"  };
		Object[] paramaters = new Object[] {Long.valueOf(caseid)};
		return executeOracleProcedure(
				"{CALL MODI_T_CARD_RATE.sel_t_card_date(?,?)}",
				columns, paramaters, "cursor0").get(0);
	}

	@Override
	@Transactional(readOnly=true)
	public Object queryFeeCaseByName(String feever) {
		String sql = "select b.* from t_busi_case b where b.busi_pack_code = ?";
		SQLQuery query = (SQLQuery) getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setParameter(0, feever);
		return query.list();
	}

	@Override
	public Map<String, Object> addOneCardRate(CardRateBean cardrate) {
		String[] columns = new String[] { 
				 "v_feever",
			      "v_busicode",
			      "v_cardtype",
			      "v_fee_rate",
			      "v_min_fee",
			      "v_max_fee",
			      "v_rate_type",
			      "v_inuser",
			      "v_notes",
			      "v_remarks"
		};
		Object[] paramaters = new Object[] { 
				cardrate.getFeever(), 
				cardrate.getBusicode(), 
				cardrate.getCardtype(),
				cardrate.getFeeRateStr(),
				cardrate.getMinFeeStr() == null ? "0" : cardrate.getMinFeeStr(),
				cardrate.getMaxFeeStr() == null ? "0" : cardrate.getMaxFeeStr(),
				cardrate.getRateType(),
				cardrate.getInuser(), 
				cardrate.getNotes(), 
				cardrate.getRemarks() };
		return executeOracleProcedure("{CALL MODI_T_CARD_RATE.ins_t_card_rate(?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
	}
	@Override
	public Map<String, Object> updateCardRate(CardRateBean cardrate) {
		Object[] paramaters = new Object[] { cardrate.getFeever(), cardrate.getBusicode(), cardrate.getCardtype(),
				cardrate.getFeeRateStr(), 
				cardrate.getMinFeeStr() == null ? "0" : cardrate.getMinFeeStr(),
				cardrate.getMaxFeeStr() == null ? "0" : cardrate.getMaxFeeStr(), cardrate.getRateType(),
				cardrate.getInuser(), cardrate.getNotes(), cardrate.getRemarks() };
		String[] columns = new String[] { "v_feever", "v_busicode", "v_cardtype", "v_fee_rate", "v_min_fee",
				"v_max_fee", "v_rate_type", "v_inuser", "v_notes", "v_remarks" };
		return executeOracleProcedure("{CALL MODI_T_CARD_RATE.upt_t_card_rate(?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
	}
}
