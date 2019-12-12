package com.smc.service;

import com.smc.entity.StockExchangeEntity;
import com.smc.repository.ExchangeRepository;
import com.smc.utils.CommonResult;
import com.smc.utils.ResponseCode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ExchangeService
 * @Description TODO
 * @Author Liker
 * @Date 12/4/2019 15:40 AM
 * @Version 1.0
 **/
@Service
public class ExchangeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExchangeRepository exchangeRepository;

	/**
	 * Description: query all exchange.
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 * @auther: Liker
	 * @date: 2019/12/04 10:39
	 */
	public CommonResult findAll() {
		try {
			List<StockExchangeEntity> exchange = exchangeRepository.findAll();
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", exchange);
		} catch (Exception e) {
			logger.error("Fail to query exchange data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	/**
	 * Description: query exchange by exchangename.
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 * @auther: Liker
	 * @date: 2019/12/04 10:39
	 */
	public CommonResult findByExchange(String exchange) {
		try {
			StockExchangeEntity stockExchange = exchangeRepository.findByExchange(exchange);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", stockExchange);
		} catch (Exception e) {
			logger.error("Fail to query exchange data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}


	/**
	 * Description: query exchange by exchangeid.
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 * @auther: Liker
	 * @date: 2019/12/04 10:39
	 */
	public CommonResult findById(int id) {
		try {
			StockExchangeEntity stockExchange = exchangeRepository.findById(id).get();
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", stockExchange);
		} catch (Exception e) {
			logger.error("Fail to query exchange data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

}
